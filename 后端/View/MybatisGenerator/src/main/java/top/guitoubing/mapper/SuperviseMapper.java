package top.guitoubing.mapper;

import top.guitoubing.pojo.Supervise;
import top.guitoubing.pojo.SuperviseKey;

public interface SuperviseMapper {
    int deleteByPrimaryKey(SuperviseKey key);

    int insert(Supervise record);

    int insertSelective(Supervise record);

    Supervise selectByPrimaryKey(SuperviseKey key);

    int updateByPrimaryKeySelective(Supervise record);

    int updateByPrimaryKey(Supervise record);
}