<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="top.guitoubing.util.ConstantDefinition" %>
<%@ page import="top.guitoubing.pojo.Data.MessageData" %>
<%@ page import="top.guitoubing.util.TimeUtil" %>
<%@ page import="java.lang.String" %>
<%--
  Created by IntelliJ IDEA.
  User: Tanrui
  Date: 2019/1/9
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="top.guitoubing.controller.IndexController" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>通知</title>
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
    <link href="plugins/datedropper/datedropper.min.css" rel="stylesheet" />
    <link href="plugins/sweetalert2/sweetalert2.min.css" rel="stylesheet" />
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
            <!--maincontent-->
            <div class="mainWrap navslide">
                <div class="ui equal width left aligned padded grid stackable">
                    <!--Site Content-->

                    <div class="row">
                        <div class="ten wide column">
                            <div class="ui segments">
                                <div class="ui segment">
                                    <h5 class="ui header">
                                        新建通知
                                    </h5>
                                </div>
                                <div class=" ui segment fullheight">
                                    <div class="ui form segment form5">
                                            <div class="field">
                                                <label>主题</label>
                                                <input placeholder="Title" id="title" name="first-name" type="text">
                                            </div>
                                            <div class="field">
                                                <label for="content">内容</label>
                                                <textarea id="content" name="maxLength" cols="4"></textarea>
                                            </div>
                                            <div class="field">
                                                <label>有效期至</label>
                                                <div class="six wide column">
                                                    <div class="segment">
                                                        <div class="ui input fluid">
                                                            <input id="time" type="text" class="datedrop" placeholder="Search..." data-large-mode="true"  data-large-default="true" data-modal="true" data-translate-mode="true">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="field">
                                                <label>优先级</label>
                                                <div class="ui dropdown selection" tabindex="0">
                                                    <select id="priority" name="gender">
                                                        <option value="">优先级</option>
                                                                <option value="1" selected="selected">最高</option>
                                                                <option value="2">中等</option>
                                                                <option value="3">最低</option>
                                                    </select><i class="dropdown icon"></i>
                                                    <div class="default text">优先级</div>
                                                    <div class="menu" tabindex="-1">
                                                        <div class="item" data-value="1">最高</div>
                                                        <div class="item" data-value="2">中等</div>
                                                        <div class="item" data-value="3">最低</div>
                                                    </div>
                                                </div>
                                            </div>
                                        <button onclick="createNotice()" class="ui blue submit button">创建通知</button>
                                    </div>

                                    <div id="task-container">

                                        <h3 class="nothing-message">通知列表</h3>

                                        <div class="ui segment">
                                            <div class="ui three column grid stackable">

                                                <c:forEach var="n" items="${notif}">
                                                    <div class="column">
                                                        <div class="ui cards">
                                                            <div class="card">
                                                                <div class="content">
                                                                    <img class="right floated mini ui image" src="${n.getAvator()}">
                                                                    <div class="header">
                                                                        ${n.getTitle()}
                                                                    </div>
                                                                    <div class="meta">
                                                                        commit By ${n.getName()}
                                                                    </div>
                                                                    <div class="description">
                                                                        ${n.getContent()}
                                                                    </div>
                                                                </div>
                                                                <div class="extra content">
                                                                    <div class="ui two buttons">
                                                                        <div class="ui basic green button" onclick="openModal(${n.getId()})">查看详情</div>
                                                                        <c:choose>
                                                                            <c:when test="${n.getLiked() == ConstantDefinition.NOTIFICATION_LIKED}">
                                                                                <div class="ui basic red button" onclick="removeLiked(${n.getId()})">取消收藏</div>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <div class="ui basic blue button" onclick="addLiked(${n.getId()})">收藏通知</div>
                                                                            </c:otherwise>
                                                                        </c:choose>

                                                                    </div>
                                                                </div>

                                                                <%--notice modal--%>
                                                                <div id="modal${n.getId()}" class="ui small modal">
                                                                    <i class="close icon"></i>
                                                                    <div class="header">
                                                                        编辑通知
                                                                    </div>
                                                                    <div class="content">
                                                                        <div class="ui form">
                                                                            <div class="field">
                                                                                <label>标题</label>
                                                                                <input type="text" id="title${n.getId()}" value="${n.getTitle()}"/>
                                                                            </div>
                                                                            <div class="field">
                                                                                <label>内容</label>
                                                                                <input type="text" id="content${n.getId()}" value="${n.getContent()}"/>
                                                                            </div>
                                                                            <div class="field">
                                                                                <label>发布人</label>
                                                                                <input type="text" id="creator${n.getId()}" readonly="readonly" value="${n.getName()}"/>
                                                                            </div>
                                                                            <div class="field">
                                                                                <label>发布日期</label>
                                                                                <input type="text" id="createDate${n.getId()}" readonly="readonly" value="${TimeUtil.stampToDate(String.valueOf(n.getCreatedate()))}"/>
                                                                            </div>
                                                                            <div class="field">
                                                                                <label>到期日期</label>
                                                                                <input type="text" id="endDate${n.getId()}" value="${TimeUtil.stampToDate(String.valueOf(n.getEnddate()))}"/>
                                                                            </div>
                                                                            <div class="field">
                                                                                <label>优先级</label>
                                                                                <div class="ui dropdown selection" tabindex="0">
                                                                                    <select id="priority{$n.getId()}" name="gender">
                                                                                        <option value="">优先级</option>
                                                                                        <option value="1" selected="selected">最高</option>
                                                                                        <option value="2">中等</option>
                                                                                        <option value="3">最低</option>
                                                                                    </select><i class="dropdown icon"></i>
                                                                                    <div class="default text">优先级</div>
                                                                                    <div class="menu" tabindex="-1">
                                                                                        <div class="item" data-value="1">最高</div>
                                                                                        <div class="item" data-value="2">中等</div>
                                                                                        <div class="item" data-value="3">最低</div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="actions">
                                                                        <div class="ui black deny button">
                                                                            取消
                                                                        </div>
                                                                        <div class="ui positive right labeled icon button" onclick="editNotif(${n.getId()})">
                                                                            提交修改
                                                                            <i class="checkmark icon"></i>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <%--end--%>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Site Content-->
                </div>
            </div>
            <!--maincontent-->
        </div>
    </div>


