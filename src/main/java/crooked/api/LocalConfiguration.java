package crooked.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

/**
 * The object created from config.yml
 *
 * @author Marcelo Oikawa
 */
public class LocalConfiguration extends Configuration {

    @NotEmpty
    private String redisHost;

    @JsonProperty
    public String getRedisHost() {
        return redisHost;
    }

    @JsonProperty
    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }
}
