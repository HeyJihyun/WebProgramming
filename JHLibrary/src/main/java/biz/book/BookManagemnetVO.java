package biz.book;

public class BookManagemnetVO extends BookVO {
    private int count;
    private int ableRantalCnt;

    public BookManagemnetVO() {
        super();
    }

    public BookManagemnetVO(int b_no, String isbn13, String title, String author, String pubDate, String regDate,
            String cover, String categoryName, String publisher, int itemPage, String description, String b_status,
            int r_count, BookVO bookinfo) {
        super(b_no, isbn13, title, author, pubDate, regDate, cover, categoryName, publisher, itemPage, description,
                b_status, r_count, bookinfo);
    }

    public BookManagemnetVO(int b_no, String isbn13, String title, String author, String pubDate, String regDate,
            String cover, String categoryName, String publisher, int itemPage, String description, String b_status,
            int r_count, BookVO bookinfo, int count, int ableRantalCnt) {
        super(b_no, isbn13, title, author, pubDate, regDate, cover, categoryName, publisher, itemPage, description,
                b_status, r_count, bookinfo);
        this.count = count;
        this.ableRantalCnt = ableRantalCnt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAbleRantalCnt() {
        return ableRantalCnt;
    }

    public void setAbleRantalCnt(int ableRantalCnt) {
        this.ableRantalCnt = ableRantalCnt;
    }

    @Override
    public String toString() {
        return "BookManagemnetVO [count=" + count + ", ableRantalCnt=" + ableRantalCnt + "]";
    }

}
