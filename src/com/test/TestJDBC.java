package com.test;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        /*
         * JDBC步骤：
         * 1.加载驱动Drive
         * 2.获得连接对象
         * 3.获取执行对象 Statement 预处理
         * 4.执行SQL
         * 5.处理结果
         * 5.关闭资源
         */
        Connection con = null;
//        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb",
                    "root",
                    "jjx123...");

//            st = con.createStatement();
//            rs = st.executeQuery("select * from product");
//            while (rs.next()) {
//                System.out.println(rs.getString("product_name"));
//            }

            ps = con.prepareStatement("select * from products where product_name = ? or product_id = ?");
            ps.setObject(1, "乐视薯片");
            ps.setObject(2, 2);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("name = " + rs.getString("product_name"));
            }
//            st.executeUpdate("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            try {
//                if (st != null) {
//                    st.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
