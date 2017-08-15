package crooked.api;

import com.google.common.base.Optional;

import com.codahale.metrics.annotation.Timed;

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
        this.storage = storage;
        this.algorithm = algorithm;
    }

    @POST
    @Timed
    @Path("store/{word}")
    public Response store(@PathParam("word") String word) {
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
                            @QueryParam("threshold") Optional<Integer> threshold) {
        int limit = threshold.or(3);
        return storage.getWords().stream()
                .filter(w -> algorithm.calc(word, w) < limit)
                .collect(Collectors.toSet());
    }
}
