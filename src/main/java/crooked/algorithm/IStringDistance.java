package crooked.algorithm;

/**
 * Define calc method for {@link String} distance algorithms;
 *
 * @author Marcelo Oikawa
 */
public interface IStringDistance {

    /**
     * Calc the distance between two words.
     *
     * @param first  word.
     * @param second word.
     * @return distance.
     */
    int calc(String first, String second);
}
