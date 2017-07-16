package werockstar.template;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
    Spike for learning an API
 */
public class RegexLearningTest {

    @Test
    public void find_start_and_end() throws Exception {
        String hayStack = "The needle shop sells needles";
        String regex = "(needle)";

        Matcher matcher = Pattern.compile(regex).matcher(hayStack);

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 1st match", 4, matcher.start());
        assertEquals("Wrong end index of 1st match", 10, matcher.end());

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 2nd match", 22, matcher.start());
        assertEquals("Wrong end index of 2dn match", 28, matcher.end());

        assertFalse("Shouldn't match any more", matcher.find());
    }

    @Test
    public void how_group_count_works() throws Exception {
        String hayStack = "The needle shop sells needles";
        String regex = "(needle)";

        Matcher matcher = Pattern.compile(regex).matcher(hayStack);

        assertEquals(1, matcher.groupCount());
    }
}
