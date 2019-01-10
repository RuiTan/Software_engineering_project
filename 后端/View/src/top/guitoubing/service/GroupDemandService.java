package top.guitoubing.service;

import top.guitoubing.pojo.Data.GroupDemandData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.User;

import java.util.List;

public interface GroupDemandService {

    List<GroupDemandData> getGroupDemandData(Integer gid);

    void createDemand(String data, String title, String content, Group group, User user);

}
