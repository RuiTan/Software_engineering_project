package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.GroupTagMapper;
import top.guitoubing.mapper.TagMapper;
import top.guitoubing.mapper.UserInGroupMapper;
import top.guitoubing.mapper.UserMapper;
import top.guitoubing.pojo.*;
import top.guitoubing.pojo.Data.GroupSearchData;
import top.guitoubing.pojo.Data.NotificationData;
import top.guitoubing.service.GroupService;
import top.guitoubing.util.ConstantDefinition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    GroupTagMapper groupTagMapper;

    @Autowired
    UserInGroupMapper userInGroupMapper;

    @Override
    public void CreateGroup(User user, String gname, String gintro, String gtag) {
        int groupid = userMapper.getMaxGroupId()+1;
        Long time = new Date().getTime()/1000;
        Group group = new Group(groupid, gname, user.getId(), time, ConstantDefinition.GROUP_DEFAULT_AVATOR, gintro);
        userMapper.insertGroup(group);
        String[] tags = gtag.split(" ");
        ArrayList<Integer> tagId = new ArrayList<>();
        for (String tag : tags){
            if (!tag.equals("") && !tag.equals(" ")){
                int id = tagMapper.maxId()+1;
                tagMapper.insert(new Tag(id, tag));
                tagId.add(id);
            }
        }
        for (Integer id : tagId){
            groupTagMapper.insert(new GroupTagKey(groupid, id));
        }
        userInGroupMapper.insert(new UserInGroup(user.getId(), groupid, ConstantDefinition.DEFAULT_USER_STATUS, ConstantDefinition.DEFAULT_USER_PRIORITY));
    }

    @Override
    public boolean UpdateUserStatus(Integer uid, Integer gid){
        UserInGroup userInGroup = userInGroupMapper.selectByPrimaryKey(new UserInGroupKey(uid, gid));
        if (userInGroup == null){
            return false;
        }else {
            userInGroup.setStauts(ConstantDefinition.DEFAULT_USER_STATUS);
            userInGroupMapper.updateByPrimaryKey(userInGroup);
            return true;
        }
    }

    @Override
    public boolean ApplyForJoinGroup(User user, Integer gid) {
        UserInGroup userInGroup = userInGroupMapper.selectByPrimaryKey(new UserInGroupKey(user.getId(), gid));
        if (userInGroup != null){
            return false;
        }else {
            userInGroup = new UserInGroup(user.getId(), gid, ConstantDefinition.USER_STATUS_WAIT_FOR_ALLOW, ConstantDefinition.OTHER_USER_PRIORITY);
            userInGroupMapper.insert(userInGroup);
            return true;
        }
    }

    @Override
    public List<GroupSearchData> GetGroupByKey(String key, User user) {
        String[] keys = key.split(" ");
        ArrayList<GroupSearchData> groups = new ArrayList<>();
        for (String k : keys){
            if (!k.equals("")&&!k.equals(" ")){
                groups.addAll(userMapper.selectGroupByKey("%"+k+"%"));
            }
        }

        ArrayList<GroupSearchData> groupsUserIn = new ArrayList<>(userMapper.selectGroupByUserIn(user.getId()));

        for (GroupSearchData g : groups){
            for (GroupSearchData temp : groupsUserIn){
                if (g.getId().equals(temp.getId())){
                    g.setStatus(2);
                }
            }
        }

        return groups;
    }

    @Override
    public List<GroupSearchData> GetGroups(User user) {
        ArrayList<GroupSearchData> groups = new ArrayList<>(userMapper.getGroups());
        ArrayList<GroupSearchData> groupsUserIn = new ArrayList<>(userMapper.selectGroupByUserIn(user.getId()));
        for (GroupSearchData g : groups){
            for (GroupSearchData temp : groupsUserIn){
                if (g.getId().equals(temp.getId())){
                    g.setStatus(2);
                }
            }
        }
        return groups;
    }

    @Override
    public Group getGroup(Integer id) {
        return userMapper.getGroup(id);
    }

    @Override
    public List<NotificationData> getNotifByGroup(Integer id) {
        return userMapper.selectNotifByGroup(id);
    }

    @Override
    public List<NotificationData> getNotifByLiked(Integer id) {
        return userMapper.selectNotifByLiked(id);
    }

    @Override
    public List<NotificationData> getNotification(Integer uid, Integer gid) {
        List<NotificationData> nd1 = userMapper.selectNotifByGroup(gid);
        List<NotificationData> nd2 = userMapper.selectNotifByLiked(uid);
        for (NotificationData n1 : nd1){
            for (NotificationData n2 : nd2){
                if (n1.getId().equals(n2.getId())){
                    n1.setLiked(ConstantDefinition.NOTIFICATION_LIKED);
                }
            }
        }
        return nd1;
    }


}
