package top.guitoubing.service;

import top.guitoubing.pojo.Data.GroupSearchData;
import top.guitoubing.pojo.Data.NotificationData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.User;

import java.util.List;

public interface GroupService {

    void CreateGroup(User user, String gname, String gintro, String gtag);

    boolean UpdateUserStatus(Integer uid, Integer gid);

    boolean ApplyForJoinGroup(User user, Integer gid);

    List<GroupSearchData> GetGroupByKey(String key, User user);

    List<GroupSearchData> GetGroups(User user);

    Group getGroup(Integer id);

    List<NotificationData> getNotifByGroup(Integer id);

    List<NotificationData> getNotifByLiked(Integer id);

    List<NotificationData> getNotification(Integer uid, Integer gid);

    List<User> getGroupUsers(Integer gid);

}
