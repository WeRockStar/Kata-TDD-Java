package com.werockstar.template;

public class Template {

    private String value;

    public Template(String template) {
    }

    public void set(String variable, String value) {
        this.value = value;
    }

    public String getEvaluate() {
        return "Hello, " + value;
    }
}
