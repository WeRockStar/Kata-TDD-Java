package werockstar.template;

import java.util.Map;

public class Variable implements Segment {
    private String value;

    public Variable(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        return value.equals(((Variable) other).value);
    }

    @Override
    public String evaluate(Map<String, String> variable) {
        return null;
    }
}
