package crooked.storage;

import java.util.Set;

/**
 * Define API for storage.
 *
 * @author Marcelo Oikawa
 */
public interface IStorage {

    /**
     * Store word.
     *
     * @param word word.
     */
    void store(String word);

    /**
     * @return all words.
     */
    Set<String> getWords();
}
