package top.guitoubing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.guitoubing.pojo.Data.ProfileData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.User;
import top.guitoubing.service.GroupService;
import top.guitoubing.service.ProfileService;
import top.guitoubing.util.CheckUser;
import top.guitoubing.util.ConstantDefinition;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    ProfileService profileService;

    @Autowired
    GroupService groupService;

    @RequestMapping("index")
    ModelAndView index(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        return modelAndView;
    }

//    @RequestMapping("profile")
//    ModelAndView profile(HttpServletRequest request){
//        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
//        if (!CheckUser.checkUser(user)){
//            return new ModelAndView("redirect:/login.jsp");
//        }
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("profile");
//        ProfileData profileData = profileService.getProfileData(user);
//        modelAndView.addObject("data",profileData);
//        return modelAndView;
//    }

    @RequestMapping("agree")
    @ResponseBody
    Boolean agree(Integer gid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return false;
        }
        groupService.UpdateUserStatus(user.getId(), gid);
        return true;
    }

    @RequestMapping("allow")
    @ResponseBody
    Boolean allow(Integer uid, Integer gid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return false;
        }
        groupService.UpdateUserStatus(uid, gid);
        return true;
    }

    @RequestMapping("editProfile")
    @ResponseBody
    Boolean editProfile(String name, String intro, String statusDesc, String gender, short status, HttpServletRequest request) throws IOException {
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return false;
        }
        user.setName(name);
        user.setIntro(intro);
        user.setStatus(status);
        user.setStatusDesc(statusDesc);
        user.setGender(gender);
        profileService.updateUser(user);
        return true;
    }

    @RequestMapping("createGroup")
    @ResponseBody
    Boolean createGroup(String gname, String gintro, String gtag, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return false;
        }
        groupService.CreateGroup(user, gname, gintro, gtag);
        return true;
    }

    @RequestMapping("search")
    ModelAndView search(HttpServletRequest request, @RequestParam String key){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        if (key == null || key.equals("")){
            modelAndView.addObject("search", groupService.GetGroups(user));
        }else {
            modelAndView.addObject("search", groupService.GetGroupByKey(key, user));
        }
        return modelAndView;
    }

    @RequestMapping("apply")
    @ResponseBody
    String apply(Integer gid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return "3";
        }
        boolean status = groupService.ApplyForJoinGroup(user, gid);
        return status ? "1" : "2";
    }
}
