package crooked.api;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/crooked")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {

    private final String redisHost;

    public DataResource(String redisHost) {
        this.redisHost = redisHost;
    }

    @GET
    @Timed
    public String sayHello() {
        return "hello-japa";
    }
}
