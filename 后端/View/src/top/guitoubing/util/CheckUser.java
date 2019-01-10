package top.guitoubing.util;

import top.guitoubing.pojo.User;

public class CheckUser {

    public static boolean checkUser(User user) {
        return user != null && user.getPhone() != null && !user.getPhone().equals("");
    }

}
