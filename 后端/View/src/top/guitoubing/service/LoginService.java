package top.guitoubing.service;

import top.guitoubing.pojo.User;

public interface LoginService {

    int login(String tel, String pwd);

    int register(String tel, String pwd);

    User getUser(String tel);
}
