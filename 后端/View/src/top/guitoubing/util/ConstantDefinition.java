package top.guitoubing.util;

public class ConstantDefinition {

    // 添加到session中的attributeName
    public static final String USERSESSION = "LOGIN_USER";
    public static final String GROUP_SESSION = "CURRENT_GROUP";
    // 登录界面
    public static final String LOGINPAGE = "/login.jsp";

    // 登录返回结果名称
    public static final String LOGIN_RETURN = "LOGIN_RETURN";
    // 登录后端返回结果
    public static final int LOGIN_SUCCESS = 1;
    public static final int WRONG_PWD = 2;
    public static final int WRONG_USER = 3;
    // 登录前端返回结果
    public static final int WRONG_FORMAT_USER = 4;
    public static final int WRONG_FORMAT_PWD = 5;

    // 注册返回结果名称
    public static final String REGISTER_RETURN = "REGISTER_RETURN";
    // 注册前端返回结果
    public static final int REGISTER_SUCCESS = 1;
    public static final int USER_EXISTS = 2;
    // 注册后端返回结果
    public static final int WRONG_FORMAT_USER_R = 3;
    public static final int PWD_INCONFORMITY = 4;
    public static final int WRONG_FORMAT_PWD_R = 5;

    // Message种类
    public static final int NOTICE_MES = 1;
    public static final String NOTICE_MES_CONTENT = "新发布了一条通知";
    public static final int SV_MES = 2;
    public static final String SV_MES_CONTENT = "有一条新的监督";
    public static final int TASK_MES = 3;
    public static final String TASK_MES_CONTENT = "新发布了一项任务";

    // Group
    public static final String GROUP_DEFAULT_AVATOR = "http://getme.guitoubing.top/avator/dolphin_128px.png";
    public static final Short DEFAULT_USER_STATUS = 1;
    public static final Short USER_STATUS_WAIT_FOR_ALLOW = 2;
    public static final Short DEFAULT_USER_PRIORITY = 1;
    public static final Short OTHER_USER_PRIORITY = 2;

    // createNotice返回
    public static final Integer CREATE_NOTICE_SUCCEED = 1;
    public static final Integer CREATE_NOTICE_WRONG_DATE = 2;
    public static final Integer CREATE_NOTICE_WRONG_GROUP = 3;
    public static final Integer CREATE_NOTICE_WRONG_USER = 4;

    // Notification Liked
    public static final Integer NOTIFICATION_LIKED = 1;
    public static final Integer NOTIFICATION_DISLIKED = 2;

    // Task Status
    public static final String TASK_WAITING = "1";
    public static final String TASK_UNDERWAY = "2";
    public static final String TASK_FINISHED = "3";
    public static final String TASK_INVALID = "4";
    // Task Reply
    public static final Integer REPLY_TASK_NONE = 1;
    public static final Integer REPLY_TASK_ACCEPT = 2;
    public static final Integer REPLY_TASK_REFUSE = 3;

    // Supervision Status
    public static final String SV_UNREADY = "1";
    public static final String SV_WAITING = "2";
    public static final String SV_FINISHED = "3";
    public static final String SV_INVALID = "4";
    public static final Integer SV_NOT_IN = 0;
    public static final Integer SUPERVISOR = 2;
    public static final Integer SUPERVISED = 1;

}
