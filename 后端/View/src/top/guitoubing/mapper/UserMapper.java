package top.guitoubing.mapper;

import top.guitoubing.pojo.Data.ApplyData;
import top.guitoubing.pojo.Data.GroupSearchData;
import top.guitoubing.pojo.Data.MessageData;
import top.guitoubing.pojo.Data.NotificationData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.Notification;
import top.guitoubing.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertGroup(Group group);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByTel(String tel);

    Integer getMaxId();

    Integer getMaxGroupId();

    List<Group> selectByUser(Integer id);

    List<Group> selectInviteByUser(Integer id);

    Integer countTask(Integer id);

    Integer countSV(Integer id);

    Integer countNotice(Integer id);

    List<MessageData> getMessage(Integer id);

    List<ApplyData> getApply(Integer id);

    List<GroupSearchData> getGroups();

    List<GroupSearchData> selectGroupByUserIn(Integer id);

    List<GroupSearchData> selectGroupByKey(String key);

    Group getGroup(Integer id);

    List<NotificationData> selectNotifByGroup(Integer id);

    List<NotificationData> selectNotifByLiked(Integer id);

}