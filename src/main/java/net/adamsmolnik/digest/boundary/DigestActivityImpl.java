package net.adamsmolnik.digest.boundary;
import net.adamsmolnik.digest.boundary.DigestActivity;
import net.adamsmolnik.digest.control.Digest;

/**
 * @author ASmolnik
 *
 */
public class DigestActivityImpl implements DigestActivity {

    private final Digest digestImpl;

    public DigestActivityImpl(Digest digest) {
        this.digestImpl = digest;
    }

    @Override
    public String digest(String algorithm, String objectKey) {
        return this.digestImpl.digest(algorithm, objectKey);
    }

}
