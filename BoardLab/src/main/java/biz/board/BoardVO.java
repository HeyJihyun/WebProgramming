package biz.board;

import java.util.Date;

public class BoardVO {

    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regdate;

    public BoardVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BoardVO(int seq, String title, String writer, String content, Date regdate) {
        super();
        this.seq = seq;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regdate = regdate;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
                + regdate + "]";
    }

}
