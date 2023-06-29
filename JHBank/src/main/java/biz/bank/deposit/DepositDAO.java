package biz.bank.deposit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;

public class DepositDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 금융상품 전체보기
    public List<DepositVO> getDepositList() {
        List<DepositVO> depositList = new ArrayList<DepositVO>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM BANK_DEPOSIT WHERE D_STATUS = 1");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());

            rs = stmt.executeQuery();

            while (rs.next()) {
                DepositVO deposit = new DepositVO();
                deposit.setDeposit_cd(rs.getInt("DEPOSIT_CD"));
                deposit.setD_nm(rs.getString("D_NM"));
                deposit.setD_interest(rs.getInt("D_INTEREST"));
                deposit.setD_period(rs.getInt("D_PERIOD"));
                deposit.setD_class(rs.getString("D_CLASS"));
                deposit.setD_detail(rs.getString("D_DETAIL"));
                depositList.add(deposit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return depositList;
    }

    // 금융상품 하나 보기
    public DepositVO getDeposit(int deposit_cd) {
        DepositVO deposit = null;
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM BANK_DEPOSIT WHERE DEPOSIT_CD = ?");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, deposit_cd);

            rs = stmt.executeQuery();

            if (rs.next()) {
                deposit = new DepositVO();
                deposit.setDeposit_cd(rs.getInt("DEPOSIT_CD"));
                deposit.setD_nm(rs.getString("D_NM"));
                deposit.setD_interest(rs.getInt("D_INTEREST"));
                deposit.setD_period(rs.getInt("D_PERIOD"));
                deposit.setD_class(rs.getString("D_CLASS"));
                deposit.setD_detail(rs.getString("D_DETAIL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return deposit;
    }

}
