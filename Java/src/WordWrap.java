/**
 * Created by zhaoran on 9/23/14.
 */
public class WordWrap {
    public static String wrap(String word, int column) {
        if (null == word) {
            throw new IllegalArgumentException("word should not be null!");
        }
        if (column <= 0) {
            throw new IllegalArgumentException("column should not be negative!");
        }

        if (word.length() > column) {
            int index = word.lastIndexOf(" ", column);
            if (index != -1) {
                return doWrap(word, index, index + 1, column);
            } else {
                return doWrap(word, column, column, column);
            }
        }

        return word;
    }

    private static String doWrap(String word, int leftTailIndex, int rightHeaderIndex, int column) {
        return word.substring(0, leftTailIndex) + '\n' + WordWrap.wrap(word.substring(rightHeaderIndex), column);
    }
}
