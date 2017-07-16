package werockstar.template;

import java.util.Map;

public interface Segment {

    String evaluate(Map<String, String> variable);
}
