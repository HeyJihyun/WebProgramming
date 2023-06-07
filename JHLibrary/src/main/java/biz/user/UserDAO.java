package biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import biz.common.JDBCUtil;

public class UserDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 로그인
    public UserVO getUser(UserVO vo) {

        String sql = "SELECT * FROM T_USER WHERE ID = ? AND PWD = ?";
        UserVO user = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPwd());

            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new UserVO();
                vo.setName(rs.getString("NAME"));
                vo.setPhone(rs.getString("PHONE"));
                vo.setGrade(rs.getString("GRADE"));
            } else {
                vo = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }

    // 회원가입
    public int insertUser(UserVO vo) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO T_USER(ID, PWD, NAME, PHONE) VALUES(?, ?, ?, ?)");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPwd());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getPhone());

            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return result;
    }

    // 아이디 중복 확인

    public int checkId(String id) {
        String sql = "SELECT * FROM T_USER WHERE ID = ?";

        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return result;
    }

}
