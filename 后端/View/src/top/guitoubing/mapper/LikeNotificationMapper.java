package top.guitoubing.mapper;

import top.guitoubing.pojo.LikeNotification;

public interface LikeNotificationMapper {
    int deleteByPrimaryKey(Integer notifId);

    int insert(LikeNotification record);

    int insertSelective(LikeNotification record);

    LikeNotification selectByPrimaryKey(Integer notifId);

    int updateByPrimaryKeySelective(LikeNotification record);

    int updateByPrimaryKey(LikeNotification record);
}