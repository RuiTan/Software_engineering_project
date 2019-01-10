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
    <title>群组主页</title>
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
                    <a class="item" href="/group?id=${group.getId()}">
                        群组主页
                    </a>
                </div>
                <div class="title item">
                    <i class="ion-ios-lightbulb titleIcon icon"></i>

                    <i class="dropdown icon"></i> 信息模块
                </div>
                <div class="content">
                    <a class="item" href="/notice">
                        通知
                    </a>
                    <a class="item" href="/task">
                        任务
                    </a>
                    <a class="item" href="/supervision">
                        监督
                    </a>
                </div>
                <div class="title item">
                    <i class="ion-ios-lightbulb titleIcon icon"></i>

                    <i class="dropdown icon"></i> 群组活动
                </div>
                <div class="content">
                    <a class="item" href="/groupDemand">
                        购买需求
                    </a>
                    <a class="item" href="/groupActivity">
                        群组活动
                    </a>
                </div>
                <div class="title item">
                    <i class="ion-ios-lightbulb titleIcon icon"></i>

                    <i class="dropdown icon"></i> 公共模块
                </div>
                <div class="content">
                    <a class="item" href="/groupItem">
                        公共物品
                    </a>
                    <a class="item" href="/groupBill">
                        公共账单
                    </a>
                    <a class="item" href="/groupTask">
                        公共任务
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
                    <a class="item" href="/group?id=${group.getId()}">
                        群组主页
                    </a>
                </div>
            </div>
            <div class="ui dropdown item displaynone scrolling">
                <span>信息模块</span>
                <i class="ion-ios-lightbulb icon"></i>
                <div class="menu">
                    <div class="header">
                        信息模块
                    </div>
                    <div class="ui divider"></div>
                    <a class="item" href="/notice">
                        通知
                    </a>
                    <a class="item" href="/task">
                        任务
                    </a>
                    <a class="item" href="/supervision">
                        监督
                    </a>
                </div>
            </div>
            <div class="ui dropdown item displaynone scrolling">
                <span>群组活动</span>
                <i class="ion-ios-lightbulb icon"></i>
                <div class="menu">
                    <div class="header">
                        群组活动
                    </div>
                    <div class="ui divider"></div>
                    <a class="item" href="/groupDemand">
                        购买需求
                    </a>
                    <a class="item" href="/groupActivity">
                        群组活动
                    </a>
                </div>
            </div>
            <div class="ui dropdown item displaynone scrolling">
                <span>公共模块</span>
                <i class="ion-ios-lightbulb icon"></i>
                <div class="menu">
                    <div class="header">
                        公共模块
                    </div>
                    <div class="ui divider"></div>
                    <a class="item" href="/groupItem">
                        公共物品
                    </a>
                    <a class="item" href="/groupBill">
                        公共账单
                    </a>
                    <a class="item" href="/groupTask">
                        公共任务
                    </a>
                </div>
            </div>
            <div class="ui divider"></div>
        </div>
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
            </div>
        </div>

    </div>
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
