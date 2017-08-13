package crooked.api;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import redis.clients.jedis.Jedis;

@Path("/crooked")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {

    private final String redisHost;
    private final Jedis jedis;

    private static final String WORDS_KEY = "CROOKED:WORDS";

    public DataResource(String redisHost) {
        this.redisHost = redisHost;
        this.jedis = new Jedis(redisHost);
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
}
