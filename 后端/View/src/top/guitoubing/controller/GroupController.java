package top.guitoubing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.guitoubing.pojo.Data.ProfileData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.Notification;
import top.guitoubing.pojo.User;
import top.guitoubing.service.GroupService;
import top.guitoubing.service.NotificationService;
import top.guitoubing.service.ProfileService;
import top.guitoubing.util.CheckUser;
import top.guitoubing.util.ConstantDefinition;
import top.guitoubing.util.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

@RequestMapping("")
@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    ProfileService profileService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping("group")
    ModelAndView group(HttpServletRequest request, @RequestParam Integer id){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        Group group = groupService.getGroup(id);
        request.getSession().setAttribute(ConstantDefinition.GROUP_SESSION, group);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("group");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        modelAndView.addObject("group",group);
        return modelAndView;
    }

    @RequestMapping("notice")
    ModelAndView notice(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return new ModelAndView("redirect:/index");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notice");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        modelAndView.addObject("group",group);
        modelAndView.addObject("notif",groupService.getNotification(user.getId(), group.getId()));
        return modelAndView;
    }

    @RequestMapping("createNotice")
    @ResponseBody
    Integer createNotice(String title, String content, String time, Integer priority, HttpServletRequest request) throws ParseException {
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        Long limit = Long.valueOf(TimeUtil.dateToStamp(time + " 00:00:00"));
        Long now = new Date().getTime()/1000;
        if (limit <= now){
            return ConstantDefinition.CREATE_NOTICE_WRONG_DATE;
        }else {
            notificationService.createNotification(title, content, Short.valueOf(String.valueOf(priority)), now, limit, group, user);
            return ConstantDefinition.CREATE_NOTICE_SUCCEED;
        }
    }

    @RequestMapping("addLiked")
    @ResponseBody
    Integer addLiked(Integer nid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        notificationService.addLiked(nid, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("removeLiked")
    @ResponseBody
    Integer removeLiked(Integer nid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        notificationService.removeLiked(nid, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }
}
