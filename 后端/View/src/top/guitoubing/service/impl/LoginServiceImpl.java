package top.guitoubing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.guitoubing.mapper.UserMapper;
import top.guitoubing.pojo.User;
import top.guitoubing.service.LoginService;
import top.guitoubing.util.ConstantDefinition;
import top.guitoubing.util.MD5Validate;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int login(String tel, String pwd) {
        User user = userMapper.selectByTel(tel);
        if (user == null){
            return ConstantDefinition.WRONG_USER;
        }
        String db_pwd = user.getPassword();
        boolean check = MD5Validate.validateMd5(pwd, db_pwd);
        if (check){
            return ConstantDefinition.LOGIN_SUCCESS;
        }else {
            return ConstantDefinition.WRONG_PWD;
        }
    }

    @Override
    public int register(String tel, String pwd) {
        User user = userMapper.selectByTel(tel);
        if (user != null){
            return ConstantDefinition.USER_EXISTS;
        }
        user = new User();
        user.setId(userMapper.getMaxId()+1);
        user.setPhone(tel);
        user.setPassword(MD5Validate.getMd5(pwd));
        userMapper.insert(user);
        return ConstantDefinition.REGISTER_SUCCESS;
    }

    @Override
    public User getUser(String tel) {
        return userMapper.selectByTel(tel);
    }
}
