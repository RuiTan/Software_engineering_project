package top.guitoubing.pojo;

public class GroupTagKey {
    private Integer groupid;

    private Integer tagid;

    public GroupTagKey(Integer groupid, Integer tagid) {
        this.groupid = groupid;
        this.tagid = tagid;
    }

    public GroupTagKey() {
        super();
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }
}