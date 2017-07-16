package werockstar.template;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TemplateParseTest {

    private List<String> parse(String template) {
        return new TemplateParse().parse(template);
    }

    @Test
    public void empty_template_renders_as_empty_string() throws Exception {
        List<String> segments = parse("");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("", segments.get(0));
    }

    @Test
    public void template_with_only_plain_text() throws Exception {
        List<String> segments = parse("plain text only");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("plain text only", segments.get(0));
    }
}
