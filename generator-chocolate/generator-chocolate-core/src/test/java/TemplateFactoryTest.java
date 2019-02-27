import com.mask.core.io.TemplateFactory;
import freemarker.template.Template;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TemplateFactoryTest {

    TemplateFactory templateFactory = new TemplateFactory();

    @Test
    public void getTemplateTest() {

        Template template = templateFactory.getTemplate("sample.ftl");

        Assert.assertNotNull("Got a template",template);
        Assert.assertNotNull("Template is right!", template.getName());
    }

    @Test
    public void showTemplateTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "Mask");
        templateFactory.showTemplate(map, "sample.ftl");
    }
}
