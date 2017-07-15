package com.werockstar.template;

import java.util.HashMap;
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
        String result = replaceVariable();
        checkMissingValue(result);
        return result;
    }

    private String replaceVariable() {
        String resultTemplate = template;
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            resultTemplate = resultTemplate.replaceAll(regex, entry.getValue());
        }
        return resultTemplate;
    }

    private void checkMissingValue(String resultTemplate) {
        Matcher matcher = Pattern.compile(".*\\$\\{.+\\}.*").matcher(resultTemplate);
        if (matcher.find()) {
            throw new MissingValueException("No value for " + matcher.group());
        }
    }
}
