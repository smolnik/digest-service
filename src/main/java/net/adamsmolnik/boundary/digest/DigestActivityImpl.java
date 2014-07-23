package net.adamsmolnik.boundary.digest;

import net.adamsmolnik.boundary.digest.DigestActivity;
import net.adamsmolnik.control.digest.Digest;
import net.adamsmolnik.model.digest.DigestRequest;
import net.adamsmolnik.model.digest.DigestResponse;

/**
 * @author ASmolnik
 *
 */
public class DigestActivityImpl implements DigestActivity {

    private final Digest digest;

    public DigestActivityImpl(Digest digest) {
        this.digest = digest;
    }

    @Override
    public DigestResponse digest(DigestRequest digestRequest) {
        return new DigestResponse(this.digest.doDigest(digestRequest.algorithm, digestRequest.objectKey));
    }

}
