/**
 * 
 */
package cn.letcode.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
 
/*
 一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不用文件中（不要求输出到每个文件中的数量相同）。
 要求启动10个线程，两两一组，分为5组。
 每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，
 需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。
 同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，并在所有线程结束后，在控制台打印”Done”.
 */
/**
 * 分析：可以将10000个数分成5份，每一份（2000个数）对应一组，即两个线程，来分别输出这一份的奇数和偶数，
 * 同时声明一个共享变量，用于统计当前所有线程输出的个数，反映记录的输出进度
 */
public class PrintByThread {
     
    public static void main(String[] args) {
        try {
            //创建一个包含10000数字的输入文件
            PrintWriter pw=new PrintWriter(new FileWriter(new File("input.txt")),true);
            Random random=new Random();
            for (int i = 0; i < 10000; i++) {
                pw.print(Math.abs(random.nextInt())%100+",");
            }
            pw.flush();
            pw.close();
            //读取文件中的数字，分5次读取，每次读取2000个
            BufferedReader reader=new BufferedReader(new FileReader("input.txt"));
            String str=reader.readLine();
            reader.close();
            String[] strs=str.split(",");//将一行字符串全部解析为10000个数字
            int j=0;//10000个数的索引计数
            for (int i = 0; i < 5; i++) {
                int records[]=new int[2000];
                for (int k = 0; k < 2000; k++) {
                    records[k]=Integer.parseInt(strs[j]);
                    j++;
                }
                //定义输出文件
                PrintWriter writer =new PrintWriter(new FileWriter(new File("output"+i+".txt")),true);
                //定义实现的方法
                ThreadGroup group=new ThreadGroup(records, writer);
                //开启一对儿线程
                new Thread(group).start();
                new Thread(group).start();             
            }          
             
        } catch (Exception e) {
            // TODO: handle exception
        }      
    }  
}
