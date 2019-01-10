package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.DemandItemMapper;
import top.guitoubing.mapper.GroupDemandMapper;
import top.guitoubing.pojo.Data.GroupDemandData;
import top.guitoubing.pojo.DemandItem;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.GroupDemand;
import top.guitoubing.pojo.User;
import top.guitoubing.service.GroupDemandService;
import top.guitoubing.util.TimeUtil;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GroupDemandServiceImpl implements GroupDemandService {

    @Autowired
    GroupDemandMapper groupDemandMapper;

    @Autowired
    DemandItemMapper demandItemMapper;

    @Override
    public List<GroupDemandData> getGroupDemandData(Integer gid) {
        List<GroupDemandData> groupDemandData = groupDemandMapper.selectByGroup(gid);
        for (GroupDemandData gdd : groupDemandData){
            gdd.setDemandItems(demandItemMapper.selectByDemand(gdd.getId()));
            gdd.setItemCount(gdd.getDemandItems().size());
            for (DemandItem demandItem : gdd.getDemandItems()){
                gdd.setPrice(gdd.getPrice() + demandItem.getPrice().intValue());
            }
        }
        return groupDemandData;
    }

    @Override
    public void createDemand(String data, String title, String content, Group group, User user) {
        String[] bills = data.split("=====");
        GroupDemand groupDemand = new GroupDemand();
        groupDemand.setId(groupDemandMapper.maxId()+1);
        groupDemand.setTitle(title);
        groupDemand.setContent(content);
        groupDemand.setCreatedate(TimeUtil.currentStamp());
        groupDemand.setCreator(user.getId());
        groupDemand.setGroupid(group.getId());
        groupDemandMapper.insert(groupDemand);
        for (String bill : bills){
            String[] i = bill.split("-----");
            DemandItem item = new DemandItem(demandItemMapper.maxId()+1, groupDemand.getId(), i[0], i[1], i[2], Double.valueOf(i[3]));
            demandItemMapper.insert(item);
        }
    }
}
