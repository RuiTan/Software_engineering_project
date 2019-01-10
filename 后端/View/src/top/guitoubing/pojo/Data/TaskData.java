package top.guitoubing.pojo.Data;

import top.guitoubing.util.ConstantDefinition;

public class TaskData {

    private Integer id;

    private String title;

    private String content;

    private String status;

    private Long createdate;

    private Long limitdate;

    private Integer creator;

    private Integer groupid;

    private Integer users;

    private Integer calcusers;

    private String creatorName;

    private String avator;

    private Integer replyType;

    private String replyContent;



    public TaskData(Integer id, String title, String content, String status, Long createdate, Long limitdate, Integer creator, Integer groupid, Integer users, Integer calcusers, String creatorName, String avator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createdate = createdate;
        this.limitdate = limitdate;
        this.creator = creator;
        this.groupid = groupid;
        this.users = users;
        this.calcusers = calcusers;
        this.creatorName = creatorName;
        this.avator = avator;
        this.replyType = ConstantDefinition.REPLY_TASK_NONE;
        this.replyContent = "";
    }

    public TaskData(Integer id, String title, String content, String status, Long createdate, Long limitdate, Integer creator, Integer groupid, Integer users, Integer calcusers, String creatorName, String avator, Integer replyType, String replyContent) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createdate = createdate;
        this.limitdate = limitdate;
        this.creator = creator;
        this.groupid = groupid;
        this.users = users;
        this.calcusers = calcusers;
        this.creatorName = creatorName;
        this.avator = avator;
        this.replyType = replyType;
        this.replyContent = replyContent;
    }

    public TaskData() {
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public Long getLimitdate() {
        return limitdate;
    }

    public void setLimitdate(Long limitdate) {
        this.limitdate = limitdate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getCalcusers() {
        return calcusers;
    }

    public void setCalcusers(Integer calcusers) {
        this.calcusers = calcusers;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}

