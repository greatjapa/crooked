package crooked.algorithm;

import org.junit.Assert;
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

    @Test
    public void testEqualWords() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(0, algorithm.calc("book", "book"));
    }

    @Test
    public void testInsertionAtEnd() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("boo", "book"));
    }

    @Test
    public void testInsertionAtBeginning() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("ook", "book"));
    }

    @Test
    public void testInfixInsertion() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("bok", "book"));
    }
}
