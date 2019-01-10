package top.guitoubing.mapper;

import top.guitoubing.pojo.UserInGroup;
import top.guitoubing.pojo.UserInGroupKey;

public interface UserInGroupMapper {
    int deleteByPrimaryKey(UserInGroupKey key);

    int insert(UserInGroup record);

    int insertSelective(UserInGroup record);

    UserInGroup selectByPrimaryKey(UserInGroupKey key);

    int updateByPrimaryKeySelective(UserInGroup record);

    int updateByPrimaryKey(UserInGroup record);

    Integer countUsers(Integer id);
}