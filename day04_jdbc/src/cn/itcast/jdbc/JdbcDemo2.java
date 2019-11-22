package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String[] args) {

        Statement stmt=null;
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql="insert into stu values(4,'周诗莹',24,88,null,null)";
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "***");
            stmt = conn.createStatement();

            int count = stmt.executeUpdate(sql);
            System.out.println(count);


            if(count>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //避免空指针异常
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}


