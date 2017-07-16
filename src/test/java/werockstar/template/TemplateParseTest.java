package werockstar.template;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TemplateParseTest {

    @Test
    public void empty_template_renders_as_empty_string() throws Exception {
        TemplateParse parse = new TemplateParse();
        List<String> segments = parse.parse("");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("", segments.get(0));
    }
}
