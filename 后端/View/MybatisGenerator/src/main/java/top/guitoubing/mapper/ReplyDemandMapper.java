package top.guitoubing.mapper;

import top.guitoubing.pojo.ReplyDemand;
import top.guitoubing.pojo.ReplyDemandKey;

public interface ReplyDemandMapper {
    int deleteByPrimaryKey(ReplyDemandKey key);

    int insert(ReplyDemand record);

    int insertSelective(ReplyDemand record);

    ReplyDemand selectByPrimaryKey(ReplyDemandKey key);

    int updateByPrimaryKeySelective(ReplyDemand record);

    int updateByPrimaryKey(ReplyDemand record);
}