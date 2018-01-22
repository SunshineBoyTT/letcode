/**
 * 
 */
//package cn.datastructure;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import com.alibaba.druid.pool.DruidPooledConnection;
//
///**
// * @Description:
// * @author zhengjuntao@hjtechcn.cn
// * @Since:2017年10月25日
// * @Version:1.1.0
// */
//public class DruidDataSourceUtil {
//    public  DruidDataSource getDataSource()  
//        throws Exception {
//     Properties configureProperties = new Properties();
//     InputStream is = DruidDataSourceUtil.class.getClassLoader().getResourceAsStream("ConfigureProperties.properties");   
//     configureProperties.load(is);
//     DruidDataSource druidDataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(configureProperties);
//     return druidDataSource;
//    }
//    public  DruidPooledConnection getDruidConnection(DruidDataSource druidDataSource) throws Exception {
//     DruidPooledConnection dbConn = (DruidPooledConnection) druidDataSource.getConnection(); 
//     return dbConn;
//    }
//}
