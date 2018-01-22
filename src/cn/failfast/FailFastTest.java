/**
 * 
 */
package cn.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年9月5日
 * @Version:1.1.0
 */
public class FailFastTest {

	 private static List<Integer> list = new CopyOnWriteArrayList<Integer>();  
     
	    /** 
	     * @desc:线程one迭代list 
	     * @Project:test 
	     * @file:FailFastTest.java 
	     * @Authro:chenssy 
	     * @data:2014年7月26日 
	     */  
	    private static class threadOne extends Thread{  
	        public void run() {  
	            Iterator<Integer> iterator = list.iterator();  
	            while(iterator.hasNext()){  
	                int i = iterator.next();  
	                System.out.println("ThreadOne 遍历:" + i);  
	                try {  
	                    Thread.sleep(10);
	                } catch (InterruptedException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	    }  
	      
	    /** 
	     * @desc:当i == 3时，修改list 
	     * @Project:test 
	     * @file:FailFastTest.java 
	     * @Authro:chenssy 
	     * @data:2014年7月26日 
	     */  
	    private static class threadTwo extends Thread{  
	        public void run(){  
	            int i = 0 ;   
	            while(i < 6){  
	                System.out.println("ThreadTwo run：" + i);  
	                if(i == 3){  
	                    list.remove(i);  
	                }  
	                i++;  
	            }  
	        }  
	    }  
	      
	    public static void main(String[] args) { 
	        for(int i = 0 ; i < 10;i++){  
	            list.add(i);  
	        }  
	        new threadOne().start();  
	        new threadTwo().start();  
	    } 
}
