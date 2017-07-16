package werockstar.template;

public class Variable implements Segment {
    private String value;

    public Variable(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        return value.equals(((Variable) other).value);
    }

}
