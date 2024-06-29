package com.yi;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "demo").getAbsolutePath();
        String outputPath = projectPath;
        copyFileByHutool(inputPath,outputPath );

    }

    private static void copyFileByHutool(String inputPath, String outputPath) {
//        修改内容，没有思路，看源码（看思路，看api
        FileUtil.copy(inputPath,outputPath,false);
    }
}
