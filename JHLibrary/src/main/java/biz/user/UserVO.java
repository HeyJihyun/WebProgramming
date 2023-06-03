package biz.user;

public class UserVO {

    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String grade;

    public UserVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserVO(String id, String pwd, String name, String phone) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
    }

    public UserVO(String id, String pwd, String name, String phone, String grade) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", grade=" + grade + "]";
    }

}
