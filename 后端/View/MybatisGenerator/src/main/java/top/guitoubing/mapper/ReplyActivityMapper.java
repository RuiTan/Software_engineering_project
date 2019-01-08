package top.guitoubing.mapper;

import top.guitoubing.pojo.ReplyActivity;
import top.guitoubing.pojo.ReplyActivityKey;

public interface ReplyActivityMapper {
    int deleteByPrimaryKey(ReplyActivityKey key);

    int insert(ReplyActivity record);

    int insertSelective(ReplyActivity record);

    ReplyActivity selectByPrimaryKey(ReplyActivityKey key);

    int updateByPrimaryKeySelective(ReplyActivity record);

    int updateByPrimaryKey(ReplyActivity record);
}