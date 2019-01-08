package top.guitoubing.pojo;

public class Group {
    private Integer id;

    private String name;

    private Integer creator;

    private Long createdate;

    public Group(Integer id, String name, Integer creator, Long createdate) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createdate = createdate;
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
}