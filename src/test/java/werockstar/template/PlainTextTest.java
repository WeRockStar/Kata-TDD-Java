package werockstar.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PlainTextTest {

    @Test
    public void plain_text_evaluate_as_in() throws Exception {
        Map<String, String> variable = new HashMap<>();

        String text = "abc def";

        assertEquals(text, new PlainText(text).evaluate(variable));
    }
}