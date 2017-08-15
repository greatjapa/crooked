package crooked.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

import crooked.algorithm.IStringDistance;
import crooked.algorithm.LevenshteinDistance;
import crooked.storage.IStorage;
import crooked.storage.InMemory;
import crooked.storage.RedisStorage;
import io.dropwizard.Configuration;

/**
 * The config.yml content as object.
 *
 * @author Marcelo Oikawa
 */
public class Conf extends Configuration {

    private static final String LEVENSHTEIN = "levenshtein";
    private static final String IN_MEMORY = "inMemory";
    private static final String REDIS = "redis";

    @NotEmpty
    private String storage;

    private String redisHost;

    @NotEmpty
    private String algorithm;

    @JsonProperty
    public String getStorage() {
        return storage;
    }

    @JsonProperty
    public void setStorage(String storage) {
        this.storage = storage;
    }

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

    public IStorage getStorageImpl() {
        switch (storage) {
            // Add more cases if you want to
            // register another storage implementation
            case REDIS:
                return new RedisStorage(redisHost);
            case IN_MEMORY:
            default:
                return new InMemory();
        }
    }

    public IStringDistance getAlgorithmImpl() {
        switch (algorithm) {
            // Add more cases if you want to
            // register another algorithm implementation
            case LEVENSHTEIN:
            default:
                return new LevenshteinDistance();
        }
    }
}
