import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhaoran on 9/23/14.
 */
public class WordWrapTest {
    @Test(expected = IllegalArgumentException.class)
    public void null_should_throw_exception() {
        WordWrap.wrap(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_column_should_throw_exception() throws Exception {
        WordWrap.wrap("", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_column_should_throw_exception() throws Exception {
        WordWrap.wrap("", 0);
    }

    @Test
    public void empty_word_should_empty() {
        assertEquals("", WordWrap.wrap("", 2));
    }

    @Test
    public void _1_word_length_less_than_column_should_not_wrap() {
        assertEquals("word", WordWrap.wrap("word", 5));
    }

    @Test
    public void _1_word_length_equals_column_should_not_wrap() {
        assertEquals("word", WordWrap.wrap("word", 4));
    }

    @Test
    public void wrap_1_word_once() {
        assertEquals("wo\nrd", WordWrap.wrap("word", 2));
    }

    @Test
    public void wrap_1_word_multiple_times() throws Exception {
        assertEquals("w\no\nr\nd", WordWrap.wrap("word", 1));
    }

    @Test
    public void wrap_2_words_once() throws Exception {
        assertEquals("word\nword", WordWrap.wrap("word word", 6));
    }

    @Test
    public void wrap_2_words_multiple_times() throws Exception {
        assertEquals("wor\nd\nwor\nd", WordWrap.wrap("word word", 3));
    }

    @Test
    public void wrap_3_words_once() throws Exception {
        assertEquals("word word\nword", WordWrap.wrap("word word word", 9));
    }
}
