package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.SuperviseMapper;
import top.guitoubing.mapper.SupervisionMapper;
import top.guitoubing.pojo.*;
import top.guitoubing.pojo.Data.SupervisionData;
import top.guitoubing.service.SupervisionService;
import top.guitoubing.util.ConstantDefinition;

import java.util.List;

@Service
public class SupervisionServiceImpl implements SupervisionService {

    @Autowired
    SupervisionMapper supervisionMapper;

    @Autowired
    SuperviseMapper superviseMapper;

    @Override
    public List<SupervisionData> getSupervisionData(Integer id, User user) {
        List<SupervisionData> groupSV = supervisionMapper.selectSVByGroup(id);
        List<SupervisionData> supervised = supervisionMapper.selectSVBySupervised(user.getId());
        List<SupervisionData> supervisor = supervisionMapper.selectSVBySupervisor(user.getId());
        for (SupervisionData gs : groupSV){
            gs.setSupervised(supervisionMapper.selectUserBySupervised(gs.getId()));
            gs.setSupervisor(supervisionMapper.selectUserBySupervisor(gs.getId()));
            for (SupervisionData sed : supervised){
                if (gs.getId().equals(sed.getId())){
                    gs.setType(ConstantDefinition.SUPERVISED);
                }
            }
            for (SupervisionData sor : supervisor){
                if (gs.getId().equals(sor.getId())){
                    gs.setType(ConstantDefinition.SUPERVISOR);
                }
            }
        }
        return groupSV;
    }



    @Override
    public void cancelSupervision(Integer id) {
        Supervision supervision = supervisionMapper.selectByPrimaryKey(id);
        supervision.setStatus(ConstantDefinition.SV_INVALID);
        supervisionMapper.updateByPrimaryKey(supervision);
    }

    @Override
    public void supervise(Integer id, User user) {
        Supervise supervise = superviseMapper.selectByPrimaryKey(new SuperviseKey(user.getId(), id));
        if (supervise == null){
            supervise = new Supervise(user.getId(), id, Short.valueOf(String.valueOf(ConstantDefinition.SUPERVISOR)));
            superviseMapper.insert(supervise);
        }else {
            supervise.setType(Short.valueOf(String.valueOf(ConstantDefinition.SUPERVISOR)));
            superviseMapper.updateByPrimaryKey(supervise);
        }
    }

    @Override
    public void supervised(Integer id, User user) {
        Supervise supervise = superviseMapper.selectByPrimaryKey(new SuperviseKey(user.getId(), id));
        if (supervise == null){
            supervise = new Supervise(user.getId(), id, Short.valueOf(String.valueOf(ConstantDefinition.SUPERVISED)));
            superviseMapper.insert(supervise);
        }else {
            supervise.setType(Short.valueOf(String.valueOf(ConstantDefinition.SUPERVISED)));
            superviseMapper.updateByPrimaryKey(supervise);
        }
    }

    @Override
    public void createSupervision(String title, String content, String punish, Long begin, Long end, Group group, User user) {
        Supervision supervision = new Supervision(supervisionMapper.maxId()+1, title, content, punish, begin, begin, end, user.getId(), group.getId(), ConstantDefinition.SV_WAITING);
        supervisionMapper.insert(supervision);
        supervised(supervision.getId(), user);
    }
}
