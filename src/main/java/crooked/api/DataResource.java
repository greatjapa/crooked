package crooked.api;

import com.codahale.metrics.annotation.Timed;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import crooked.algorithm.IStringDistance;
import crooked.storage.IStorage;

@Path("/crooked")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {

    private final IStorage storage;
    private final IStringDistance algorithm;


    public DataResource(IStorage storage, IStringDistance algorithm) {
        Objects.requireNonNull(storage, "storage should not be null.");
        Objects.requireNonNull(algorithm, "algorithm should not be null.");
        this.storage = storage;
        this.algorithm = algorithm;
    }

    @POST
    @Timed
    @Path("store/{word}")
    public Response store(@PathParam("word") String word) {
        if (word == null || word.isEmpty()) {
            return Response.status(Response.Status.PRECONDITION_FAILED).build();
        }
        storage.store(word);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Timed
    @Path("show")
    public Set<String> show() {
        return storage.getWords();
    }

    @GET
    @Timed
    @Path("find")
    public Set<String> find(@QueryParam("word") String word,
                            @QueryParam("threshold") Integer threshold) {
        if (word == null) {
            return Collections.emptySet();
        }

        int limit = threshold == null || threshold < 0 ? 3 : threshold;
        return storage.getWords().stream()
                .filter(w -> algorithm.calc(word, w) < limit)
                .collect(Collectors.toSet());
    }
}
