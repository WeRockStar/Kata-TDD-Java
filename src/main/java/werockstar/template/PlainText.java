package werockstar.template;

public class PlainText implements Segment {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        return text.equals(((PlainText) o).text);
    }

}
