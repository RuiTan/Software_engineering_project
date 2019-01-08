package top.guitoubing.pojo;

public class DemandItem {
    private Integer id;

    private Integer demandid;

    private String name;

    private String description;

    private String link;

    private Double price;

    public DemandItem(Integer id, Integer demandid, String name, String description, String link, Double price) {
        this.id = id;
        this.demandid = demandid;
        this.name = name;
        this.description = description;
        this.link = link;
        this.price = price;
    }

    public DemandItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDemandid() {
        return demandid;
    }

    public void setDemandid(Integer demandid) {
        this.demandid = demandid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}