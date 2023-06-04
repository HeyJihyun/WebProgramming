package biz.book;

public class BookVO {

    private int b_no; // 도서번호
    private String isbn13; // isbn
    private String title; // 책 제목
    private String author; // 저자
    private String pubDate; // 출판일
    private String regDate; // 등록일
    private String cover; // 책표지
    private String categoryName; // 카테고리
    private String publisher; // 출판사
    private int itemPage; // 책 페이지수
    private String description; // 책설명
    private String b_status; // 책(대여)상태
    private int r_count; // 대여 된 횟수
    private BookVO bookinfo; // api에서 책 페이지 수를 받아오기 위한 변수

    public BookVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BookVO(int b_no, String isbn13, String title, String author, String pubDate, String regDate, String cover,
            String categoryName, String publisher, int itemPage, String description, String b_status, int r_count,
            BookVO bookinfo) {
        super();
        this.b_no = b_no;
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.regDate = regDate;
        this.cover = cover;
        this.categoryName = categoryName;
        this.publisher = publisher;
        this.itemPage = itemPage;
        this.description = description;
        this.b_status = b_status;
        this.r_count = r_count;
        this.bookinfo = bookinfo;
    }

    public int getB_no() {
        return b_no;
    }

    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getItemPage() {
        return itemPage;
    }

    public void setItemPage(int itemPage) {
        this.itemPage = itemPage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getB_status() {
        return b_status;
    }

    public void setB_status(String b_status) {
        this.b_status = b_status;
    }

    public int getR_count() {
        return r_count;
    }

    public void setR_count(int r_count) {
        this.r_count = r_count;
    }

    public BookVO getBookinfo() {
        return bookinfo;
    }

    public void setBookinfo(BookVO bookinfo) {
        this.bookinfo = bookinfo;
    }

    @Override
    public String toString() {
        return "BookVO [b_no=" + b_no + ", isbn13=" + isbn13 + ", title=" + title + ", author=" + author + ", pubDate="
                + pubDate + ", regDate=" + regDate + ", cover=" + cover + ", categoryName=" + categoryName
                + ", publisher=" + publisher + ", itemPage=" + itemPage + ", description=" + description + ", b_status="
                + b_status + ", r_count=" + r_count + ", bookinfo=" + bookinfo + "]";
    }

}
