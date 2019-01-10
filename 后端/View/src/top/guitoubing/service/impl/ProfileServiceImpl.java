package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.MessageMapper;
import top.guitoubing.mapper.UserMapper;
import top.guitoubing.pojo.Data.MessageData;
import top.guitoubing.pojo.Data.ProfileData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.User;
import top.guitoubing.service.ProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    MessageMapper messageMapper;

    @Override
    public ProfileData getProfileData(User user) {
         ProfileData profileData = new ProfileData();
         profileData.setUser(user);
         List<Group> groups = userMapper.selectByUser(user.getId());
         profileData.setGroups(groups);
         profileData.setInvites(userMapper.selectInviteByUser(user.getId()));
         profileData.setApplys(userMapper.getApply(user.getId()));
         List<MessageData> messageDataList = userMapper.getMessage(user.getId());
         profileData.setmessageData(messageDataList);
         profileData.setTaskCount(userMapper.countTask(user.getId()));
         profileData.setNoticeCount(userMapper.countNotice(user.getId()));
         profileData.setSVCount(userMapper.countSV(user.getId()));
         return profileData;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }


}
