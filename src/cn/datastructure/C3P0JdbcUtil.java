/**
 * 
 */
//package cn.datastructure;
//
//import java.beans.PropertyVetoException;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
///**
// * @Description:
// * @author zhengjuntao@hjtechcn.cn
// * @Since:2017年10月25日
// * @Version:1.1.0
// */
//public class C3P0JdbcUtil {
//	public static Connection getConnection() throws SQLException, PropertyVetoException{//完成初始化  
//	       ComboPooledDataSource cpds = new ComboPooledDataSource();  
//	       cpds.setDriverClass("com.microsoft.jdbc.sqlserver.SQLServerDriver");  
//	       cpds.setJdbcUrl("jdbc:microsoft:sqlserver://139.224.58.109:1433;databaseName=dm_new;SelectMethod=Cursor");  
//	       cpds.setUser("sa");  
//	       cpds.setPassword("root");  
//	       cpds.setAcquireIncrement(5);  
//	       cpds.setInitialPoolSize(10);  
//	       cpds.setMaxPoolSize(20);  
//	       return cpds.getConnection();  
//	}
//}