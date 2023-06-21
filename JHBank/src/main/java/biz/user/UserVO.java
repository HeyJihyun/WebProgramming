package biz.user;

public class UserVO {

    private String user_id;
    private String role_cd;
    private String user_pwd;
    private String user_name;
    private String user_birthday;
    private String phone_no;
    private String singup_type;
    private String reg_date;
    private String postcode;
    private String address;

    @Override
    public String toString() {
        return "userVO [user_id=" + user_id + ", role_cd=" + role_cd + ", user_pwd=" + user_pwd + ", user_name="
                + user_name + ", user_birthday=" + user_birthday + ", phone_no=" + phone_no + ", singup_type="
                + singup_type + ", reg_date=" + reg_date + ", postcode=" + postcode + ", address=" + address
                + ", detail_address=" + detail_address + "]";
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_cd() {
        return role_cd;
    }

    public void setRole_cd(String role_cd) {
        this.role_cd = role_cd;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getSingup_type() {
        return singup_type;
    }

    public void setSingup_type(String singup_type) {
        this.singup_type = singup_type;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public UserVO(String user_id, String role_cd, String user_pwd, String user_name, String user_birthday,
            String phone_no, String singup_type, String reg_date, String postcode, String address,
            String detail_address) {
        super();
        this.user_id = user_id;
        this.role_cd = role_cd;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_birthday = user_birthday;
        this.phone_no = phone_no;
        this.singup_type = singup_type;
        this.reg_date = reg_date;
        this.postcode = postcode;
        this.address = address;
        this.detail_address = detail_address;
    }

    public UserVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String detail_address;

}
