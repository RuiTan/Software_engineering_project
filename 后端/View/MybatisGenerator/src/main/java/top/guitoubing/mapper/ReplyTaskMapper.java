package top.guitoubing.mapper;

import top.guitoubing.pojo.ReplyTask;
import top.guitoubing.pojo.ReplyTaskKey;

public interface ReplyTaskMapper {
    int deleteByPrimaryKey(ReplyTaskKey key);

    int insert(ReplyTask record);

    int insertSelective(ReplyTask record);

    ReplyTask selectByPrimaryKey(ReplyTaskKey key);

    int updateByPrimaryKeySelective(ReplyTask record);

    int updateByPrimaryKey(ReplyTask record);
}