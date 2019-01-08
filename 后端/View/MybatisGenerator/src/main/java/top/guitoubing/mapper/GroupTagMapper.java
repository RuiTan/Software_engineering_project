package top.guitoubing.mapper;

import top.guitoubing.pojo.GroupTagKey;

public interface GroupTagMapper {
    int deleteByPrimaryKey(GroupTagKey key);

    int insert(GroupTagKey record);

    int insertSelective(GroupTagKey record);
}