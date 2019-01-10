package top.guitoubing.service;

import top.guitoubing.pojo.Data.SupervisionData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.Task;
import top.guitoubing.pojo.User;

import java.util.List;

public interface SupervisionService {

    List<SupervisionData> getSupervisionData(Integer id, User user);

    void cancelSupervision(Integer id);

    void supervise(Integer id, User user);

    void supervised(Integer id, User user);

    void createSupervision(String title, String content, String punish, Long begin, Long end, Group group, User user);

}
