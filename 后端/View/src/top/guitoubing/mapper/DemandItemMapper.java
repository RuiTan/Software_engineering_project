package top.guitoubing.mapper;

import top.guitoubing.pojo.DemandItem;

import java.util.List;

public interface DemandItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DemandItem record);

    int insertSelective(DemandItem record);

    DemandItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemandItem record);

    int updateByPrimaryKey(DemandItem record);

    List<DemandItem> selectByDemand(Integer id);

    Integer maxId();
}