/**
 * 
 */
package cn.datastructure;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年12月11日
 * @Version:1.1.0
 */
public class Main {

	/** 
	 * @Title: main 
	 * @Description:
	 * @param @param args    
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch=new CountDownLatch(10);
		for (int i = 0; i <10; i++) {
			Worker worker=new Worker(latch);
			worker.start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all Workers Over");
	}

}
