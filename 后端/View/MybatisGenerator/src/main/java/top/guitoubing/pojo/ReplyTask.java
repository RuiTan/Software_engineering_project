package top.guitoubing.pojo;

public class ReplyTask extends ReplyTaskKey {
    private Short type;

    private String content;

    public ReplyTask(Integer userid, Integer taskid, Short type, String content) {
        super(userid, taskid);
        this.type = type;
        this.content = content;
    }

    public ReplyTask() {
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