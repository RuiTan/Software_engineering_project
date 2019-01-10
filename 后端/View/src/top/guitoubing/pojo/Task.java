package top.guitoubing.pojo;

public class Task {
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

    public Task(Integer id, String title, String content, String status, Long createdate, Long limitdate, Integer creator, Integer groupid, Integer users, Integer calcusers) {
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
    }

    public Task() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
}