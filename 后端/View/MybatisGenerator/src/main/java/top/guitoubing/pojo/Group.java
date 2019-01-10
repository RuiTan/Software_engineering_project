package top.guitoubing.pojo;

public class Group {
    private Integer id;

    private String name;

    private Integer creator;

    private Long createdate;

    private String avator;

    private String intro;

    public Group(Integer id, String name, Integer creator, Long createdate, String avator, String intro) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createdate = createdate;
        this.avator = avator;
        this.intro = intro;
    }

    public Group() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
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
        this.avator = avator == null ? null : avator.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}