package biz.bank.history;

import java.util.Date;

public class HistoryVO {
    public int h_no;
    public String from_account_no;
    public String from_bank_cd;
    public String from_nm;
    public String to_account_no;
    public String to_bank_cd;
    public String to_nm;
    public long h_mount;
    public Date h_datetime;
    private String h_class;
    private long h_balance;

    public HistoryVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HistoryVO(int h_no, String from_account_no, String from_bank_cd, String from_nm, String to_account_no,
            String to_bank_cd, String to_nm, long h_mount, Date h_datetime, String h_class, long h_balance) {
        super();
        this.h_no = h_no;
        this.from_account_no = from_account_no;
        this.from_bank_cd = from_bank_cd;
        this.from_nm = from_nm;
        this.to_account_no = to_account_no;
        this.to_bank_cd = to_bank_cd;
        this.to_nm = to_nm;
        this.h_mount = h_mount;
        this.h_datetime = h_datetime;
        this.h_class = h_class;
        this.h_balance = h_balance;
    }

    public int getH_no() {
        return h_no;
    }

    public void setH_no(int h_no) {
        this.h_no = h_no;
    }

    public String getFrom_account_no() {
        return from_account_no;
    }

    public void setFrom_account_no(String from_account_no) {
        this.from_account_no = from_account_no;
    }

    public String getFrom_bank_cd() {
        return from_bank_cd;
    }

    public void setFrom_bank_cd(String from_bank_cd) {
        this.from_bank_cd = from_bank_cd;
    }

    public String getFrom_nm() {
        return from_nm;
    }

    public void setFrom_nm(String from_nm) {
        this.from_nm = from_nm;
    }

    public String getTo_account_no() {
        return to_account_no;
    }

    public void setTo_account_no(String to_account_no) {
        this.to_account_no = to_account_no;
    }

    public String getTo_bank_cd() {
        return to_bank_cd;
    }

    public void setTo_bank_cd(String to_bank_cd) {
        this.to_bank_cd = to_bank_cd;
    }

    public String getTo_nm() {
        return to_nm;
    }

    public void setTo_nm(String to_nm) {
        this.to_nm = to_nm;
    }

    public long getH_mount() {
        return h_mount;
    }

    public void setH_mount(long h_mount) {
        this.h_mount = h_mount;
    }

    public Date getH_datetime() {
        return h_datetime;
    }

    public void setH_datetime(Date h_datetime) {
        this.h_datetime = h_datetime;
    }

    public String getH_class() {
        return h_class;
    }

    public void setH_class(String h_class) {
        this.h_class = h_class;
    }

    public long getH_balance() {
        return h_balance;
    }

    public void setH_balance(long h_balance) {
        this.h_balance = h_balance;
    }

    @Override
    public String toString() {
        return "HistoryVO [h_no=" + h_no + ", from_account_no=" + from_account_no + ", from_bank_cd=" + from_bank_cd
                + ", from_nm=" + from_nm + ", to_account_no=" + to_account_no + ", to_bank_cd=" + to_bank_cd
                + ", to_nm=" + to_nm + ", h_mount=" + h_mount + ", h_datetime=" + h_datetime + ", h_class=" + h_class
                + ", h_balance=" + h_balance + "]";
    }
}
