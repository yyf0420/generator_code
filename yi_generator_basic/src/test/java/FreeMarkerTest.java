import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("myweb.html.ftl");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear",2024);
        ArrayList<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url","https://www.baidu.com/");
        menuItem1.put("label","百度");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url","https://github.com/");
        menuItem2.put("label","git");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems",menuItems);

        FileWriter out = new FileWriter("myweb.html");

        template.process(dataModel, out);

        out.close();


    }


}

