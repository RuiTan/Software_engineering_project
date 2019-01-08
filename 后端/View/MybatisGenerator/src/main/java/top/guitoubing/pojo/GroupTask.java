package top.guitoubing.pojo;

public class GroupTask {
    private Integer id;

    private String title;

    private String content;

    private Long createdate;

    private Integer creator;

    private Integer groupid;

    private Long startdate;

    private Long enddate;

    private String status;

    public GroupTask(Integer id, String title, String content, Long createdate, Integer creator, Integer groupid, Long startdate, Long enddate, String status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.creator = creator;
        this.groupid = groupid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
    }

    public GroupTask() {
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

    public Long getStartdate() {
        return startdate;
    }

    public void setStartdate(Long startdate) {
        this.startdate = startdate;
    }

    public Long getEnddate() {
        return enddate;
    }

    public void setEnddate(Long enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}