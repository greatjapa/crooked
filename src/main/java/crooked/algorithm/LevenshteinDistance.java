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

        int[][] distance = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i <= first.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 1; j <= second.length(); j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {

                distance[i][j] = min(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((first.charAt(i - 1) == second.charAt(j - 1)) ? 0 : 1));
            }
        }
        return distance[first.length()][second.length()];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
