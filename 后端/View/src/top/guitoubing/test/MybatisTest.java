package top.guitoubing.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.guitoubing.mapper.*;
import top.guitoubing.pojo.Data.NotificationData;
import top.guitoubing.pojo.Data.ProfileData;
import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.Message;
import top.guitoubing.pojo.User;
import top.guitoubing.pojo.UserInGroup;
import top.guitoubing.service.LoginService;
import top.guitoubing.service.ProfileService;
import top.guitoubing.service.TaskService;
import top.guitoubing.util.TimeUtil;

import java.text.ParseException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    LoginService loginService;


    @Autowired
    MessageMapper messageMapper;

    @Autowired
    ProfileService profileService;

    @Autowired
    UserInGroupMapper userInGroupMapper;

    @Autowired
    TaskService taskService;

    @Autowired
    SupervisionMapper supervisionMapper;

    @Autowired
    GroupDemandMapper groupDemandMapper;

    @Autowired
    DemandItemMapper demandItemMapper;

    @Test
    public void test() throws ParseException {
//        System.out.println(loginService.login("18936361545", "tanrui"));
//        System.out.println(loginService.register("18936361546", "tanrui"));
//        System.out.println(userMapper.selectByUser(1));
//        Object o = userMapper.getMessage(1);
//        System.out.println(userMapper.countTask(1));
//        System.out.println(userMapper.countSV(1));
//        System.out.println(userMapper.countNotice(1));
//        User user = userMapper.selectByTel("18936361545");
//        ProfileData profileData = profileService.getProfileData(user);
//        System.out.println(messageMapper.selectByGroupid(1));
//        System.out.println(userMapper.getApply(1));
//        System.out.println(userMapper.selectGroupByKey("%大%"));
//        System.out.println(userMapper.getGroups());
//        System.out.println(userMapper.selectNotifByGroup(1));
//        List<NotificationData> notificationData = userMapper.selectNotifByGroup(1);
//        List<NotificationData> notificationData2 = userMapper.selectNotifByLiked(1);
//        System.out.println(TimeUtil.stampToDate("1547064249"));
//        System.out.println(TimeUtil.dateToStamp("01/10/2019 00:00:00"));
//        System.out.println("01/10/2019 00:00:00".substring(0, 10));
//        System.out.println(userMapper.selectTaskByCreator(1));
//        System.out.println(userMapper.selectTaskByGroup(1));
//        System.out.println(userMapper.selectTaskByReply(2));
//        System.out.println(userInGroupMapper.countUsers(1));
//        taskService.achiveTask(1, new Group(), new User());
//        System.out.println(supervisionMapper.selectSVByGroup(1));
//        System.out.println(supervisionMapper.selectSVBySupervised(1));
//        System.out.println(supervisionMapper.selectSVBySupervisor(1));
//        System.out.println(supervisionMapper.selectUserBySupervised(1));
//        System.out.println(supervisionMapper.selectUserBySupervisor(1));
        System.out.println(demandItemMapper.selectByDemand(1));
        System.out.println(groupDemandMapper.selectByGroup(1));
    }
//
//    @Test
//    public void testAdd(){
//        for (int i = 0; i < 100; i++){
//            Category category = new Category();
//            category.setName("new Category");
//            categoryMapper.add(category);
//        }
//    }
//
//    @Test
//    public void testTotal(){
//        int total = categoryMapper.total();
//        System.out.println(total);
//    }
//
//    @Test
//    public void testList(){
//        Page p = new Page();
//        p.setStart(2);
//        p.setCount(3);
//        List<Category> cs = categoryMapper.list(p);
//        for (Category c : cs){
//            System.out.println(c.getName());
//        }
//    }

//    @Test
//    public void testStudentAdd(){
//        for (int i = 0; i < 100; i++){
//            Lover lover = new Lover();
//            lover.setId(i);
//            lover.setName("FangFang");
//            loverMapper.insert(lover);
//        }
//    }

//    @Test
//    public void testMD5(){
//        String pwd = "tanrui";
//        System.out.println(MD5Validate.getMd5(pwd));
//        System.out.println(MD5Validate.validateMd5(pwd, MD5Validate.getMd5(pwd)));
//    }
//

}
