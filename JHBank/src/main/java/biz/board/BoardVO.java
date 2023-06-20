package biz.board;

public class BoardVO {

    private int b_no;
    private String title;
    private String user_id;
    private String name;
    private String content;
    private int hits;
    private String reg_date;
    private int group_id;
    private String thred;

    public BoardVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BoardVO(int b_no, String title, String user_id, String name, String content, int hits, String reg_date,
            int group_id, String thred) {
        super();
        this.b_no = b_no;
        this.title = title;
        this.user_id = user_id;
        this.name = name;
        this.content = content;
        this.hits = hits;
        this.reg_date = reg_date;
        this.group_id = group_id;
        this.thred = thred;
    }

    public int getB_no() {
        return b_no;
    }

    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getThred() {
        return thred;
    }

    public void setThred(String thred) {
        this.thred = thred;
    }

    @Override
    public String toString() {
        return "BoardVO [b_no=" + b_no + ", title=" + title + ", user_id=" + user_id + ", name=" + name + ", content="
                + content + ", hits=" + hits + ", reg_date=" + reg_date + ", group_id=" + group_id + ", thred=" + thred
                + "]";
    }

}
