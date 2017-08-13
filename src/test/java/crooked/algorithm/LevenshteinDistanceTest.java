package crooked.algorithm;

import org.junit.Test;

/**
 * Unit test for {@link LevenshteinDistance}.
 *
 * @author Marcelo Oikawa
 */
public class LevenshteinDistanceTest {

    @Test(expected = NullPointerException.class)
    public void testNullAsFirstParameter() {
        new LevenshteinDistance().calc(null, "book");
    }

    @Test(expected = NullPointerException.class)
    public void testNullAsSecondParameter() {
        new LevenshteinDistance().calc("book", null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullParameters() {
        new LevenshteinDistance().calc(null, null);
    }
}
