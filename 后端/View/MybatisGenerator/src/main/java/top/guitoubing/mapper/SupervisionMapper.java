package top.guitoubing.mapper;

import top.guitoubing.pojo.Supervision;

public interface SupervisionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supervision record);

    int insertSelective(Supervision record);

    Supervision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supervision record);

    int updateByPrimaryKey(Supervision record);
}