</div>
<!--jquery-->
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script>
    function editNotif(nid) {
        var title = document.getElementById('title' + nid).value;
        var content = document.getElementById('content' + nid).value;
        var endDate = document.getElementById('endDate' + nid).value;
        alert(endDate);
        var priority = document.getElementById('priority' + nid).options[document.getElementById('priority' + nid).selectedIndex].value;
        var ok = true;
        if (title.length <= 0 ){
            swal({
                title : "Error",
                text : "标题不能为空！",
                type : "warning",
                cancelButtonText : "No"
            });
            ok = false;
        }else if (title.length >= 10){
            swal({
                title : "Error",
                text : "标题长度超出限制",
                type : "warning",
                cancelButtonText : "No"
            });
            ok = false;
        }
        if (content.length <= 10 || content.length >= 80){
            swal({
                title : "Error",
                text : "内容长度需要在10-80个字之间！",
                type : "warning",
                cancelButtonText : "No"
            });
            ok = false;
        }
        var pattern = '/((((0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)/(0[1-9]|[12][0-9]|30))|((02)/(0[1-9]|[1][0-9]|2[0-8])))/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(02/29/(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))/';
        if (endDate.match(pattern) == null){
            alert("格式不正确");
        }else {
            alert("正确");
        }
    }
    function removeLiked(nid) {
        $.ajax({
            type: 'post',
            url: 'removeLiked',
            data:{
                nid: nid
            },
            success: function (data) {
                if (data == '1'){
                    swal({
                        title: "Success",
                        text: "取消收藏成功！"
                    });
                    var url = 'window.location.href = \'notice\'';
                    setTimeout(url ,2000);
                }else if(data == '4'){
                    window.location.href = 'login.jsp';
                }else{
                    window.location.href = 'index';
                }
            }
        });
    }
    function addLiked(nid) {
        $.ajax({
            type: 'post',
            url: 'addLiked',
            data:{
                nid: nid
            },
            success: function (data) {
                if (data == '1'){
                    swal({
                        title: "Success",
                        text: "收藏成功！"
                    });
                    var url = 'window.location.href = \'notice\'';
                    setTimeout(url ,2000);
                }else if(data == '4'){
                    window.location.href = 'login.jsp';
                }else{
                    window.location.href = 'index';
                }
            }
        });
    }
    function createNotice() {
        var title = document.getElementById("title").value;
        var content = document.getElementById("content").value;
        var time = document.getElementById("time").value;
        var priority = document.getElementById('priority').options[document.getElementById('priority').selectedIndex].value;
        // alert(title+content+time+priority);
        var ok = true;
        if (title.length <= 0 ){
            swal({
                title : "Error",
                text : "标题不能为空！",
                type : "warning",
                cancelButtonText : "No"
            });
            ok = false;
        }else if (title.length >= 10){
            swal({
                title : "Error",
                text : "标题长度超出限制",
                type : "warning",
                cancelButtonText : "No"
            });
            ok = false;
        }
        if (content.length <= 10 || content.length >= 80){
            swal({
                title : "Error",
                text : "内容长度需要在10-80个字之间！",
                type : "warning",
                cancelButtonText : "No"
            });
            ok = false;
        }
        // alert(ok);
        if (ok){
            $.ajax({
                type: 'post',
                url: '/createNotice',
                data:{
                    title: title,
                    content: content,
                    time: time,
                    priority: priority
                },
                success: function (data) {
                    if (data == '1'){
                        swal({
                            title : "Success",
                            text : "通知发布成功！"
                        });
                        var url = 'window.location.href = \'notice\'';
                        setTimeout(url ,2000);
                    }else if (data == '2'){
                        swal({
                            title : "Failed",
                            text : "截止日期不可晚于发布日期！"
                        });
                    }else if (data == '3'){
                        window.location.href = 'index';
                    }else{
                        window.location.href = 'login.jsp';
                    }
                }
            });
        }
    }
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
<!--semantic-->
<script src="semantic/dist/semantic.min.js"></script>
<!--semantic-->
<script src="plugins/cookie/js.cookie.js"></script>
<script src="plugins/lobibox/dist/js/lobibox.min.js"></script>


<script src="plugins/nicescrool/jquery.nicescroll.min.js"></script>
<script src="js/customjs/custom-todo.js"></script>
<script data-pace-options='{ "ajax": false }' src="plugins/pacejs/pace.js"></script>

<script src="js/main.js"></script>
<script src="plugins/datedropper/datedropper.min.js"></script>

<script>
    $(document).ready(function () {

        $('.datedrop').dateDropper();

    });
</script>

<script>
    function openModal(nid) {
        var modal = '#modal' + nid;
        // alert(modal);
        $(modal).modal('show');
    }
</script>
<script src="plugins/sweetalert2/sweetalert2.min.js"></script>
</body>
</html>
