/**
 * 
 */
package cn.insertdata.pool;

import java.sql.Connection;

import cn.insertdata.pool.ConnectPool.DBConnectionPool;

/**
 * @Description:简单实现 :深入请看博客http://www.importnew.com/19011.html
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年12月11日
 * @Version:1.1.0
 */
public class Main {
	public static void main(String[] args) {
		final PoolMan poolMan=new PoolMan();
		try {
			for (int i = 0; i < 5; i++) {
//				con=poolMan.getPool("app");
////				System.out.println(con.toString());
//				poolMan.close("app");
				new Thread(){
					public void run() {
						try {
							Connection con=poolMan.getPool("app");
							System.out.println(con.toString());
							poolMan.close("app");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					};
				}.start();
			}
			System.err.println("---------------------------");
			for (int i = 0; i < 5; i++) {
//				con=poolMan.getPool("app");
////				System.out.println(con.toString());
//				poolMan.close("app");
				new Thread(){
					public void run() {
						try {
							Connection con=poolMan.getPool("app");
							System.out.println(con.toString());
							poolMan.close("app");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					};
				}.start();
			}
			
			
//			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
