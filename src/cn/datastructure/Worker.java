/**
 * 
 */
package cn.datastructure;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年12月11日
 * @Version:1.1.0
 */
public class Worker extends Thread {

	CountDownLatch latch=null;
	public Worker(CountDownLatch latch) {
		super();
		// TODO Auto-generated constructor stub
		this.latch=latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		latch.countDown();
		System.out.println(Thread.currentThread().getName()+"Over");
	}

}
