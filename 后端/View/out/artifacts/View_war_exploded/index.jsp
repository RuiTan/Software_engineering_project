<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="top.guitoubing.util.ConstantDefinition" %>
<%@ page import="top.guitoubing.pojo.Data.MessageData" %>
<%--
  Created by IntelliJ IDEA.
  User: Tanrui
  Date: 2019/1/9
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="top.guitoubing.controller.IndexController" %>

<html lang="en">

<head>
    <title>个人主页</title>
    <link rel="icon" href="img/favicon.ico" />
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name=viewport content="width=device-width, initial-scale=1" />
    <link href="semantic/dist/semantic.min.css" rel="stylesheet" />
    <link href="plugins/ionicons/css/ionicons.min.css" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />
    <link href="plugins/datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet" />
    <link href="plugins/weather-icons/css/weather-icons-wind.min.css" rel="stylesheet" />
    <link href="plugins/weather-icons/css/weather-icons.min.css" rel="stylesheet" />
    <link href="plugins/chartist/chartist.min.css" rel="stylesheet" />
    <link href="css/chat-page.css" rel="stylesheet" />
    <link rel="shortcut icon" href="img/favicon.ico" />

</head>

<body>
    <div id="contextWrap">
        <!--sidebar-->
        <div class="ui sidebar vertical left menu overlay  borderless visible sidemenu inverted  grey" style="-webkit-transition-duration: 0.1s; transition-duration: 0.1s;" data-color="grey">
            <a class="item logo" href="/index">
                <img src="img/logo.png" alt="stagblogo" /><img src="img/thumblogo.png" alt="stagblogo" class="displaynone" />
            </a>
            <div class="ui accordion inverted">

                <a class="title item">
                    <i class="ion-speedometer titleIcon icon"></i> 个人 <i class="dropdown icon"></i>
                </a>
                <div class="content">
                    <a class="item" href="/logout">
                    登出
                </a>
                </div>

                <div class="title item">
                    <i class="ion-ios-lightbulb titleIcon icon"></i>

                    <i class="dropdown icon"></i> 群组
                </div>
                <div class="content">
                    <a class="item" href="/search?key=">
                    搜索群组
                </a>
                </div>
            

            </div>

            <div class="ui dropdown item displaynone scrolling">
                <span>个人</span>
                <i class="ion-speedometer icon"></i>

                <div class="menu">
                    <div class="header">
                        个人
                    </div>
                    <div class="ui divider"></div>
                    <a class="item" href="/logout">
                    登出
                </a>
                </div>
            </div>


            <div class="ui dropdown item displaynone scrolling">
                <span>群组</span>
                <i class="ion-ios-lightbulb icon"></i>
                <div class="menu">
                    <div class="header">
                        群组
                    </div>
                    <div class="ui divider"></div>
                    <a class="item" href="/search?key=">
                    搜索群组
                </a>
                </div>
            </div>
            <div class="ui divider"></div>
        </div>
        </a>
        <!--sidebar-->
        <div class="pusher pushable">
            <div class="ui right sidebar">
                <div class="ui pointing secondary two item tabular menu">
                    <a class="item active" data-tab="first"><i class="red icon ion-chatbox-working icon"></i></a>
                </div>
                <div class="ui tab active" data-tab="first">
                    <div class="ui small feed">
                        <h4 class="ui header">群组邀请</h4>
                        <div class="ui divider"></div>
                        <!-- 消息元素开始 -->
                        <c:forEach var="m" items="${data.invites}">
                            <div class="event">
                                <div class="content">
                                    <div class="summary">
                                        群组:&nbsp;<a href="/group?id=${m.id}">${m.name}</a>
                                    </div>
                                    <div class="summary">
                                        邀请你加入他们的行列
                                    </div>
                                    <button class="ui green small button" onclick="agree(${m.id})">同意加入</button>
                                </div>
                            </div>
                            <div class="ui divider"></div>
                        </c:forEach>
                        <!-- 消息元素停止 -->
                    </div>
                    <div class="ui small feed">
                        <h4 class="ui header">群组请求</h4>
                        <div class="ui divider"></div>
                        <!-- 消息元素开始 -->
                        <c:forEach var="m" items="${data.applys}">
                            <div class="event">
                                <div class="content">
                                    <div class="summary">
                                        用户:&nbsp;${m.uname}
                                    </div>
                                    <div class="summary">
                                        申请加入群组:&nbsp;<a href="/group?id=${m.gid}">${m.gname}</a>
                                    </div>
                                    <button class="ui green small button" onclick="allow(${m.uid}, ${m.gid})">同意申请</button>
                                </div>
                            </div>
                            <div class="ui divider"></div>
                        </c:forEach>
                        <!-- 消息元素停止 -->
                    </div>
                </div>
            </div>
            <div class="pusher">
                <!--navbar-->
                <div class="navslide navwrap">
                    <div class="ui menu icon borderless grid" data-color="inverted white">
                        <a class="item labeled openbtn">
                            <i class="ion-navicon-round big icon"></i>
                        </a>
                        <a class="item labeled expandit" onclick="toggleFullScreen(document.body)">
                            <i class="ion-arrow-expand big icon"></i>
                        </a>
                        <div class="right menu colhidden">
                            <!-- 群组开始 -->
                            <div class="ui dropdown item labeled icon">
                                <i class="bell icon"> &nbsp;我的群组</i>
                                <div class="ui red label mini circular">${data.groups.size()}</div>
                                <div class="menu">
                                    <div class="header">
                                        我创建的群组
                                    </div>
                                    <c:forEach var="g" items="${data.groups}">
                                        <c:choose>
                                            <c:when test="${g.creator == data.user.id}">
                                                <div class="item">
                                                    <a href="/group?id=${g.id}">${g.name}</a>
                                                </div>
                                            </c:when>
                                        </c:choose>

                                    </c:forEach>

                                    <div class="header">
                                        我加入的群组
                                    </div>

                                    <c:forEach var="g" items="${data.groups}">
                                        <c:choose>
                                            <c:when test="${g.creator != data.user.id}">
                                                <div class="item">
                                                    <a href="/group?id=${g.id}">${g.name}</a>
                                                </div>
                                            </c:when>
                                        </c:choose>

                                    </c:forEach>
                                </div>
                            </div>
                            <!-- 群组结束 -->

                            <!-- 资料开始 -->
                            <div class="ui dropdown item">
                                <img class="ui mini circular image" src="${data.user.avator}" alt="label-image" />
                                <div class="menu">
                                    <div class="ui divider"></div>
                                    <a class="item" href="/logout">登出</a>
                                </div>
                            </div>
                            <a class="item labeled rightsidebar computer only">
                                <i class="ion-wrench large icon"></i>
                            </a>
                            <!-- 资料结束 -->

                        </div>
                    </div>
                </div>
                <!--navbar-->
                <!--maincontent-->
                <div class="mainWrap navslide profilepage">
                    <div class="ui equal width left aligned padded grid stackable">
                        <!--Site Content-->
                        <!--Site Content-->

                        <div class="sixteen wide tablet sixteen wide computer column profileheader row no-padding">
                            <div class="column  left floated">
                                <div class="ui items">
                                    <div class="item">
                                        <a class="ui small circular image">
                                            <img src="${data.user.avator}" alt="label-image" />
                                            <i class="circle mini red icon avt" data-content="Offline" data-variation="inverted redli"></i>
                                        </a>
                                        <div class="middle aligned content hiddenui">
                                            <div class="header">
                                                <i class="like icon"></i>
                                                ${data.user.name}
                                            </div>
                                            <div class="meta">
                                                ${data.user.gender}, <i class="icon map marker"></i> ${data.user.intro}
                                            </div>
                                            <a class="ui teal tag label">${data.user.statusDesc}</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="column hiddenui">
                                <div class="description right aligned">
                                    <button class="ui circular facebook icon button">
                                        <i class="facebook icon"></i>
                                    </button>
                                    <button class="ui circular twitter icon button">
                                        <i class="twitter icon"></i>
                                    </button>
                                    <button class="ui circular linkedin icon button">
                                        <i class="linkedin icon"></i>
                                    </button>
                                    <button class="ui circular google plus icon button">
                                        <i class="google plus icon"></i>
                                    </button>
                                    <button class="ui circular instagram icon button">
                                        <i class="instagram icon"></i>
                                    </button>
                                    <div class="ui divider"></div>
                                    <button class="ui green button modalfour">修改资料</button>
                                    <button class="ui blue button modalfive">创建群组</button>
                                </div>
                            </div>
                        </div>
                        <div class="ui menu fluid no-radius borderless stackable" style="margin-top:0">
                            <a class="item active red">消息时间线</a>
                            <div class="right menu">
                                <a class="item">
                                    <div class="ui mini statistic">
                                        <div class="value">
                                            ${data.getTaskCount()}
                                        </div>
                                        <div class="label">
                                            任务
                                        </div>
                                    </div>
                                </a>
                                <a class="item">
                                    <div class="ui mini statistic">
                                        <div class="value">
                                            ${data.getNoticeCount()}
                                        </div>
                                        <div class="label">
                                            通知
                                        </div>
                                    </div>
                                </a>
                                <a class="item">
                                    <div class="ui mini statistic">
                                        <div class="value">
                                            ${data.getSVCount()}
                                        </div>
                                        <div class="label">
                                            监督
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <form method="post" action="/profile">
                            <div class="ui small test modal">
                                <div class="header">
                                    修改资料
                                </div>
                                <div class="content">
                                    <div class="ui form">
                                        <div class="field">
                                            <label>用户名</label>
                                            <input type="text" id="name" value="${data.user.name}"/>
                                        </div>
                                        <div class="field">
                                            <label>手机号</label>
                                            <input type="text" id="phone" readonly="readonly" value="${data.user.phone}"/>
                                        </div>
                                        <div class="field">
                                            <label>个人介绍</label>
                                            <input type="text" id="intro" value="${data.user.intro}"/>
                                        </div>
                                        <div class="field">
                                            <label>性别</label>
                                            <div class="ui dropdown selection" tabindex="0">
                                                <select id="gender" name="gender">
                                                    <option value="">性别</option>
                                                    <c:choose>
                                                        <c:when test="${data.user.gender == \"男\"}">
                                                            <option value="男" selected="selected">男</option>
                                                            <option value="女">女</option>
                                                            <option value="未知">未知</option>
                                                        </c:when>
                                                        <c:when test="${data.user.gender == \"女\"}">
                                                            <option value="男">男</option>
                                                            <option value="女" selected="selected">女</option>
                                                            <option value="未知">未知</option>
                                                        </c:when>
                                                        <c:when test="${data.user.gender == \"未知\"}">
                                                            <option value="男">男</option>
                                                            <option value="女">女</option>
                                                            <option value="未知" selected="selected">未知</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="男">男</option>
                                                            <option value="女">女</option>
                                                            <option value="未知">未知</option>
                                                        </c:otherwise>

                                                    </c:choose>
                                                </select><i class="dropdown icon"></i>
                                                <div class="default text">性别</div>
                                                <div class="menu" tabindex="-1">
                                                    <div class="item" data-value="男">男</div>
                                                    <div class="item" data-value="女">女</div>
                                                    <div class="item" data-value="未知">未知</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="field">
                                            <label>状态</label>
                                            <div class="ui dropdown selection" tabindex="0">
                                                <select id="status" name="status">
                                                    <option value="">状态</option>
                                                    <c:choose>
                                                        <c:when test="${data.user.status == 1}">
                                                            <option value="1" selected="selected">我在线上</option>
                                                            <option value="2">请勿打扰</option>
                                                            <option value="3">隐身</option>
                                                        </c:when>
                                                        <c:when test="${data.user.status == 2}">
                                                            <option value="1">我在线上</option>
                                                            <option value="2" selected="selected">请勿打扰</option>
                                                            <option value="3">隐身</option>
                                                        </c:when>
                                                        <c:when test="${data.user.status == 3}">
                                                            <option value="1">我在线上</option>
                                                            <option value="2">请勿打扰</option>
                                                            <option value="3" selected="selected">隐身</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="1">我在线上</option>
                                                            <option value="2">请勿打扰</option>
                                                            <option value="3">隐身</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </select><i class="dropdown icon"></i>
                                                <div class="default text">状态</div>
                                                <div class="menu" tabindex="-1">
                                                    <div class="item" data-value="1">我在线上</div>
                                                    <div class="item" data-value="2">请勿打扰</div>
                                                    <div class="item" data-value="3">隐身</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="field">
                                            <label>自定义状态</label>
                                            <input type="text" id="statusDesc" value="${data.user.statusDesc}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="actions">
                                    <button class="ui negative button">
                                        放弃修改
                                    </button>
                                    <button type="submit" onclick="editProfile()" class="ui positive right labeled icon button">
                                        保存修改
                                        <i class="checkmark icon"></i>
                                    </button>
                                </div>

                            </div>
                        </form>
                        <form method="post" action="/createGroup">
                            <div class="ui large test modal">
                                <div class="header">
                                    创建群组
                                </div>
                                <div class="content">
                                    <div class="ui form">
                                        <div class="field">
                                            <label>群组名</label>
                                            <input type="text" id="gname" />
                                        </div>
                                        <div class="field">
                                            <label>群组介绍</label>
                                            <input type="text" id="gintro" />
                                        </div>
                                        <div class="field">
                                            <label>群组标签</label>
                                            <input type="text" id="gtag" placeholder="多个标签以空格分隔哦……"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="actions">
                                    <button class="ui negative button">
                                        取消
                                    </button>
                                    <button type="submit" onclick="createGroup()" class="ui positive right labeled icon button">
                                        创建
                                        <i class="checkmark icon"></i>
                                    </button>
                                </div>

                            </div>
                        </form>
                        <script>
                            function allow(uid, gid) {
                                alert(uid + ',' + gid);
                                $.ajax({
                                    type: 'post',
                                    url: '/allow',
                                    data: {
                                        uid: uid,
                                        gid: gid
                                    },
                                    success: function (data) {
                                        if (data){
                                            window.location.href = "/index";
                                        }else {
                                            window.location.href = "/login.jsp";
                                        }
                                    }
                                });
                            }
                            function agree(id) {
                                // alert(id);
                                $.ajax({
                                    type: 'post',
                                    url: '/agree',
                                    data: {
                                        gid: id
                                    },
                                    success: function (data) {
                                        if (data){
                                            window.location.href = "/index";
                                        }else {
                                            window.location.href = "/login.jsp";
                                        }
                                    }
                                });
                            }
                            function createGroup() {
                                var gname = document.getElementById('gname').value;
                                var gintro = document.getElementById('gintro').value;
                                var gtag = document.getElementById('gtag').value;
                                // alert(gname + gintro + gtag);
                                $.ajax({
                                    type: 'post',
                                    url: '/createGroup',
                                    data:{
                                        gname: gname,
                                        gintro: gintro,
                                        gtag: gtag
                                    },
                                    success: function (data) {
                                        if (data){
                                            window.location.href = "/index";
                                        }else {
                                            window.location.href = "/login.jsp";
                                        }
                                    }
                                });
                            }
                            function editProfile() {
                                var name = document.getElementById('name').value;
                                var intro = document.getElementById('intro').value;
                                var statusDesc = document.getElementById('statusDesc').value;
                                var gender = document.getElementById('gender').options[document.getElementById('gender').selectedIndex].value;
                                var status = document.getElementById('status').options[document.getElementById('status').selectedIndex].value;
                                // alert(name + gender + status + intro + statusDesc);
                                $.ajax({
                                    type: 'post',
                                    url: '/editProfile',
                                    data:{
                                        name: name,
                                        intro: intro,
                                        statusDesc: statusDesc,
                                        gender: gender,
                                        status: status
                                    },
                                    success: function (data) {
                                        // alert(data);
                                        if (data){
                                            window.location.href = "/index";
                                        }else {
                                            window.location.href = "/login.jsp";
                                        }
                                    }
                                });
                            }
                        </script>
                        <div class="row">
                            <div class="sixteen wide tablet eight wide computer column">
                                <div class="ui segment">
                                    <div class="ui feed timeline">
                                        <c:forEach var="g" items="${data.messageData}">
                                            <div class="event">
                                                <div class="label">
                                                    <img src="${g.avator}" alt="label-image" />
                                                </div>
                                                <div class="content">
                                                    <div class="summary">
                                                        <a class="user" href="/group?id=${g.id}">
                                                                ${g.groupName}
                                                        </a>
                                                        <c:choose>
                                                            <c:when test="${g.type == ConstantDefinition.TASK_MES}">
                                                                ${ConstantDefinition.TASK_MES_CONTENT}
                                                            </c:when>
                                                            <c:when test="${g.type == ConstantDefinition.NOTICE_MES}">
                                                                ${ConstantDefinition.NOTICE_MES_CONTENT}
                                                            </c:when>
                                                            <c:when test="${g.type == ConstantDefinition.SV_MES}">
                                                                ${ConstantDefinition.SV_MES_CONTENT}
                                                            </c:when>
                                                        </c:choose>
                                                        <div class="date">
                                                                ${g.date}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                            <div class="sixteen wide tablet four wide computer column">
                                <div class="ui segments">
                                    <div class="ui segment">
                                        <h3 class="ui header">我创建的群组</h3>
                                    </div>
                                    <div class="ui segment">
                                        <div class="ui items">

                                            <c:forEach var="g" items="${data.groups}">
                                                <c:choose>
                                                    <c:when test="${g.creator == data.user.id}">
                                                        <div class="item">
                                                            <div class="ui tiny rounded image">
                                                                <img src="${g.avator}" alt="label-image" />
                                                                <i class="circle mini green icon avt" data-content="Online" data-variation="inverted greenli"></i>
                                                            </div>
                                                            <div class="content">
                                                                <a class="header" href="">${g.name}</a>
                                                                <div class="meta">
                                                                    <span class="cinema">${g.intro}</span>
                                                                </div>
                                                                <div class="description">
                                                                    <p></p>
                                                                </div>
                                                                <div class="extra">
                                                                    <a class="ui greenli inverted tiny button follow" href="/group?id=${g.id}">进入</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="sixteen wide tablet four wide computer column">
                                <div class="ui segments">
                                    <div class="ui segment">
                                        <h3 class="ui header">我加入的群组</h3>
                                    </div>
                                    <div class="ui segment">
                                        <div class="ui items">

                                            <c:forEach var="g" items="${data.groups}">
                                                <c:choose>
                                                    <c:when test="${g.creator != data.user.id}">
                                                        <div class="item">
                                                            <div class="ui tiny rounded image">
                                                                <img src="${g.avator}" alt="label-image" />
                                                                <i class="circle mini green icon avt" data-content="Online" data-variation="inverted greenli"></i>
                                                            </div>
                                                            <div class="content">
                                                                <a class="header" href="">${g.name}</a>
                                                                <div class="meta">
                                                                    <span class="cinema">${g.intro}</span>
                                                                </div>
                                                                <div class="description">
                                                                    <p></p>
                                                                </div>
                                                                <div class="extra">
                                                                    <a class="ui greenli inverted tiny button follow" href="/group?id=${g.id}">进入</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--maincontent-->
            </div>
        </div>

    </div>
    <!--jquery-->
    <script src="js/jquery-2.1.4.min.js"></script>
    <!--jquery-->
    <!--semantic-->
    <script src="semantic/dist/semantic.min.js"></script>
    <!--semantic-->
    <!--counter number-->
    <script src="plugins/counterup/jquery.counterup.min.js"></script>
    <script src="plugins/counterup/waypoints.min.js"></script>
    <!--counter number-->
    <!--flot chart-->
    <script src="plugins/flot/jquery.flot.js"></script>
    <script src="plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="plugins/flot/curvedLines.js"></script>
    <script src="plugins/cookie/js.cookie.js"></script>
    <!--flot chart-->
    <!--chartjs chart-->
    <script src="plugins/chartjs/chart.min.js"></script>
    <!--chartjs chart-->

    <script src="plugins/nicescrool/jquery.nicescroll.min.js"></script>

    <script data-pace-options='{ "ajax": false }' src="plugins/pacejs/pace.js"></script>

    <script src="plugins/chartist/chartist.min.js"></script>
    <script src="js/customjs/custom-modal.js"></script>
    <script src="js/dashboard2.js"></script>
    <script src="js/main.js"></script>
</body>

</html>
