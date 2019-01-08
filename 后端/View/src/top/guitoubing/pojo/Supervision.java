package top.guitoubing.pojo;

public class Supervision {
    private Integer id;

    private String title;

    private String content;

    private String punishment;

    private Long createdate;

    private Long startdate;

    private Long enddate;

    private Integer creator;

    private Integer groupid;

    private String status;

    public Supervision(Integer id, String title, String content, String punishment, Long createdate, Long startdate, Long enddate, Integer creator, Integer groupid, String status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.punishment = punishment;
        this.createdate = createdate;
        this.startdate = startdate;
        this.enddate = enddate;
        this.creator = creator;
        this.groupid = groupid;
        this.status = status;
    }

    public Supervision() {
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

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment == null ? null : punishment.trim();
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}