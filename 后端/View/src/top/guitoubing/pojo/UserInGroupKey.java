package top.guitoubing.pojo;

public class UserInGroupKey {
    private Integer userid;

    private Integer groupid;

    public UserInGroupKey(Integer userid, Integer groupid) {
        this.userid = userid;
        this.groupid = groupid;
    }

    public UserInGroupKey() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}