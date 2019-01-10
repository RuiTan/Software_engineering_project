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
    <title>任务</title>
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
                        <div class="eight wide column">
                            <div class="ui segments">
                                <div class="ui segment">
                                    <h5 class="ui header">
                                        任务列表
                                    </h5>
                                </div>
                                <div class="ui segment fullheight">
                                    <form class="ui form segment form5">
                                        <div class="field">
                                            <label>主题</label>
                                            <input id="title" placeholder="Title" type="text">
                                        </div>
                                        <div class="field">
                                            <label>内容</label>
                                            <textarea id="content" name="maxLength" cols="4"></textarea>
                                        </div>
                                        <div class="field">
                                            <label>有效时长/分钟</label>
                                            <input id="time" placeholder="Valid Time" type="number">
                                        </div>
                                        <div class="field">
                                            <label>任务人数</label>
                                            <input id="members" placeholder="Members" type="number">
                                        </div>
                                        <div class="ui blue submit button" onclick="createTask()">创建任务</div>
                                    </form>

                                    <div id="task-container">

                                        <h3 class="nothing-message">群组任务</h3>

                                        <div class="ui segment">
                                            <div class="ui two column grid stackable">
                                                <c:forEach var="t" items="${task}">
                                                    <c:choose>
                                                        <c:when test="${t.getCreator() != data.user.id}">

                                                            <div class="column">
                                                                <div class="ui cards">
                                                                    <div class="card">
                                                                        <div class="content">
                                                                            <img class="right floated mini ui image" src="${t.getAvator()}">
                                                                            <div class="header">
                                                                                ${t.getTitle()}
                                                                            </div>
                                                                            <div class="meta">
                                                                                commit By ${t.getCreatorName()}
                                                                            </div>
                                                                            <div class="description">
                                                                                ${t.getContent()}
                                                                            </div>
                                                                        </div>
                                                                        <div class="ui icon message inverted yellowli" style="height: 30px">
                                                                            <div class="header">
                                                                                状态：
                                                                                <c:choose>
                                                                                    <c:when test="${t.getStatus() == ConstantDefinition.TASK_WAITING}">
                                                                                        等待所有人接受……
                                                                                    </c:when>
                                                                                    <c:when test="${t.getStatus() == ConstantDefinition.TASK_UNDERWAY}">
                                                                                        等待确认……
                                                                                    </c:when>
                                                                                    <c:when test="${t.getStatus() == ConstantDefinition.TASK_FINISHED}">
                                                                                        已完成……
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        已失效……
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </div>
                                                                        </div>
                                                                        <c:choose>
                                                                            <c:when test="${t.getStatus() == ConstantDefinition.TASK_WAITING}">
                                                                                <c:choose>
                                                                                    <c:when test="${t.getReplyType() == ConstantDefinition.REPLY_TASK_NONE}">
                                                                                        <div class="ui three buttons">
                                                                                            <div class="ui basic green button" onclick="openModal(${t.getId()})">查看详情</div>
                                                                                            <div class="ui basic blue button" onclick="applyTask(${t.getId()})">接受</div>
                                                                                            <div class="ui basic red button" onclick="refuseTask(${t.getId()})">拒绝</div>
                                                                                        </div>
                                                                                    </c:when>
                                                                                    <c:when test="${t.getReplyType() == ConstantDefinition.REPLY_TASK_ACCEPT}">
                                                                                        <div class="ui three buttons">
                                                                                            <div class="ui basic green button" onclick="openModal(${t.getId()})">查看详情</div>
                                                                                            <div class="ui basic blue button">已接受</div>
                                                                                            <div class="ui basic red button" onclick="refuseTask(${t.getId()})">拒绝</div>
                                                                                        </div>
                                                                                    </c:when>
                                                                                    <c:when test="${t.getReplyType() == ConstantDefinition.REPLY_TASK_REFUSE}">
                                                                                        <div class="ui three buttons">
                                                                                            <div class="ui basic green button" onclick="openModal(${t.getId()})">查看详情</div>
                                                                                            <div class="ui basic blue button" onclick="applyTask(${t.getId()})">接受</div>
                                                                                            <div class="ui basic red button">已拒绝</div>
                                                                                        </div>
                                                                                    </c:when>
                                                                                </c:choose>
                                                                            </c:when>

                                                                            <c:when test="${t.getStatus() == ConstantDefinition.TASK_UNDERWAY}">

                                                                                <div class="ui three buttons">
                                                                                    <div class="ui basic green button" onclick="openModal(${t.getId()})">查看详情</div>
                                                                                    <div class="ui basic blue button">已接受</div>
                                                                                    <div class="ui basic red button" onclick="refuseTask(${t.getId()})">拒绝</div>
                                                                                </div>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <div class="ui one buttons">
                                                                                    <div class="ui basic green button" onclick="openModal(${t.getId()})">查看详情</div>
                                                                                </div>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div id="modal${t.getId()}" class="ui small modal">
                                                                <i class="close icon"></i>
                                                                <div class="header">
                                                                    任务详情
                                                                </div>
                                                                <div class="content">
                                                                    <div class="ui form">
                                                                        <div class="field">
                                                                            <label>标题</label>
                                                                            <input type="text" readonly="readonly" value="${t.getTitle()}"/>
                                                                        </div>
                                                                        <div class="field">
                                                                            <label>内容</label>
                                                                            <input type="text" readonly="readonly" value="${t.getContent()}"/>
                                                                        </div>
                                                                        <div class="field">
                                                                            <label>发布人</label>
                                                                            <input type="text" readonly="readonly" value="${t.getCreatorName()}"/>
                                                                        </div>
                                                                        <div class="field">
                                                                            <label>发布日期</label>
                                                                            <input type="text" readonly="readonly" value="${TimeUtil.stampToDate(String.valueOf(t.getCreatedate()))}"/>
                                                                        </div>
                                                                        <div class="field">
                                                                            <label>到期日期</label>
                                                                            <input type="text" readonly="readonly" value="${TimeUtil.stampToDate(String.valueOf(t.getLimitdate()))}"/>
                                                                        </div>
                                                                        <div class="field">
                                                                            <label>状态</label>
                                                                            <c:choose>
                                                                                <c:when test="${t.getStatus() == ConstantDefinition.TASK_WAITING}">
                                                                                    <input type="text" readonly="readonly" value="等待所有人接受……"/>
                                                                                </c:when>
                                                                                <c:when test="${t.getStatus() == ConstantDefinition.TASK_UNDERWAY}">
                                                                                    <input type="text" readonly="readonly" value="等待确认……"/>
                                                                                </c:when>
                                                                                <c:when test="${t.getStatus() == ConstantDefinition.TASK_FINISHED}">
                                                                                    <input type="text" readonly="readonly" value="已经完成……"/>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <input type="text" readonly="readonly" value="已失效……"/>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="actions">
                                                                    <div class="ui black deny button">
                                                                        取消
                                                                    </div>
                                                                    <div class="ui positive right labeled icon button">
                                                                        确认
                                                                        <i class="checkmark icon"></i>
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
                        <div class="eight wide column">
                            <div class="ui segments">
                                <div class="ui segment">
                                    <h5 class="ui header">
                                        我创建的任务
                                    </h5>
                                </div>
                                <div class="ui segment fullheight">

                                    <div class="ui segment">
                                        <div class="ui two column grid stackable">

                                            <c:forEach var="t" items="${task}">
                                                <c:choose>
                                                    <c:when test="${t.getCreator() == data.user.id}">

                                                        <div class="column">
                                                            <div class="ui cards">
                                                                <div class="card">
                                                                    <div class="content">
                                                                        <img class="right floated mini ui image" src="${t.getAvator()}">
                                                                        <div class="header">
                                                                                ${t.getTitle()}
                                                                        </div>
                                                                        <div class="meta">
                                                                            commit By ${t.getCreatorName()}
                                                                        </div>
                                                                        <div class="description">
                                                                                ${t.getContent()}
                                                                        </div>
                                                                    </div>
                                                                    <div class="ui icon message inverted yellowli" style="height: 30px">
                                                                        <div class="header">
                                                                            状态：
                                                                            <c:choose>
                                                                                <c:when test="${t.getStatus() == ConstantDefinition.TASK_WAITING}">
                                                                                    等待所有人接受……
                                                                                </c:when>
                                                                                <c:when test="${t.getStatus() == ConstantDefinition.TASK_UNDERWAY}">
                                                                                    等待确认……
                                                                                </c:when>
                                                                                <c:when test="${t.getStatus() == ConstantDefinition.TASK_FINISHED}">
                                                                                    已完成……
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    已失效……
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </div>
                                                                    </div>
                                                                    <c:choose>
                                                                        <c:when test="${t.getStatus() == ConstantDefinition.TASK_WAITING}">
                                                                                    <div class="ui two buttons">
                                                                                        <div class="ui basic green button" onclick="openModal2(${t.getId()})">查看详情</div>
                                                                                        <div class="ui basic blue button" onclick="cancelTask(${t.getId()})">取消任务</div>
                                                                                    </div>
                                                                        </c:when>
                                                                        <c:when test="${t.getStatus() == ConstantDefinition.TASK_UNDERWAY}">
                                                                            <div class="ui three buttons">
                                                                                <div class="ui basic green button" onclick="openModal2(${t.getId()})">查看详情</div>
                                                                                <div class="ui basic blue button" onclick="achiveTask(${t.getId()})">完成任务</div>
                                                                                <div class="ui basic red button" onclick="cancelTask(${t.getId()})">取消任务</div>
                                                                            </div>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <div class="ui one buttons">
                                                                                <div class="ui basic green button" onclick="openModal2(${t.getId()})">查看详情</div>
                                                                            </div>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div id="modal2${t.getId()}" class="ui small modal">
                                                            <i class="close icon"></i>
                                                            <div class="header">
                                                                任务详情
                                                            </div>
                                                            <div class="content">
                                                                <div class="ui form">
                                                                    <div class="field">
                                                                        <label>标题</label>
                                                                        <input type="text" readonly="readonly" value="${t.getTitle()}"/>
                                                                    </div>
                                                                    <div class="field">
                                                                        <label>内容</label>
                                                                        <input type="text" readonly="readonly" value="${t.getContent()}"/>
                                                                    </div>
                                                                    <div class="field">
                                                                        <label>发布人</label>
                                                                        <input type="text" readonly="readonly" value="${t.getCreatorName()}"/>
                                                                    </div>
                                                                    <div class="field">
                                                                        <label>发布日期</label>
                                                                        <input type="text" readonly="readonly" value="${TimeUtil.stampToDate(String.valueOf(t.getCreatedate()))}"/>
                                                                    </div>
                                                                    <div class="field">
                                                                        <label>到期日期</label>
                                                                        <input type="text" readonly="readonly" value="${TimeUtil.stampToDate(String.valueOf(t.getLimitdate()))}"/>
                                                                    </div>
                                                                    <div class="field">
                                                                        <label>状态</label>
                                                                        <c:choose>
                                                                            <c:when test="${t.getStatus() == ConstantDefinition.TASK_WAITING}">
                                                                                <input type="text" readonly="readonly" value="等待所有人接受……"/>
                                                                            </c:when>
                                                                            <c:when test="${t.getStatus() == ConstantDefinition.TASK_UNDERWAY}">
                                                                                <input type="text" readonly="readonly" value="等待确认……"/>
                                                                            </c:when>
                                                                            <c:when test="${t.getStatus() == ConstantDefinition.TASK_FINISHED}">
                                                                                <input type="text" readonly="readonly" value="已经完成……"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="text" readonly="readonly" value="已失效……"/>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="actions">
                                                                <div class="ui black deny button">
                                                                    取消
                                                                </div>
                                                                <div class="ui positive right labeled icon button">
                                                                    确认
                                                                    <i class="checkmark icon"></i>
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
<script src="js/groupJs.js"></script>
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
        // alert(nid);
        var modal = '#modal' + nid;
        // alert(modal);
        $(modal).modal('show');
    }
    function openModal2(nid) {
        // alert(nid);
        var modal = '#modal2' + nid;
        // alert(modal);
        $(modal).modal('show');
    }
</script>
<script src="plugins/sweetalert2/sweetalert2.min.js"></script>
</body>
</html>
