package werockstar.template;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TemplateParseTest {

    private List<String> parse(String template) {
        return new TemplateParse().parse(template);
    }

    private void assertSegments(List<? extends Object> actual, Object... expected) {
        assertEquals("Number of segments", expected.length, actual.size());
        assertEquals(Arrays.asList(expected), actual);
    }

    @Test
    public void parsing_template_into_segment_object() throws Exception {
        TemplateParse parse = new TemplateParse();
        List<Segment> segments = parse.parseSegments("a ${b} c ${d}");
        assertSegments(segments,
                new PlainText("a "), new Variable("b"),
                new PlainText(" c "), new Variable("d")
        );
    }

    @Test
    public void parsing_multiple_variables() throws Exception {
        List<String> segments = parse("${a}:${b}:${c}");
        assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
    }

    @Test
    public void empty_template_renders_as_empty_string() throws Exception {
        List<String> segments = parse("");
        assertSegments(segments, "");
    }

    @Test
    public void template_with_only_plain_text() throws Exception {
        List<String> segments = parse("plain text only");
        assertSegments(segments, "plain text only");
    }
}
