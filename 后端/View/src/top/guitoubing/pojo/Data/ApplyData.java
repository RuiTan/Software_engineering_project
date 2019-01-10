package top.guitoubing.pojo.Data;

public class ApplyData {

    private Integer uid;
    private String uname;
    private Integer gid;
    private String gname;

    public ApplyData() {
    }

    public ApplyData(Integer uid, String uname, Integer gid, String gname) {
        this.uid = uid;
        this.uname = uname;
        this.gid = gid;
        this.gname = gname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}
