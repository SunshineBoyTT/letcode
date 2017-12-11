/**
 * 
 */
package cn.insertdata.pool;

import java.sql.Connection;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年12月11日
 * @Version:1.1.0
 */
public class Main {
	public static void main(String[] args) {
		PoolMan poolMan=new PoolMan();
		try {
			Connection con=null;
			for (int i = 0; i < 5; i++) {
				con=poolMan.getPool("app");
				System.out.println(con.toString());
				poolMan.close("app");
			}
			System.err.println("---------------------------");
//			Thread.sleep(1000);
			con=poolMan.getConnection("app");
			System.out.println(con.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
