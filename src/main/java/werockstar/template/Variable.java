package werockstar.template;

import java.util.Map;

public class Variable implements Segment {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;

        Variable variable = (Variable) o;

        return name.equals(variable.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String evaluate(Map<String, String> variable) {
        if (!variable.containsKey(name)) {
            throw new MissingValueException("No value for ${" + name + "}");
        }
        return variable.get(name);
    }
}
