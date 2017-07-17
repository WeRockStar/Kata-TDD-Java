package werockstar.template;

import java.util.Map;

public class PlainText implements Segment {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainText)) return false;

        PlainText plainText = (PlainText) o;

        return text.equals(plainText.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public String evaluate(Map<String, String> variable) {
        return text;
    }
}
