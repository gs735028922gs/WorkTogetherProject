package main;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MyMathApp {

    public static void main(String[] args) throws Exception {
        int n;//题目个数
        int r;//数值取值范围
        System.out.println("欢迎使用四则运算");
        System.out.println("-q 生成题目和答案");
        System.out.println("-c 验证你的答案");
        System.out.println("--------------");
        System.out.println("请选择你的操作：");
        Scanner scanner = new Scanner(System.in);
        String order = scanner.next();
        switch(order){
            case "-q":
                System.out.println("请输入生成题目个数-n(大于0的整数)：");
                n=scanner.nextInt();
                System.out.println("请输入数值取值范围-r(大于0的整数)：");
                r=scanner.nextInt();
                if(n<0||r<0){
                    System.out.println("请的输入有误！");
                    break;
                }
                List<String> questionList = GenerateQuestion.generateQuestion(n,r);
                List<String> answerList = Calculator.calculate(questionList);
                printQuestion(questionList);
                printAnswer(answerList);
                break;
            case "-c":
                System.out.println("请输入题目文件：");
                Scanner scanner1 = new Scanner(System.in);
                String questionfilepath = scanner1.nextLine();

                System.out.println("请输入答案文件：");
                Scanner scanner2 = new Scanner(System.in);
                String answerfilepath = scanner2.nextLine();

                List<List> result = CompareAnswer.compareAnswer(questionfilepath,answerfilepath);
                printCompareResult(result);
                break;
            default:
                System.out.println("你的输入有误！");
                break;
        }

    }
    //输出题目文件
    public static void printQuestion(List<String> queList){
        File file = new File("./Exercises.txt");
        OutputFile.questionlist2file(file,queList);
        System.out.println("生成题目成功！");
    }
    //输出答案文件
    public static void printAnswer(List<String> ansList){
        File file = new File("./Answers.txt");
        OutputFile.answerlist2file(file,ansList);
        System.out.println("生成答案成功！");
    }
    //输出答案的比较结果
    public static void printCompareResult(List<List> resultList){
        File file = new File("./Grade.txt");
        OutputFile.compareresultlist2file(file,resultList);
        System.out.println("答案验证完成！");
    }
}
