/**
 * 
 */
package cn.letcode.thread;

import java.io.PrintWriter;

class ThreadGroup implements Runnable{
    //所有类对象共享的同一个计数器count，记录总共输出的记录总数
    private static int count=0;
    //所有的ThreadGroup类对象共享一个锁，用于count变量的同步，任何一个线程需要修改count变量，必须取得该锁
    private static Object lock=new Object();
    public static final int EVEN=0;//代表偶数
    public static final int ODD=-1;//代表奇数
     
    //*********以上静态变量，属于整个类所有***********
    private int type;
    private int records[];
    private PrintWriter writer;//每组共享一个writer，输出到同一个文件
    private int oddPoint=0;//记录每次打印奇数的起始位置
    private int evenPoint=0;//记录每次打印偶数的起始位置
     
    public ThreadGroup(int[] records,PrintWriter writer){
        this.records=records;
        this.writer=writer;
        this.type=EVEN;
    }
     
    //线程方法实现
    public void run() {
        while(print());
         
    }
     
    private synchronized boolean print(){
        for(int i=0;i<10;){
            //如果奇数和偶数都打印完成以后，就直接停止打印循环，等待该线程自己结束
            if (oddPoint>=records.length&&evenPoint>=records.length) {
            	System.out.println("oddPoint"+oddPoint+"evenPoint"+evenPoint);
                notifyAll();
                return false;
            }
            //如果该线程该打印奇数，但奇数已经打印晚了，就直接停止本次10个数的打印，
            //同理偶数，等下次切换打印类型后，再开始打印另外一种类型
            if ((oddPoint>=records.length&&type==ODD)||(evenPoint>=records.length&&type==EVEN)) {
                break;
            }
            //判断开始打印偶数
            if (type==EVEN) {
                if (records[evenPoint]%2==0) {
                    i++;
                    writer.print(records[evenPoint]+",");
                    writer.flush();
                    //锁定全局变量方便线程输出后计数
                    synchronized (lock) {
                        count++;
                        if (count%1000==0) {
                            System.out.println("当前完成数量："+count);
                            if (count==10000) {
                                System.out.println("Done!");
                            }
                        }
                    }
                }
                //无论是否是偶数，打印成功一个后，偶数的起始位置都要后移
                evenPoint++;
            }else {
                //打印奇数
                if (records[oddPoint]%2==1) {
                    i++;
                    writer.print(records[oddPoint]+",");
                    writer.flush();
                    //锁定全局变量方便线程输出后计数
                    synchronized (lock) {
                        count++;
                        if (count%1000==0) {
                            System.out.println("当前完成数量："+count);
                            if (count==10000) {
                                System.out.println("Done!");
                            }
                        }
                    }
                }
                //无论是否是奇数，打印成功一个后，偶数的起始位置都要后移
                oddPoint++;
            }
             
        }
        type=~type;//切换打印类型
        notifyAll();//一组中的任一线程打印完后唤醒另一个线程
        try {
            wait();//释放锁进入等待状态，等待另一线程打印
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;
    }
}
