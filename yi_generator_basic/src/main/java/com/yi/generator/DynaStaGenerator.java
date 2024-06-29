package com.yi.generator;

import com.yi.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DynaStaGenerator {
    public static void main(String[] args) throws IOException, TemplateException {


        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yiDS");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和：");

        doGenerate(mainTemplateConfig);
        System.out.println("生成成功！");


    }

    public static void doGenerate(Object mainTemplateConfig)
            throws IOException, TemplateException{

        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();

        String inputPath = new File(projectPath, "demo/template").getAbsolutePath();
        String outputPath = projectPath;

        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);

        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "demo/template/acm/MainTemplate.java";

        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, mainTemplateConfig);
    }
}
