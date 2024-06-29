package com.yi.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
// some exports omitted for the sake of brevity

//mixinStandardHelpOptions = true 给程序自动添加 --help 和 --version 选项
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
//Runnable Callable接口都可以实现命令行程序的功能
public class ASCIIArt implements Runnable {

    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

//    定义业务逻辑，命令解析成功（回车）后调用
    @Override
    public void run() {
        System.out.println("fontSize:"+fontSize);
        System.out.println("words:"+String.join(",",words));

    }

    public static void main(String[] args) {
//        处理用户输出，并能执行
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
//        退出程序
        System.exit(exitCode);
    }
}