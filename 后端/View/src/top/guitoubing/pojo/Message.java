package top.guitoubing.pojo;

public class Message {
    private Integer id;

    private Short type;

    private Long date;

    private Integer itemid;

    private Integer groupid;

    public Message(Integer id, Short type, Long date, Integer itemid, Integer groupid) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.itemid = itemid;
        this.groupid = groupid;
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}