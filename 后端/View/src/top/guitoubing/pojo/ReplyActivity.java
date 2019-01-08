package top.guitoubing.pojo;

public class ReplyActivity extends ReplyActivityKey {
    private Short type;

    private String content;

    public ReplyActivity(Integer userid, Integer activityid, Short type, String content) {
        super(userid, activityid);
        this.type = type;
        this.content = content;
    }

    public ReplyActivity() {
        super();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}