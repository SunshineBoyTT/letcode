package cn.datastructure;
///**
// * 
// */
//package cn.datastructure;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.pool.DruidPooledConnection;
//import com.mysql.jdbc.PreparedStatement;
//
//
///**
// * @Description:
// * @author zhengjuntao@hjtechcn.cn
// * @Since:2017年10月25日
// * @Version:1.1.0
// */
//public class Test {
//
//	/**
//	 * @throws Exception  
//	 * @Title: main 
//	 * @Description:
//	 * @param @param args    
//	 * @return void    返回类型 
//	 * @throws 
//	 */
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
////		 DruidDataSourceUtil druidDataSourceUtil = new DruidDataSourceUtil();
////	     DruidDataSource druidDataSource = druidDataSourceUtil.getDataSource();
////	     DruidPooledConnection dbConn = druidDataSourceUtil.getDruidConnection(druidDataSource);
//		 Connection conn=C3P0JdbcUtil.getConnection();  
//         Statement statement= (Statement) conn.createStatement();
//         ResultSet result = ((java.sql.Statement) statement).executeQuery("select * from userinfo");
//         while(result.next()){
//        	 System.out.println(result.getString("name"));
//         }
//        
//	}
//
//}
public class Inc { 
    public static void main(String[] args) { 
       Inc inc = new Inc(); 
       int i = 0; 
       inc.fermin(i); 
       i= i++; 
       System.out.println(i);
    
    } 
    void fermin(int i){ 
       i++; 
    } 
}
