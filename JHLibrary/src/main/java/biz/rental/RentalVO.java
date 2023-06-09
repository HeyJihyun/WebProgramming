package biz.rental;

public class RentalVO {

    private int r_no;
    private int b_no;
    private String title;
    private String author;
    private String cover;
    private String rentalDate;
    private String returnDate;
    private int extension;

    public RentalVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RentalVO(int r_no, int b_no, String title, String author, String cover, String rentalDate, String returnDate,
            int extension) {
        super();
        this.r_no = r_no;
        this.b_no = b_no;
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.extension = extension;
    }

    public int getR_no() {
        return r_no;
    }

    public void setR_no(int r_no) {
        this.r_no = r_no;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "RentalVO [r_no=" + r_no + ", b_no=" + b_no + ", title=" + title + ", author=" + author + ", cover="
                + cover + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate + ", extension=" + extension
                + "]";
    }

}
