package top.guitoubing.pojo;

public class ReplyDemandKey {
    private Integer userid;

    private Integer demandid;

    public ReplyDemandKey(Integer userid, Integer demandid) {
        this.userid = userid;
        this.demandid = demandid;
    }

    public ReplyDemandKey() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDemandid() {
        return demandid;
    }

    public void setDemandid(Integer demandid) {
        this.demandid = demandid;
    }
}