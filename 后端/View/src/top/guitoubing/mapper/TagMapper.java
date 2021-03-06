package top.guitoubing.mapper;

import top.guitoubing.pojo.Tag;

public interface TagMapper {

    Integer maxId();

    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}