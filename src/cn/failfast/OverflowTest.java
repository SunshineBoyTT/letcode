/**
 * 
 */
package cn.failfast;

/**
 * @Description:StackOverflowError:stack溢出
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2018年1月22日
 * @Version:1.1.0
 */
public class OverflowTest {
//	private volatile int i=0;
//	private volatile int b=0;
//	private volatile int c=0;//23201
	
	private  int i=0;
	private  int b=0;
	private  int c=0;//11422
	
	public static void main(String[] args) {
		OverflowTest o=new OverflowTest();
		try {
			o.deepTest();
		} catch (Throwable e) {
			System.out.println("over flow deep:"+o.i);
			e.printStackTrace();
		}
	}
	private void deepTest() {
		++i;
		++b;
		++c;
		deepTest();
	}
}
