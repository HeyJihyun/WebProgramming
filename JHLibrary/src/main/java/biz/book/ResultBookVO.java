package biz.book;

import java.util.Arrays;

public class ResultBookVO {

    private BookVO[] item;
    private int errorCode;
    private String errorMessage;

    public ResultBookVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ResultBookVO(BookVO[] item, int errorCode, String errorMessage) {
        super();
        this.item = item;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BookVO[] getItem() {
        return item;
    }

    public void setItem(BookVO[] item) {
        this.item = item;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ResultBookVO [item=" + Arrays.toString(item) + ", errorCode=" + errorCode + ", errorMessage="
                + errorMessage + "]";
    }

}
