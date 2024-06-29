package com.yi.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import com.yi.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DynamicGenerator {
//    public static void main(String[] args) throws IOException, TemplateException {
//            Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
//            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
//            configuration.setDefaultEncoding("utf-8");
//            Template template = configuration.getTemplate("MainTemplate.java.ftl");
//        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
//        mainTemplateConfig.setAuthor("yi");
//        mainTemplateConfig.setLoop(false);
//        mainTemplateConfig.setOutputText("求和：");
//
//        Writer out = new FileWriter("MainTemplate.java");
//        template.process(mainTemplateConfig,out);
//        out.close();
//    }

    public static void main(String[] args) throws IOException, TemplateException{
        String projectPath = System.getProperty("user.dir");
//        File parentFile = new File(projectPath).getParentFile();
//        String inputPath = new File(parentFile, "demo").getAbsolutePath();

//        注意文件位置！！！！记得要加File.separator，在连接字符串的时候！
        String inputPath=projectPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
//        src/main/resources/templates/MainTemplate.java.ftl
//        String inputPath = new File(projectPath, "src/main/java/com/yi/generator/MainTemplate.java.ftl").getPath();
        String outputPath = projectPath+File.separator+"MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yi_main");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和：");

        doGenerate(inputPath, outputPath, mainTemplateConfig);



    }

    public static void doGenerate(String inputPath, String outputPath, Object mainTemplateConfig)
            throws IOException, TemplateException{
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        File inputFile = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(inputFile);
        configuration.setDefaultEncoding("utf-8");
        String parentFile = new File(inputPath).getName();
        Template template = configuration.getTemplate(parentFile);


//        MainTemplateConfig mainTemplateConfig1 = new MainTemplateConfig();
//        mainTemplateConfig1.setAuthor("yi_do");
//        mainTemplateConfig1.setLoop(false);
//        mainTemplateConfig1.setOutputText("求和：");

        Writer out = new FileWriter(outputPath);
        template.process(mainTemplateConfig,out);
        out.close();
    }
}
