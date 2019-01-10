package top.guitoubing.pojo.Data;

public class GroupSearchData {

    private Integer id;

    private String name;

    private Long createdate;

    private String avator;

    private String intro;

    private String creator;

    private Integer status;

    public GroupSearchData() {
        status = 0;
    }

    public GroupSearchData(Integer id, String name, Long createdate, String avator, String intro, String creator, Integer status) {
        this.id = id;
        this.name = name;
        this.createdate = createdate;
        this.avator = avator;
        this.intro = intro;
        this.creator = creator;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
