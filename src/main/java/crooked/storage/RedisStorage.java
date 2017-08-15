package crooked.storage;

import java.util.Objects;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * This implementation for {@link IStorage} holds data a Redis server.
 *
 * @author Marcelo Oikawa
 */
public class RedisStorage implements IStorage {

    private Jedis jedis;

    private static final String WORDS_KEY = "CROOKED:WORDS";

    public RedisStorage(String redisHost) {
        Objects.requireNonNull(redisHost, "redisHost should not be null.");
        this.jedis = new Jedis(redisHost);
    }

    @Override
    public void store(String word) {
        jedis.sadd(WORDS_KEY, word);
    }

    @Override
    public Set<String> getWords() {
        return jedis.smembers(WORDS_KEY);
    }
}
