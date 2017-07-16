package werockstar.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {

    private Map<String, String> variables;
    private String template;

    public Template(String template) {
        this.variables = new HashMap<>();
        this.template = template;
    }

    public void set(String name, String value) {
        this.variables.put(name, value);
    }

    public String evaluate() {
        TemplateParse parse = new TemplateParse();
        List<Segment> segments = parse.parseSegments(template);
        return concatenate(segments);
    }

    private String concatenate(List<Segment> segments) {
        StringBuilder builder = new StringBuilder();
        for (Segment segment : segments) {
            builder.append(segment.evaluate(variables));
        }
        return builder.toString();
    }
}
