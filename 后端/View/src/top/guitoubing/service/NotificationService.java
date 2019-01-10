package top.guitoubing.service;

import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.User;

public interface NotificationService {

    void createNotification(String title, String content, Short priority, long now ,long limit , Group group, User user);

    void addLiked(Integer nid, User user);

    void removeLiked(Integer nid, User user);

    void updateNotification(Integer nid, String title, String content, long end);
}
