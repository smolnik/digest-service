package net.adamsmolnik.digest.model;

import net.adamsmolnik.model.ServiceMessage;

/**
 * @author ASmolnik
 *
 */
public class DigestRequest extends ServiceMessage {

    public DigestRequest(String algorithm, String objectKey) {
        this.algorithm = algorithm;
        this.objectKey = objectKey;
    }

    public DigestRequest() {
    }

    public String algorithm;

    public String objectKey;

}
