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
    public void testSameWords() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(0, algorithm.calc("book", "book"));
    }

    @Test
    public void testEmptyStringAsFirstParameter() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(4, algorithm.calc("", "book"));
    }

    @Test
    public void testEmptyStringAsSecondParameter() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(4, algorithm.calc("book", ""));
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

    @Test
    public void testDeleteAtEnd() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("book", "boo"));
    }

    @Test
    public void testDeleteAtBeginning() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("book", "ook"));
    }

    @Test
    public void testInfixDeletion() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("book", "bok"));
    }

    @Test
    public void testReplacementAtEnd() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("book", "boot"));
    }

    @Test
    public void testReplacementAtBeginning() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("book", "took"));
    }

    @Test
    public void testInfixReplacement() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(1, algorithm.calc("book", "brok"));
    }

    @Test
    public void testDifferentWordsSameLength() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(4, algorithm.calc("book", "take"));
    }

    @Test
    public void testDifferentWords() {
        IStringDistance algorithm = new LevenshteinDistance();
        Assert.assertEquals(5, algorithm.calc("book", "apple"));
    }
}
