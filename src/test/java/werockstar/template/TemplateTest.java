package werockstar.template;

import com.werockstar.template.Template;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateTest {

    @Test
    public void one_variable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.getEvaluate());
    }

    @Test
    public void difference_variable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "someone else");
        assertEquals("Hello, someone else", template.getEvaluate());
    }
}
