package werockstar.template;

import java.util.ArrayList;
import java.util.List;

public class TemplateParse {
    private List<String> segments = new ArrayList<>();

    public List<String> parse(String segment) {
        this.segments.add(segment);
        return this.segments;
    }
}
