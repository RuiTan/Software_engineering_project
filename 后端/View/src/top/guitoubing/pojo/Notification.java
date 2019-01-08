package top.guitoubing.pojo;

public class Notification {
    private Integer id;

    private String title;

    private String content;

    private Long createdate;

    private String status;

    private Integer creator;

    private Integer groupid;

    private Long enddate;

    private Short priority;

    public Notification(Integer id, String title, String content, Long createdate, String status, Integer creator, Integer groupid, Long enddate, Short priority) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.status = status;
        this.creator = creator;
        this.groupid = groupid;
        this.enddate = enddate;
        this.priority = priority;
    }

    public Notification() {
        super();
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
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public Long getEnddate() {
        return enddate;
    }

    public void setEnddate(Long enddate) {
        this.enddate = enddate;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }
}