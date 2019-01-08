package top.guitoubing.pojo;

public class UserInGroup extends UserInGroupKey {
    private Short stauts;

    private Short authority;

    public UserInGroup(Integer userid, Integer groupid, Short stauts, Short authority) {
        super(userid, groupid);
        this.stauts = stauts;
        this.authority = authority;
    }

    public UserInGroup() {
        super();
    }

    public Short getStauts() {
        return stauts;
    }

    public void setStauts(Short stauts) {
        this.stauts = stauts;
    }

    public Short getAuthority() {
        return authority;
    }

    public void setAuthority(Short authority) {
        this.authority = authority;
    }
}