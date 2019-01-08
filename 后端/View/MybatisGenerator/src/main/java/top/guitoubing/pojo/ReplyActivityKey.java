package top.guitoubing.pojo;

public class ReplyActivityKey {
    private Integer userid;

    private Integer activityid;

    public ReplyActivityKey(Integer userid, Integer activityid) {
        this.userid = userid;
        this.activityid = activityid;
    }

    public ReplyActivityKey() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }
}