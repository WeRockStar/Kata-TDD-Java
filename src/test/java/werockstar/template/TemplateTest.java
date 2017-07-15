package werockstar.template;

import com.werockstar.template.Template;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateTest {

    @Test
    public void should_see_reader_be_Reader() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.getEvaluate());
    }

    @Test
    public void should_see_reader_be_someone_else() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "someone else");
        assertEquals("Hello, someone else", template.getEvaluate());
    }

    @Test
    public void should_see_reader_be_WeRockStar() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "WeRockStar");
        assertEquals("Hello, WeRockStar", template.getEvaluate());
    }
}
