package top.guitoubing.pojo.Data;

import top.guitoubing.pojo.User;

import java.util.List;

public class SupervisionData {

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

    private String creatorName;

    private String avator;

    private Integer type;

    private List<String> supervisor;

    private List<String> supervised;

    public SupervisionData() {
    }

    public SupervisionData(Integer id, String title, String content, String punishment, Long createdate, Long startdate, Long enddate, Integer creator, Integer groupid, String status, String creatorName, String avator, Integer type, List<String> supervisor, List<String> supervised) {
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
        this.creatorName = creatorName;
        this.avator = avator;
        this.type = type;
        this.supervisor = supervisor;
        this.supervised = supervised;
    }

    public SupervisionData(Integer id, String title, String content, String punishment, Long createdate, Long startdate, Long enddate, Integer creator, Integer groupid, String status, String creatorName, String avator, Integer type) {

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
        this.creatorName = creatorName;
        this.avator = avator;
        this.type = type;
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

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
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
        this.status = status;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(List<String> supervisor) {
        this.supervisor = supervisor;
    }

    public List<String> getSupervised() {
        return supervised;
    }

    public void setSupervised(List<String> supervised) {
        this.supervised = supervised;
    }
}
