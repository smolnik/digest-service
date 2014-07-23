package net.adamsmolnik.boundary.digest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.adamsmolnik.control.digest.Digest;
import net.adamsmolnik.model.digest.DigestRequest;
import net.adamsmolnik.model.digest.DigestResponse;

/**
 * @author ASmolnik
 *
 */
@Path("/ds")
@RequestScoped
public class DigestService {

    @Inject
    private Digest digest;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("digest")
    public String digest(@FormParam("algorithm") String algorithm, @FormParam("objectKey") String objectKey) {
        return digest.doDigest(algorithm, objectKey);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("digest")
    public DigestResponse digest(DigestRequest digestRequest) {
        return new DigestResponse(digest.doDigest(digestRequest.algorithm, digestRequest.objectKey));
    }

}
