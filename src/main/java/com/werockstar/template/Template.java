package com.werockstar.template;

import java.util.HashMap;
import java.util.Map;

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

    public String getEvaluate() {
        String result = template;
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }
}
