package top.guitoubing.mapper;

import top.guitoubing.pojo.Notification;

public interface NotificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
}