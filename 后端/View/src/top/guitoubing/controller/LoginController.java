package top.guitoubing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.guitoubing.pojo.User;
import top.guitoubing.service.LoginService;
import top.guitoubing.util.CheckUser;
import top.guitoubing.util.ConstantDefinition;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    @ResponseBody
    String Login(String tel, String pwd, HttpServletRequest request){
        Integer result = loginService.login(tel, pwd);
        if (result == ConstantDefinition.LOGIN_SUCCESS){
            request.getSession().setAttribute(ConstantDefinition.USERSESSION, loginService.getUser(tel));
        }
        return String.valueOf(result);
    }

    @RequestMapping("register")
    @ResponseBody
    String Register(String tel, String pwd){
        return String.valueOf(loginService.register(tel, pwd));
    }

    @RequestMapping("logout")
    ModelAndView Logout(HttpServletRequest request){
        request.getSession().removeAttribute(ConstantDefinition.USERSESSION);
        return new ModelAndView("redirect:/login.jsp");
    }
}
