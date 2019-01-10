package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.ReplyTaskMapper;
import top.guitoubing.mapper.TaskMapper;
import top.guitoubing.mapper.UserInGroupMapper;
import top.guitoubing.mapper.UserMapper;
import top.guitoubing.pojo.*;
import top.guitoubing.pojo.Data.TaskData;
import top.guitoubing.service.TaskService;
import top.guitoubing.util.ConstantDefinition;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ReplyTaskMapper replyTaskMapper;

    @Autowired
    UserInGroupMapper userInGroupMapper;

    @Override
    public List<TaskData> getTasks(Group group, User user) {
        List<TaskData> groupTask = userMapper.selectTaskByGroup(group.getId());
        List<TaskData> replyTask = userMapper.selectTaskByReply(user.getId());
        for (TaskData gt : groupTask){
            for (TaskData rt : replyTask){
                if (gt.getId().equals(rt.getId())){
                    gt.setReplyType(rt.getReplyType());
                    gt.setReplyContent(rt.getReplyContent());
                }
            }
        }
        return groupTask;
    }

    @Override
    public void createTask(String title, String content, Long begin, Long end, Integer members, Group group, User user) {
        Integer id = taskMapper.maxId()+1;
        Integer count = userInGroupMapper.countUsers(group.getId()) - 1;
        members = count >= members? members : count;
        Task task = new Task(id, title, content, "1", begin, end, user.getId(), group.getId(), members, members);
        taskMapper.insert(task);
    }

    @Override
    public void refuseTask(Integer id, Group group, User user) {
        ReplyTask replyTask = replyTaskMapper.selectByPrimaryKey(new ReplyTaskKey(user.getId(), id));
        replyTask.setType(Short.valueOf(String.valueOf(ConstantDefinition.REPLY_TASK_REFUSE)));
        Task task = taskMapper.selectByPrimaryKey(id);
        task.setCalcusers(task.getCalcusers()+1);
        taskMapper.updateByPrimaryKey(task);
        replyTaskMapper.updateByPrimaryKey(replyTask);
    }

    @Override
    public void acceptTask(Integer id, Group group, User user) {
        ReplyTask replyTask = replyTaskMapper.selectByPrimaryKey(new ReplyTaskKey(user.getId(), id));
        if (replyTask == null){
            replyTask = new ReplyTask(user.getId(), id, Short.valueOf(String.valueOf(ConstantDefinition.REPLY_TASK_ACCEPT)), "");
            replyTaskMapper.insert(replyTask);
        }else {
            replyTask.setType(Short.valueOf(String.valueOf(ConstantDefinition.REPLY_TASK_ACCEPT)));
            replyTaskMapper.updateByPrimaryKey(replyTask);
        }
        Task task = taskMapper.selectByPrimaryKey(id);
        task.setCalcusers(task.getCalcusers()-1);
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public void achiveTask(Integer id, Group group, User user) {
        Task task = taskMapper.selectByPrimaryKey(id);
        task.setCalcusers(-2);
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public void cancelTask(Integer id, Group group, User user) {
        Task task = taskMapper.selectByPrimaryKey(id);
        task.setCalcusers(-1);
        taskMapper.updateByPrimaryKey(task);
    }

}
