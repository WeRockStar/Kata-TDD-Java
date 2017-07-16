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
        List<String> segments = parse.parse(template);
        StringBuilder builder = new StringBuilder();
        for (String segment : segments) {
            append(segment, builder);
        }
        return builder.toString();
    }

    private void append(String segment, StringBuilder builder) {
        if (segment.startsWith("${") && segment.endsWith("}")) {
            int beginIndexOfValue = 2;
            int endIndexOfValue = segment.length() - 1;

            String value = segment.substring(beginIndexOfValue, endIndexOfValue);
            if (!variables.containsKey(value)) {
                throw new MissingValueException("No value for " + segment);
            }
            builder.append(variables.get(value));
        } else {
            builder.append(segment);
        }
    }
}
