package top.guitoubing.service;

import top.guitoubing.pojo.Data.TaskData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.User;
import top.guitoubing.pojo.UserInGroup;

import java.util.List;

public interface TaskService {

    List<TaskData> getTasks(Group group, User user);

    void createTask(String title, String content, Long begin, Long end, Integer members, Group group, User user);

    void refuseTask(Integer id, Group group, User user);
    void acceptTask(Integer id, Group group, User user);

    void achiveTask(Integer id, Group group, User user);
    void cancelTask(Integer id, Group group, User user);

}
