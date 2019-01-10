package top.guitoubing.mapper;

import top.guitoubing.pojo.GroupTask;

import java.util.List;

public interface GroupTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupTask record);

    int insertSelective(GroupTask record);

    GroupTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupTask record);

    int updateByPrimaryKey(GroupTask record);

    Integer maxId();

    List<GroupTask> selectByGroup(Integer gid);
}