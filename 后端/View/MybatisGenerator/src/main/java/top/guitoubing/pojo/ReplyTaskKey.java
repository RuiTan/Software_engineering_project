package top.guitoubing.pojo;

public class ReplyTaskKey {
    private Integer userid;

    private Integer taskid;

    public ReplyTaskKey(Integer userid, Integer taskid) {
        this.userid = userid;
        this.taskid = taskid;
    }

    public ReplyTaskKey() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }
}