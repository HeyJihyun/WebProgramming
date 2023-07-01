package biz.bank.account;

import java.util.Date;

public class AccountVO {
    private int account_id;
    private String account_no;
    private String bank_cd;
    private String account_nm;
    private String account_pwd;
    private String deposit_cd;
    private String user_id;
    private Date reg_date;
    private Date expiration_date;
    private long balance;
    private int status;

    public AccountVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AccountVO(int account_id, String account_no, String bank_cd, String account_nm, String account_pwd,
            String deposit_cd, String user_id, Date reg_date, Date expiration_date, long balance, int status) {
        super();
        this.account_id = account_id;
        this.account_no = account_no;
        this.bank_cd = bank_cd;
        this.account_nm = account_nm;
        this.account_pwd = account_pwd;
        this.deposit_cd = deposit_cd;
        this.user_id = user_id;
        this.reg_date = reg_date;
        this.expiration_date = expiration_date;
        this.balance = balance;
        this.status = status;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getBank_cd() {
        return bank_cd;
    }

    public void setBank_cd(String bank_cd) {
        this.bank_cd = bank_cd;
    }

    public String getAccount_nm() {
        return account_nm;
    }

    public void setAccount_nm(String account_nm) {
        this.account_nm = account_nm;
    }

    public String getAccount_pwd() {
        return account_pwd;
    }

    public void setAccount_pwd(String account_pwd) {
        this.account_pwd = account_pwd;
    }

    public String getDeposit_cd() {
        return deposit_cd;
    }

    public void setDeposit_cd(String deposit_cd) {
        this.deposit_cd = deposit_cd;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountVO [account_id=" + account_id + ", account_no=" + account_no + ", bank_cd=" + bank_cd
                + ", account_nm=" + account_nm + ", account_pwd=" + account_pwd + ", deposit_cd=" + deposit_cd
                + ", user_id=" + user_id + ", reg_date=" + reg_date + ", expiration_date=" + expiration_date
                + ", balance=" + balance + ", status=" + status + "]";
    }

}
