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

    public List<HistoryVO> getHistoryList(String account_no) {
        List<HistoryVO> historyList = new ArrayList<HistoryVO>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("  FROM BANK_HISTORY");
        sql.append(" WHERE FROM_ACCOUNT_NO = ?");
        sql.append(" ORDER BY H_NO DESC");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, account_no);

            rs = stmt.executeQuery();

            while (rs.next()) {
                HistoryVO history = new HistoryVO();
                history.setH_no(rs.getInt("H_NO"));
                history.setFrom_account_no(rs.getString("FROM_ACCOUNT_NO"));
                history.setFrom_bank_cd(rs.getString("FROM_BANK_CD"));
                history.setFrom_nm(rs.getString("FROM_NM"));
                history.setTo_account_no(rs.getString("TO_ACCOUNT_NO"));
                history.setTo_bank_cd(rs.getString("TO_BANK_CD"));
                history.setTo_nm(rs.getString("TO_NM"));
                history.setH_mount(rs.getLong("H_MOUNT"));
                history.setH_datetime(rs.getDate("H_DATETIME"));
                history.setH_class(rs.getString("H_CLASS"));
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
