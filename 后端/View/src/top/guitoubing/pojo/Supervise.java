package top.guitoubing.pojo;

public class Supervise extends SuperviseKey {
    private Short type;

    public Supervise(Integer userid, Integer supid, Short type) {
        super(userid, supid);
        this.type = type;
    }

    public Supervise() {
        super();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
}