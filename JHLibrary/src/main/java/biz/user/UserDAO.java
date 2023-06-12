package biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;

public class UserDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 로그인
    public UserVO getUser(UserVO vo) {

        String sql = "SELECT * FROM T_USER WHERE ID = ? AND PWD = ?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPwd());

            rs = stmt.executeQuery();

            if (rs.next()) {
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
        return vo;
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

    // 유저 정보 불러오기
    public List<UserVO> getUserList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ID, NAME, PHONE, GRADE, to_char(MIN(RETURN_DATE),'yyyy-mm-dd')");
        sql.append("  FROM T_USER left outer join T_RENTAL on T_USER.ID = T_RENTAL.U_ID");
        sql.append(" GROUP BY ID, NAME, PHONE, GRADE");

        List<UserVO> userList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());

            rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String grade = rs.getString(4);
                String return_date = rs.getString(5);
                userList.add(new UserVO(id, null, name, phone, grade, return_date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return userList;
    }

    // 회원정보수정
    public int updateUser(String id, String password, String phone) {
        String sql = "UPDATE T_USER SET PWD = ?, PHONE = ? WHERE ID = ?";

        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, password);
            stmt.setString(2, phone);
            stmt.setString(3, id);

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

    // 관리자로 임명
    public int updateGrade(String id) {
        String sql = "UPDATE T_USER SET grade = 'admin' WHERE ID = ?";

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

    // 회원탈퇴
    public int deleteUser(String id) {
        String sql = "DELETE FROM T_USER WHERE ID = ?";

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
