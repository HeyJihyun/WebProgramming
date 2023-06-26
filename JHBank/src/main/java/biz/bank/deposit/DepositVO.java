package biz.bank.deposit;

public class DepositVO {
    private int deposit_cd;
    private String d_nm;
    private int d_interest;
    private int d_period;
    private String d_class;
    private String d_detail;

    public DepositVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DepositVO(int deposit_cd, String d_nm, int d_interest, int d_period, String d_class, String d_detail) {
        super();
        this.deposit_cd = deposit_cd;
        this.d_nm = d_nm;
        this.d_interest = d_interest;
        this.d_period = d_period;
        this.d_class = d_class;
        this.d_detail = d_detail;
    }

    @Override
    public String toString() {
        return "DipositVO [deposit_cd=" + deposit_cd + ", d_nm=" + d_nm + ", d_interest=" + d_interest + ", d_period="
                + d_period + ", d_class=" + d_class + ", d_detail=" + d_detail + "]";
    }

    public int getDeposit_cd() {
        return deposit_cd;
    }

    public void setDeposit_cd(int deposit_cd) {
        this.deposit_cd = deposit_cd;
    }

    public String getD_nm() {
        return d_nm;
    }

    public void setD_nm(String d_nm) {
        this.d_nm = d_nm;
    }

    public int getD_interest() {
        return d_interest;
    }

    public void setD_interest(int d_interest) {
        this.d_interest = d_interest;
    }

    public int getD_period() {
        return d_period;
    }

    public void setD_period(int d_period) {
        this.d_period = d_period;
    }

    public String getD_class() {
        return d_class;
    }

    public void setD_class(String d_class) {
        this.d_class = d_class;
    }

    public String getD_detail() {
        return d_detail;
    }

    public void setD_detail(String d_detail) {
        this.d_detail = d_detail;
    }

}
