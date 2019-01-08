package top.guitoubing.pojo;

public class SuperviseKey {
    private Integer userid;

    private Integer supid;

    public SuperviseKey(Integer userid, Integer supid) {
        this.userid = userid;
        this.supid = supid;
    }

    public SuperviseKey() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSupid() {
        return supid;
    }

    public void setSupid(Integer supid) {
        this.supid = supid;
    }
}