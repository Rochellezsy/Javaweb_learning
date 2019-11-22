package cn.itcast.jdbc.datasource.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JdbcTemplateDemo {
    public static void main(String[] args) throws Exception {

        Properties pro=new Properties();
        InputStream is = JdbcTemplateDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        //4、获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        JdbcTemplate template=new JdbcTemplate(dataSource);

        String sql ="update stu set age=300 where id = ?";

        int count = template.update(sql, 2);
        System.out.println(count);
    }
}
