package top.guitoubing.pojo.Data;

import top.guitoubing.pojo.Message;

import java.util.List;

public class MessageData{

    private String groupName;

    private String avator;

    private Integer id;

    private Short type;

    private Long date;

    private Integer itemid;

    private Integer groupid;

    public MessageData() {
    }

    public MessageData(String groupName, String avator, Integer id, Short type, Long date, Integer itemid, Integer groupid) {
        this.groupName = groupName;
        this.avator = avator;
        this.id = id;
        this.type = type;
        this.date = date;
        this.itemid = itemid;
        this.groupid = groupid;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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