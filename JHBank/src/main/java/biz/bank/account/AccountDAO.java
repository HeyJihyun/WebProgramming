package biz.bank.account;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import biz.bank.history.HistoryVO;
import biz.common.JDBCUtil;

public class AccountDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 계좌 확인
    public boolean chackAccount(String account_no) {
        boolean chack = false;
        String sql = "select * from BANK_ACCOUNT where account_no = ?";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, account_no);

            rs = stmt.executeQuery();

            chack = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return chack;
    }

    // 계좌가입
    public int insertAccount(AccountVO account) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT ");
        sql.append("  INTO BANK_ACCOUNT(ACCOUNT_NO, ACCOUNT_NM, ");
        sql.append("                 Account_pwd, DEPOSIT_CD, USER_ID, ");
        sql.append("                 REG_DATE, EXPIRATION_DATE, BALANCE)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, account.getAccount_no());
            stmt.setString(2, account.getAccount_nm());
            stmt.setString(3, account.getAccount_pwd());
            stmt.setInt(4, account.getDeposit_cd());
            stmt.setString(5, account.getUser_id());
            stmt.setDate(6, new java.sql.Date(account.getReg_date().getTime()));
            stmt.setDate(7, new java.sql.Date(account.getExpiration_date().getTime()));
            stmt.setLong(8, account.getBalance());

            result = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return result;
    }

    // 내계좌리스트 조회
    public List<AccountVO> getAccountList(String id) {
        List<AccountVO> accountList = new ArrayList<AccountVO>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM BANK_ACCOUNT WHERE USER_ID = ? AND STATUS = 1");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                AccountVO account = new AccountVO();
                account.setAccount_id(rs.getInt("ACCOUNT_ID"));
                account.setAccount_no(rs.getString("ACCOUNT_NO"));
                account.setBank_cd(rs.getString("BANK_CD"));
                account.setAccount_nm(rs.getString("ACCOUNT_NM"));
                account.setAccount_pwd(rs.getString("ACCOUNT_PWD"));
                account.setDeposit_cd(rs.getInt("DEPOSIT_CD"));
                account.setUser_id(rs.getString("USER_ID"));
                account.setReg_date(rs.getDate("REG_DATE"));
                account.setExpiration_date(rs.getDate("EXPIRATION_DATE"));
                account.setBalance(rs.getLong("BALANCE"));
                account.setStatus(rs.getInt("STATUS"));

                accountList.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return accountList;
    }

    // 계좌 상세 조회
    public AccountVO getAccount(String id) {
        AccountVO account = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                account = new AccountVO();
                account.setAccount_id(rs.getInt("ACCOUNT_ID"));
                account.setAccount_no(rs.getString("ACCOUNT_NO"));
                account.setBank_cd(rs.getString("BANK_CD"));
                account.setAccount_nm(rs.getString("ACCOUNT_NM"));
                account.setAccount_pwd(rs.getString("ACCOUNT_PWD"));
                account.setDeposit_cd(rs.getInt("DEPOSIT_CD"));
                account.setUser_id(rs.getString("USER_ID"));
                account.setReg_date(rs.getDate("REG_DATE"));
                account.setExpiration_date(rs.getDate("EXPIRATION_DATE"));
                account.setBalance(rs.getLong("BALANCE"));
                account.setStatus(rs.getInt("STATUS"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return account;
    }

    // 계좌이체
    public int transfer(HistoryVO history) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("{call P_BANK_TRANSFER(?, ?, ?, ?, ?, ?, ?, ?) }");
        try {
            conn = JDBCUtil.getConnection();
            CallableStatement cstmt = conn.prepareCall(sql.toString());
            cstmt.setString(1, history.getFrom_account_no());
            cstmt.setString(2, history.getFrom_bank_cd());
            cstmt.setString(3, history.getFrom_nm());
            cstmt.setString(4, history.getTo_account_no());
            cstmt.setString(5, history.getTo_bank_cd());
            cstmt.setString(6, history.getTo_nm());
            cstmt.setLong(7, history.getH_mount());
            cstmt.registerOutParameter(8, Types.INTEGER);
            cstmt.execute();

            // 결과값 가져오기
            result = cstmt.getInt(8);
            cstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return result;
    }

    // 계좌 주인 이름 확인
    public String checkAccount(String account_no, String bank_cd) {
        String name = "";
        StringBuilder sql = new StringBuilder();

        switch (bank_cd) {
        case "JH":
            sql.append("SELECT USER_NAME FROM BANK_USER WHERE USER_ID = (");
            sql.append("       SELECT USER_ID  FROM BANK_ACCOUNT WHERE ACCOUNT_NO = ?)");
            break;
        case "0758":
            sql.append("SELECT KOR_NAME FROM B_USER_INFO@SB WHERE USER_ID = (");
            sql.append("SELECT USER_ID FROM B_USER_ACCOUNT@SB WHERE ACCOUNT_NO = ?)");
            break;
        case "H.J":
            sql.append("SELECT USERNAME FROM B_MEMBER@HJ WHERE MEMBERID = (");
            sql.append("       SELECT MEMBERID FROM B_ACCOUNT@HJ WHERE ACCOUNT_NO = ?)");
            break;
        case "BGH":
            sql.append("SELECT USER_NAME FROM B_ACCOUNT@GH WHERE ACCOUNT_NO = ?");
            break;
        }
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, account_no);

            rs = stmt.executeQuery();

            if (rs.next()) {
                name = rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return name;
    }

    public List<List<AccountVO>> getOpenbankList(Map<String, String> bankMap) {

        List<List<AccountVO>> openbankList = new ArrayList<List<AccountVO>>();

        for (String bank_cd : bankMap.keySet()) {
            StringBuilder sql = new StringBuilder();
            sql.append(
                    "SELECT NVL(ACCOUNT_NO, NULL)  AS ACCOUNT_NO, NVL(BANK_CD, NULL)     AS BANK_CD, NVL(ACCOUNT_NM, NULL)  AS ACCOUNT_NM, NVL(ACCOUNT_PWD, NULL) AS ACCOUNT_PWD, ");
            sql.append(
                    "       NVL(DEPOSIT_CD, NULL)  AS DEPOSIT_CD, NVL(USER_ID, NULL)     AS USER_ID, NVL(REG_DATE, NULL)    AS REG_DATE, NVL(BALANCE, NULL)     AS BALANCE ");
            sql.append("  from (");
            switch (bank_cd) {
            case "H.J":
                sql.append("SELECT ACCOUNT_NO, BANKCODE  BANK_CD, PASSWORD  ACCOUNT_PWD,");
                sql.append("       PRODUCTID DEPOSIT_CD, MEMBERID  USER_ID, MONEY     BALANCE");
                sql.append("  FROM B_ACCOUNT@HJ");
                sql.append(" WHERE MEMBERID = ?");
                break;
            case "0758":
                sql.append(
                        "SELECT ACCOUNT_NO, B_BANK_CODE      BANK_CD, ACCOUNT_NICKNAME ACCOUNT_NM, ACCOUNT_PASSWORD ACCOUNT_PWD,");
                sql.append(
                        "       CREATED_DATE     REG_DATE, D_PRODUCT_CODE   DEPOSIT_CD, USER_ID, TOTAL_BALANCE    BALANCE");
                sql.append("  FROM B_USER_ACCOUNT@SB");
                sql.append(" WHERE USER_ID = ?");
                break;
            case "BGH":
                sql.append(
                        "SELECT ACCOUNT_NO, BANK_CODE       BANK_CD, ACCOUNT_NAME    ACCOUNT_NM, ACCOUNT_PW      ACCOUNT_PWD,");
                sql.append("       PRODUCT_NO      DEPOSIT_CD, USER_ID, ACCOUNT_BALANCE BALANCE");
                sql.append("  FROM B_ACCOUNT@GH");
                sql.append(" WHERE USER_ID = ?");
                break;
            }

            sql.append(")");

            System.out.println(sql.toString());
            List<AccountVO> accountList = new ArrayList<AccountVO>();
            try {
                conn = JDBCUtil.getConnection();
                stmt = conn.prepareStatement(sql.toString());
                stmt.setString(1, bankMap.get(bank_cd));

                rs = stmt.executeQuery();

                while (rs.next()) {
                    AccountVO account = new AccountVO();
//                    account.setAccount_id(rs.getInt("ACCOUNT_ID"));
                    account.setAccount_no(rs.getString("ACCOUNT_NO"));
                    account.setBank_cd(rs.getString("BANK_CD"));
                    account.setAccount_nm(rs.getString("ACCOUNT_NM"));
                    account.setAccount_pwd(rs.getString("ACCOUNT_PWD"));
                    account.setDeposit_cd(rs.getInt("DEPOSIT_CD"));
                    account.setUser_id(rs.getString("USER_ID"));
                    account.setReg_date(rs.getDate("REG_DATE"));
//                    account.setExpiration_date(rs.getDate("EXPIRATION_DATE"));
                    account.setBalance(rs.getLong("BALANCE"));
//                    account.setStatus(rs.getInt("STATUS"));

                    accountList.add(account);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.close(rs, stmt, conn);
            }
            openbankList.add(accountList);
        }

        return openbankList;
    }

}
