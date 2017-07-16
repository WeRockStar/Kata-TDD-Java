package werockstar.template;

import java.util.Map;

public class PlainText implements Segment {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        return text.equals(((PlainText) o).text);
    }

    @Override
    public String evaluate(Map<String, String> variable) {
        return text;
    }
}
