package biz.user;

public class UserVO {

    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String grade;
    private String return_date;

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

    public UserVO(String id, String pwd, String name, String phone, String grade, String return_date) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.grade = grade;
        this.return_date = return_date;
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

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", grade=" + grade
                + ", return_date=" + return_date + "]";
    }

}
