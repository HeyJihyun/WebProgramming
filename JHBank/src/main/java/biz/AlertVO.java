package biz;

public class AlertVO {
    private String icon;
    private String msg;
    private String text;
    private String url;

    public AlertVO() {
        icon = "success";
    }

    public AlertVO(int icon, String msg, String text, String url) {
        super();
        switch (icon) {
        case 0:
            this.icon = "error";
            break;
        case 1:
            this.icon = "success";
            break;
        case 3:
            this.icon = "warning";
            break;
        case 4:
            this.icon = "info";
            break;
        case 5:
            this.icon = "question";
            break;
        }
        this.msg = msg;
        this.text = text;
        this.url = url;
    }

    @Override
    public String toString() {
        return "alertVO [icon=" + icon + ", msg=" + msg + ", text=" + text + ", url=" + url + "]";
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
