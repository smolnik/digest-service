package net.adamsmolnik.control.digest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;
import net.adamsmolnik.entity.Entity;
import net.adamsmolnik.entity.EntityReference;
import net.adamsmolnik.exceptions.ServiceException;
import net.adamsmolnik.provider.EntityProvider;
import net.adamsmolnik.setup.ServiceNameResolver;
import net.adamsmolnik.util.Configuration;

@Dependent
public class Digest {

    @Inject
    private Configuration conf;

    @Inject
    private EntityProvider entityProvider;

    @Inject
    private ServiceNameResolver snr;

    private int limitForDigest;

    @PostConstruct
    void init() {
        limitForDigest = Integer.valueOf(conf.getServiceValue(snr.getServiceName(), "limitForDigest"));
    }

    public String doDigest(String algorithm, String objectKey) {
        Entity entity = entityProvider.getEntity(new EntityReference(objectKey));
        try (InputStream is = entity.getInputStream()) {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            return DatatypeConverter.printHexBinary(md.digest(getBytes(is, limitForDigest)));
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new ServiceException(e);
        }
    }

    private byte[] getBytes(InputStream is, int limit) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[8192];
        int bytesRead = 0;
        int limitFender = 0;
        try {
            while ((bytesRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, bytesRead);
                limitFender = +bytesRead;
                if (limitFender > limit) {
                    return buffer.toByteArray();
                }
            }
            buffer.flush();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return buffer.toByteArray();

    }
}
