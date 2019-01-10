package top.guitoubing.pojo.Data;

public class NotificationData {
    private Integer id;

    private String title;

    private String content;

    private Long createdate;

    private String status;

    private Integer creator;

    private Integer groupid;

    private Long enddate;

    private Short priority;

    private String name;

    private String avator;

    private Integer liked;

    public NotificationData() {
    }

    public NotificationData(Integer id, String title, String content, Long createdate, String status, Integer creator, Integer groupid, Long enddate, Short priority, String name, String avator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.status = status;
        this.creator = creator;
        this.groupid = groupid;
        this.enddate = enddate;
        this.priority = priority;
        this.name = name;
        this.avator = avator;
        this.liked = 0;
    }

    public NotificationData(Integer id, String title, String content, Long createdate, String status, Integer creator, Integer groupid, Long enddate, Short priority, String name, String avator, Integer liked) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.status = status;
        this.creator = creator;
        this.groupid = groupid;
        this.enddate = enddate;
        this.priority = priority;
        this.name = name;
        this.avator = avator;
        this.liked = liked;
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
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
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }
}
