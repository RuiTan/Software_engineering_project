package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.GroupTaskMapper;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.GroupTask;
import top.guitoubing.pojo.User;
import top.guitoubing.service.GroupTaskService;

import java.util.List;

@Service
public class GroupTaskServiceImpl implements GroupTaskService {

    @Autowired
    GroupTaskMapper groupTaskMapper;

    @Override
    public void createGroupTask(String title, String content, Long start, Long end, Group group, User user) {
        GroupTask groupTask = new GroupTask(groupTaskMapper.maxId()+1, title, content, start, user.getId(), group.getId(), start, end, "1");
        groupTaskMapper.insert(groupTask);
    }

    @Override
    public void editGroupTask(Integer id, String title, String content, String status) {
        GroupTask groupTask = groupTaskMapper.selectByPrimaryKey(id);
        groupTask.setTitle(title);
        groupTask.setContent(content);
        groupTask.setStatus(status);
        groupTaskMapper.updateByPrimaryKey(groupTask);
    }

    @Override
    public List<GroupTask> getGroupTask(Integer gid) {
        return groupTaskMapper.selectByGroup(gid);
    }


}
