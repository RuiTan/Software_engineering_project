package top.guitoubing.mapper;

import top.guitoubing.pojo.GroupActivity;

public interface GroupActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupActivity record);

    int insertSelective(GroupActivity record);

    GroupActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupActivity record);

    int updateByPrimaryKey(GroupActivity record);
}