package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.LikeNotificationMapper;
import top.guitoubing.mapper.NotificationMapper;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.LikeNotification;
import top.guitoubing.pojo.Notification;
import top.guitoubing.pojo.User;
import top.guitoubing.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    LikeNotificationMapper likeNotificationMapper;

    @Override
    public void createNotification(String title, String content, Short priority, long now ,long limit , Group group, User user) {
        Notification notification = new Notification(notificationMapper.maxId()+1, title, content, now, "1", user.getId(), group.getId(), limit, priority);
        notificationMapper.insert(notification);
    }

    @Override
    public void addLiked(Integer nid, User user) {
        likeNotificationMapper.insert(new LikeNotification(nid, user.getId()));
    }

    @Override
    public void removeLiked(Integer nid, User user) {
        likeNotificationMapper.deleteByPrimaryKey(nid);
    }

    @Override
    public void updateNotification(Integer nid, String title, String content, long end) {
        Notification notification = notificationMapper.selectByPrimaryKey(nid);
        notification.setTitle(title);
        notification.setContent(content);
        notification.setEnddate(end);
        notificationMapper.updateByPrimaryKey(notification);
    }


}
