package top.guitoubing.pojo;

public class ReplyDemand extends ReplyDemandKey {
    private Short type;

    private String content;

    public ReplyDemand(Integer userid, Integer demandid, Short type, String content) {
        super(userid, demandid);
        this.type = type;
        this.content = content;
    }

    public ReplyDemand() {
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