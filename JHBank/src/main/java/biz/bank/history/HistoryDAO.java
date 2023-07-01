package biz.bank.history;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;

public class HistoryDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public List<HistoryVO> getHistoryList(String account_no, String bank_cd) {
        List<HistoryVO> historyList = new ArrayList<HistoryVO>();
        StringBuilder sql = new StringBuilder();

        switch (bank_cd) {
        case "JH":
            sql.append("SELECT * ");
            sql.append("  FROM BANK_HISTORY");
            sql.append(" WHERE FROM_ACCOUNT_NO = ?");
            break;
        case "0758":
            sql.append("SELECT T_SENDER_ACCOUNT_NO   FROM_ACCOUNT_NO,");
            sql.append("       T_SENDER_BANK_CODE    FROM_BANK_CD,");
            sql.append("       T_FROM_MEMO           FROM_NM,");
            sql.append("       T_RECEIVER_ACCOUNT_NO TO_ACCOUNT_NO,");
            sql.append("       T_RECEIVER_BANK_CODE  TO_BANK_CD,");
            sql.append("       T_TO_MEMO             TO_NM,");
            sql.append("       T_AMOUNT              H_MOUNT,");
            sql.append(
                    "       TO_DATE(SUBSTR((REPLACE(T_DATE, '.','') || REPLACE(T_TIME,':','')), 1, 14), 'YYYYMMDDHH24MISS') H_DATETIME,");
            sql.append("       CASE T_IN_OUT WHEN '출금' THEN '1' WHEN '입금' THEN '2' ELSE '0' END H_CLASS,");
            sql.append("       T_PREVIOUS_BALANCE    H_BALANCE");
            sql.append("  FROM B_TRANSACTION@SB");
            sql.append(" WHERE T_SENDER_ACCOUNT_NO = ?");
            break;
        case "H.J":
            sql.append("SELECT ACCOUNT_NO       FROM_ACCOUNT_NO,");
            sql.append("       BANKNAME         FROM_BANK_CD,");
            sql.append("       NULL             FROM_NM,");
            sql.append("       ACCOUNTNUMBER2   TO_ACCOUNT_NO,");
            sql.append("       BANKNAME_RECEIVE TO_BANK_CD,");
            sql.append("       NULL             TO_NM,");
            sql.append("       AMOUNT           H_MOUNT,");
            sql.append("       REGDATE          H_DATETIME,");
            sql.append("       CASE TRANSACTIONTYPE WHEN '-' THEN '1' WHEN '+' THEN '2' ELSE '0' END H_CLASS,");
            sql.append("       NULL             H_BALANCE");
            sql.append("  FROM B_TRANSACTION@HJ");
            sql.append(" WHERE ACCOUNT_NO = ?");
            break;
        case "BGH":
            sql.append("SELECT MYACCOUNT_NO   FROM_ACCOUNT_NO,");
            sql.append("       MYBANK_CODE    FROM_BANK_CD,");
            sql.append("       NULL           FROM_NM,");
            sql.append("       YOURACCOUNT_NO  TO_ACCOUNT_NO,");
            sql.append("       YOURBANK_CODE   TO_BANK_CD,");
            sql.append("       NULL            TO_NM,");
            sql.append("       TRANSFER_AMOUNT H_MOUNT,");
            sql.append("       TRANSFER_TIME   H_DATETIME,");
            sql.append("       CASE TRANSFER_DETAIL WHEN '출금' THEN '1' WHEN '입금' THEN '2' ELSE '0'");
            sql.append("       END             H_CLASS,");
            sql.append("       NULL            H_BALANCE");
            sql.append("  FROM B_TRANSFER@GH");
            sql.append(" WHERE MYACCOUNT_NO = ?");
            break;
        }
        sql.append(" ORDER BY H_DATETIME DESC");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, account_no);

            rs = stmt.executeQuery();

            while (rs.next()) {
                HistoryVO history = new HistoryVO();
                history.setFrom_account_no(rs.getString("FROM_ACCOUNT_NO"));
                history.setFrom_bank_cd(rs.getString("FROM_BANK_CD"));
                history.setFrom_nm(rs.getString("FROM_NM"));
                history.setTo_account_no(rs.getString("TO_ACCOUNT_NO"));
                history.setTo_bank_cd(rs.getString("TO_BANK_CD"));
                history.setTo_nm(rs.getString("TO_NM"));
                history.setH_mount(rs.getLong("H_MOUNT"));
                history.setH_datetime(rs.getDate("H_DATETIME"));
                history.setH_class(rs.getString("H_CLASS").trim());
                history.setH_balance(rs.getLong("H_BALANCE"));

                historyList.add(history);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return historyList;
    }

}
