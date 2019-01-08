package top.guitoubing.mapper;

import top.guitoubing.pojo.GroupDemand;

public interface GroupDemandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupDemand record);

    int insertSelective(GroupDemand record);

    GroupDemand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupDemand record);

    int updateByPrimaryKey(GroupDemand record);
}