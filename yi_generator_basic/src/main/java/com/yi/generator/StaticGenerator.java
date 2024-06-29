package com.yi.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class StaticGenerator {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "demo").getAbsolutePath();
        String outputPath = projectPath;
        copyFileByHutool(inputPath,outputPath);

    }

    private static void copyFileByHutool(String inputPath, String outputPath) {
//        修改内容，没有思路，看源码（看思路，看api
        FileUtil.copy(inputPath,outputPath,false);
    }

    public static void copyFilesByRecursive(String inputPath,String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try{
            copyFileByRecursive(inputFile,outputFile);
        }catch (Exception e){
            System.err.println("文件复制失败");
            e.printStackTrace();
        }

    }

    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {

        if (inputFile.isDirectory()){
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            if(!destOutputFile.exists()){
                destOutputFile.mkdirs();
            }
            File[] files = inputFile.listFiles();
            if(ArrayUtil.isEmpty(files)){
                return;
            }
            for(File file:files){
                copyFileByRecursive(file,destOutputFile);
            }
        }else{
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(),destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
