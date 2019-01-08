package top.guitoubing.pojo;

public class LikeNotification {
    private Integer notifId;

    private Integer userId;

    public LikeNotification(Integer notifId, Integer userId) {
        this.notifId = notifId;
        this.userId = userId;
    }

    public LikeNotification() {
        super();
    }

    public Integer getNotifId() {
        return notifId;
    }

    public void setNotifId(Integer notifId) {
        this.notifId = notifId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}