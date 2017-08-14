package crooked.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

import crooked.algorithm.IStringDistance;
import crooked.algorithm.LevenshteinDistance;
import io.dropwizard.Configuration;

/**
 * The object created from config.yml
 *
 * @author Marcelo Oikawa
 */
public class CrookedConfiguration extends Configuration {

    private static final String LEVENSHTEIN = "levenshtein";

    @NotEmpty
    private String redisHost;

    @NotEmpty
    private String algorithm;

    @JsonProperty
    public String getRedisHost() {
        return redisHost;
    }

    @JsonProperty
    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    @JsonProperty
    public String getAlgorithm() {
        return algorithm;
    }

    @JsonProperty
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public IStringDistance getAlgorithmImpl() {
        switch (algorithm) {
            case LEVENSHTEIN:
            default:
                return new LevenshteinDistance();
        }
    }
}
