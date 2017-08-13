package crooked.algorithm;

import java.util.Objects;

/**
 * @author Marcelo Oikawa
 */
public class LevenshteinDistance implements IStringDistance {

    @Override
    public int calc(String first, String second) {
        Objects.requireNonNull(first, "first word should not be null.");
        Objects.requireNonNull(second, "second word should not be null.");

        return 0;
    }
}
