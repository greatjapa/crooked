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
import crooked.algorithm.LevenshteinDistance;
import redis.clients.jedis.Jedis;

@Path("/crooked")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {

    private final String redisHost;
    private final Jedis jedis;
    private final IStringDistance algorithm;

    private static final String WORDS_KEY = "CROOKED:WORDS";

    public DataResource(String redisHost) {
        this.redisHost = redisHost;
        this.jedis = new Jedis(redisHost);
        this.algorithm = new LevenshteinDistance();
    }

    @GET
    @Timed
    public String sayHello() {
        return "crooked online";
    }

    @POST
    @Timed
    @Path("store/{word}")
    public Response store(@PathParam("word") String word) {
        jedis.sadd(WORDS_KEY, word);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Timed
    @Path("show")
    public Set<String> show() {
        return jedis.smembers(WORDS_KEY);
    }

    @GET
    @Timed
    @Path("similar")
    public Set<String> similar(@QueryParam("word") String word, @QueryParam("threshold") Optional<Integer> threshold) {
        int limit = threshold.or(3);
        return jedis.smembers(WORDS_KEY).stream()
                .filter(w -> algorithm.calc(word, w) < limit)
                .collect(Collectors.toSet());
    }
}
