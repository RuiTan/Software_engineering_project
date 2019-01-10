package top.guitoubing.pojo.Data;

import top.guitoubing.pojo.DemandItem;

import java.util.List;

public class GroupDemandData {

    private Integer id;

    private String title;

    private String content;

    private Long createdate;

    private Long enddate;

    private Integer creator;

    private Integer groupid;

    private String status;

    private String creatorName;

    private String avator;

    private Integer price;

    private Integer itemCount;

    List<DemandItem> demandItems;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public List<DemandItem> getDemandItems() {
        return demandItems;
    }

    public void setDemandItems(List<DemandItem> demandItems) {
        this.demandItems = demandItems;
    }

    public GroupDemandData() {
    }

    public GroupDemandData(Integer id, String title, String content, Long createdate, Long enddate, Integer creator, Integer groupid, String status, String creatorName, String avator, Integer price, Integer itemCount, List<DemandItem> demandItems) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.enddate = enddate;
        this.creator = creator;
        this.groupid = groupid;
        this.status = status;
        this.creatorName = creatorName;
        this.avator = avator;
        this.price = price;
        this.itemCount = itemCount;
        this.demandItems = demandItems;
    }

    public GroupDemandData(Integer id, String title, String content, Long createdate, Long enddate, Integer creator, Integer groupid, String status, String creatorName, String avator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.enddate = enddate;
        this.creator = creator;
        this.groupid = groupid;
        this.status = status;
        this.creatorName = creatorName;
        this.avator = avator;
        this.price = 0;
        this.itemCount = 0;
    }
}
