package cn.itcast.jdbc.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1、导入jar包
        //2、定义配置文件
        //3、加载配置文件
        Properties pro=new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        //4、获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        Connection conn=dataSource.getConnection();
        System.out.println(conn);

        conn.close();


    }
}
