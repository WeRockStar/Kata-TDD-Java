package com.werockstar.template;

public class Template {

    private String value;
    private String template;

    public Template(String template) {
        this.template = template;
    }

    public void set(String variable, String value) {
        this.value = value;
    }

    public String getEvaluate() {
        return template.replaceAll("\\$\\{name\\}", value);
    }
}
