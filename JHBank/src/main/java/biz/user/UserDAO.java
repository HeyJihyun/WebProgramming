package biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import biz.common.JDBCUtil;

public class UserDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 아이디 중복체크
    public int checkId(String id, String type) {
        String sql = "SELECT * FROM BANK_USER WHERE USER_ID = ? AND SIGNUP_TYPE = ?";

        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, id);
            stmt.setString(2, type);
            System.out.println(id);
            System.out.println(type);
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

    // 회원가입
    public int insertUser(UserVO user) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT ");
        sql.append("  INTO BANK_USER(USER_ID, USER_PWD, USER_NAME, ");
        sql.append("                 USER_BIRTHDAY, PHONE_NO, SIGNUP_TYPE, ");
        sql.append("                 POSTCODE, ADDRESS, DETAIL_ADDRESS)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, user.getUser_id());
            stmt.setString(2, user.getUser_pwd());
            stmt.setString(3, user.getUser_name());
            stmt.setString(4, user.getUser_birthday());
            stmt.setString(5, user.getPhone_no());
            stmt.setString(6, user.getSingup_type());
            stmt.setString(7, user.getPostcode());
            stmt.setString(8, user.getAddress());
            stmt.setString(9, user.getDetail_address());

            result = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return result;
    }

    // 로그인
    public UserVO getUser(UserVO vo) {
        UserVO user = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM BANK_USER ");
        sql.append(" WHERE USER_ID = ? AND USER_PWD = ? AND SIGNUP_TYPE = ?");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, vo.getUser_id());
            stmt.setString(2, vo.getUser_pwd());
            stmt.setString(3, vo.getSingup_type());
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new UserVO();
                user.setUser_id(rs.getString("USER_ID"));
                user.setRole_cd(rs.getString("ROLE_CD"));
                user.setUser_pwd(rs.getString("USER_PWD"));
                user.setUser_name(rs.getString("USER_NAME"));
                user.setUser_birthday(rs.getString("USER_BIRTHDAY"));
                user.setPhone_no(rs.getString("PHONE_NO"));
                user.setSingup_type(rs.getString("SIGNUP_TYPE"));
                user.setReg_date(rs.getString("REG_DATE"));
                user.setPostcode(rs.getString("POSTCODE"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setDetail_address(rs.getString("DETAIL_ADDRESS"));
                user.setOpen_agreement(rs.getInt("OPEN_AGREEMENT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return user;
    }

    public UserVO updateAgree(UserVO user) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE BANK_USER SET OPEN_AGREEMENT = 1 WHERE USER_ID = ?");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, user.getUser_id());
            int reuslt = stmt.executeUpdate();

            if (reuslt == 1) {
                user.setOpen_agreement(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return user;
    }

    public Map<String, String> getOpenbankList(UserVO user) {
        Map<String, String> bankMap = new HashMap<String, String>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT 'BGH'   AS BANK_CD, ");
        sql.append("       USER_ID AS ID ");
        sql.append("  FROM B_USER@GH ");
        sql.append(" WHERE USER_NAME = ? ");
        sql.append("   AND USER_BIRTH = ? ");
        sql.append("   AND USER_PHONE = REPLACE(?, '-', '') ");
        sql.append("UNION ALL ");
        sql.append("SELECT '0758'  AS BANK_CD, ");
        sql.append("       USER_ID AS ID ");
        sql.append("  FROM B_USER_INFO@SB ");
        sql.append(" WHERE KOR_NAME = ? ");
        sql.append("   AND BIRTHDATE = TO_CHAR(TO_DATE(?, 'YYYY-MM-DD'), ");
        sql.append("                           'RRMMDD') ");
        sql.append("   AND PHONE_NO  = REPLACE(?, '-', '') ");
        sql.append("UNION ALL ");
        sql.append("SELECT 'H.J', MEMBERID");
        sql.append("  FROM B_MEMBER@HJ ");
        sql.append(" WHERE USERNAME = ? ");
        sql.append("   AND BIRTHDAY    = ? ");
        sql.append("   AND PHONENUMBER = REPLACE(?, '-', '') ");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, user.getUser_name());
            stmt.setString(2, user.getUser_birthday());
            stmt.setString(3, user.getPhone_no());
            stmt.setString(4, user.getUser_name());
            stmt.setString(5, user.getUser_birthday());
            stmt.setString(6, user.getPhone_no());
            stmt.setString(7, user.getUser_name());
            stmt.setString(8, user.getUser_birthday());
            stmt.setString(9, user.getPhone_no());

            rs = stmt.executeQuery();

            while (rs.next()) {
                bankMap.put(rs.getString("bank_cd"), rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return bankMap;
    }

}
