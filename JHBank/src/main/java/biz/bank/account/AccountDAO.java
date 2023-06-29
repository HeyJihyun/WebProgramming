package biz.bank.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        }
        return account;
    }

    // 계좌이체
    public int transfer(HistoryVO history) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("BEGIN P_BANK_TRANSFER(?, ?, ?, ?, ?, ?, ?);");
        sql.append("    DBMS_OUTPUT.PUT_LINE('계좌 이체가 성공적으로 수행되었습니다.');");
        sql.append("EXCEPTION");
        sql.append("  WHEN OTHERS THEN");
        sql.append("    DBMS_OUTPUT.PUT_LINE('계좌 이체 중 오류가 발생했습니다: ' || SQLERRM);");
        sql.append("END;");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, history.getFrom_account_no());
            stmt.setString(2, history.getFrom_bank_cd());
            stmt.setString(3, history.getFrom_nm());
            stmt.setString(4, history.getTo_account_no());
            stmt.setString(5, history.getTo_bank_cd());
            stmt.setString(6, history.getTo_nm());
            stmt.setInt(7, history.getH_mount());

            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
