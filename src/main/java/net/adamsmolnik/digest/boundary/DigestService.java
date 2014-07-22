package net.adamsmolnik.digest.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.adamsmolnik.digest.control.Digest;
import net.adamsmolnik.digest.model.DigestRequest;
import net.adamsmolnik.digest.model.DigestResponse;

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
        return digest.digest(algorithm, objectKey);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("digest")
    public DigestResponse digest(DigestRequest digestRequest) {
        return new DigestResponse(digest.digest(digestRequest.algorithm, digestRequest.objectKey));
    }

}
