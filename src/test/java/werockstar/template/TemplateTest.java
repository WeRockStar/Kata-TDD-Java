package werockstar.template;

import com.werockstar.template.MissingValueException;
import com.werockstar.template.Template;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateTest {

    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test(expected = MissingValueException.class)
    public void missing_value_should_raises_exception() throws Exception {
        new Template("${foo}").evaluate();
    }

    @Test
    public void unknown_variable_should_ignored() throws Exception {
        template.set("unknown", "ignored");

        String actualEvaluate = template.evaluate();

        assertEquals("1, 2, 3", actualEvaluate);
    }

    @Test
    public void should_see_reader_be_WeRockStar() throws Exception {
        template = new Template("Hello, ${name}");
        template.set("name", "WeRockStar");
        template.set("unknown", "ignored");

        String actualEvaluate = template.evaluate();

        assertEquals("Hello, WeRockStar", actualEvaluate);
    }

    @Test
    public void add_multiple_variable_should_see_variable_multiple_display() throws Exception {
        String actualEvaluate = template.evaluate();

        assertEquals("1, 2, 3", actualEvaluate);
    }
}
