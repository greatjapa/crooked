package crooked.storage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The most simple implementation for {@link IStorage} that holds data in memory.
 *
 * @author Marcelo Oikawa
 */
public class InMemory implements IStorage {

    private Set<String> values;

    public InMemory() {
        this.values = new HashSet<>();
    }

    @Override
    public void store(String word) {
        values.add(word);
    }

    @Override
    public Set<String> getWords() {
        return Collections.unmodifiableSet(values);
    }
}
