package biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
    // connection 연결하는 메소드
    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:tcp://localhost/~/test";
            return DriverManager.getConnection(url, "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
