package top.guitoubing.service;

import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.GroupTask;
import top.guitoubing.pojo.User;

import java.util.List;

public interface GroupTaskService {

    void createGroupTask(String title, String content, Long start, Long end, Group group, User user);

    void editGroupTask(Integer id,String title, String content, String status);

    List<GroupTask> getGroupTask(Integer gid);

}
