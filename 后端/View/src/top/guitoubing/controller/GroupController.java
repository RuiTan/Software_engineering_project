package top.guitoubing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.guitoubing.pojo.Data.GroupDemandData;
import top.guitoubing.pojo.Data.ProfileData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.User;
import top.guitoubing.service.*;
import top.guitoubing.util.CheckUser;
import top.guitoubing.util.ConstantDefinition;
import top.guitoubing.util.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RequestMapping("")
@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    ProfileService profileService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    TaskService taskService;

    @Autowired
    SupervisionService supervisionService;

    @Autowired
    GroupDemandService groupDemandService;

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
        modelAndView.addObject("users", groupService.getGroupUsers(group.getId()));
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

    @RequestMapping("editNotif")
    @ResponseBody
    Integer editNotif(Integer nid, String title, String content, String endDate, Integer priority, HttpServletRequest request) throws ParseException {
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        Long limit = Long.valueOf(TimeUtil.dateToStamp(endDate + " 00:00:00"));
        Long now = new Date().getTime()/1000;
        if (limit <= now){
            return ConstantDefinition.CREATE_NOTICE_WRONG_DATE;
        }else {
            notificationService.updateNotification(nid, title, content, limit);
            return ConstantDefinition.CREATE_NOTICE_SUCCEED;
        }
    }

    @RequestMapping("task")
    ModelAndView task(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return new ModelAndView("redirect:/index");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("task");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        modelAndView.addObject("group",group);
        modelAndView.addObject("task", taskService.getTasks(group, user));
        return modelAndView;
    }

    @RequestMapping("createTask")
    @ResponseBody
    Integer createTask(String title, String content, Integer time, Integer members, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        Long now = new Date().getTime()/1000;
        Long limit = now+time*60;
        taskService.createTask(title, content, now, limit, members, group, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("refuseTask")
    @ResponseBody
    Integer refuseTask(Integer tid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        taskService.refuseTask(tid, group, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("applyTask")
    @ResponseBody
    Integer applyTask(Integer tid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        taskService.acceptTask(tid, group, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("achiveTask")
    @ResponseBody
    Integer achiveTask(Integer tid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        taskService.achiveTask(tid, group, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("cancelTask")
    @ResponseBody
    Integer cancelTask(Integer tid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        taskService.cancelTask(tid, group, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("changeStatus")
    @ResponseBody
    Integer changeStatus(String status, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        user.setStatusDesc(status);
        profileService.updateUser(user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("supervision")
    ModelAndView supervision(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return new ModelAndView("redirect:/index");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("supervision");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        modelAndView.addObject("group",group);
        modelAndView.addObject("supervision", supervisionService.getSupervisionData(group.getId(), user));
        return modelAndView;
    }

    @RequestMapping("cancelSV")
    @ResponseBody
    Integer cancelSV(Integer sid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        supervisionService.cancelSupervision(sid);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("supervise")
    @ResponseBody
    Integer supervise(Integer sid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        supervisionService.supervise(sid, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("supervised")
    @ResponseBody
    Integer supervised(Integer sid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        supervisionService.supervised(sid, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("createSV")
    @ResponseBody
    Integer createSV(String title, String content, String punish, Integer time, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        Long now = new Date().getTime()/1000;
        Long limit = now+time*60;
        supervisionService.createSupervision(title, content, punish, now, limit, group, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

    @RequestMapping("groupBill")
    ModelAndView groupBill(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return new ModelAndView("redirect:/index");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("groupBill");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        modelAndView.addObject("group",group);
        List<GroupDemandData> groupDemandData = groupDemandService.getGroupDemandData(group.getId());
        modelAndView.addObject("demand", groupDemandData);
        Integer price = 0, count = 0;
        for (GroupDemandData g : groupDemandData){
            price += g.getPrice();
            count += g.getItemCount();
        }
        modelAndView.addObject("price", price);
        modelAndView.addObject("count", count);
        return modelAndView;
    }

    @RequestMapping("groupDemand")
    ModelAndView groupDemand(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return new ModelAndView("redirect:/login.jsp");
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return new ModelAndView("redirect:/index");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("groupDemand");
        ProfileData profileData = profileService.getProfileData(user);
        modelAndView.addObject("data",profileData);
        modelAndView.addObject("group",group);
        return modelAndView;
    }

    @RequestMapping("createDemand")
    @ResponseBody
    Integer createDemand(String data, String title, String content, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(ConstantDefinition.USERSESSION);
        if (!CheckUser.checkUser(user)){
            return ConstantDefinition.CREATE_NOTICE_WRONG_USER;
        }
        Group group = (Group) request.getSession().getAttribute(ConstantDefinition.GROUP_SESSION);
        if (group == null ){
            return ConstantDefinition.CREATE_NOTICE_WRONG_GROUP;
        }
        groupDemandService.createDemand(data, title, content, group, user);
        return ConstantDefinition.CREATE_NOTICE_SUCCEED;
    }

}
