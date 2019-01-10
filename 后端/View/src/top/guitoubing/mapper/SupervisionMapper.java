package top.guitoubing.mapper;

import top.guitoubing.pojo.Data.SupervisionData;
import top.guitoubing.pojo.Supervision;

import java.util.List;

public interface SupervisionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supervision record);

    int insertSelective(Supervision record);

    Supervision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supervision record);

    int updateByPrimaryKey(Supervision record);

    List<String> selectUserBySupervisor(Integer type);

    List<String> selectUserBySupervised(Integer type);

    List<SupervisionData> selectSVByGroup(Integer id);

    List<SupervisionData> selectSVBySupervised(Integer id);

    List<SupervisionData> selectSVBySupervisor(Integer id);

    Integer maxId();
}