package top.guitoubing.service;

import top.guitoubing.pojo.Data.ProfileData;
import top.guitoubing.pojo.User;

import java.util.List;

public interface ProfileService {

    ProfileData getProfileData(User user);

    void updateUser(User user);

}
