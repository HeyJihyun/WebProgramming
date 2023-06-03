package biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

    public static Connection getConnection() throws Exception {

        Connection conn = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "hr";

        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    // connection 닫는 메소드(stmt, conn)
    public static void close(Statement stmt, Connection conn) {
        try {
            if (stmt != null)
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }

        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    // connection 닫는 메소드(rs, stmt, conn)
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }

        close(stmt, conn);
    }
}
