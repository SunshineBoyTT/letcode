/**
 * 
 */
package cn.insertdata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Random;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年12月4日
 * @Version:1.1.0
 */
public class DataThread extends Thread{
	Connection conn=null;
	static Random random=new Random();
	StringBuffer sql=new StringBuffer();
	String sql2="insert into tb_upload_data_info VALUES(null,'788', '81', '33', ?,?, '0')";
	public DataThread(Connection connection) {
		this.conn=connection;
		System.err.println("connect地址:"+conn);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			for (int i = 0; i < 200; i++) {
				try {
					int result=insertData();
					if (result==0) {
						System.err.println("数据插入失败--------------------------");
					}else{
//						System.out.println("插入成功");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public  int insertData() throws SQLException{
			sql.append(sql2);
			PreparedStatement statement =conn.prepareStatement(sql.toString());
			sql.delete(0, sql.length());
			statement.setString(1, String.valueOf(random.nextInt(100)));
			statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			return statement.executeUpdate();
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new DataThread(ConnectToDataBase.getDataBaseConnection()).start();
		}
	}
}
