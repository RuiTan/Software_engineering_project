
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" name="viewport" />
    <title>登录/注册</title>
    <meta name="description" content="Stagb Admin Template" />
    <meta name="keywords" content="html5, ,semantic,ui, library, framework, javascript,jquery,template,blog,stagb,template" />
    <link href="semantic/dist/semantic.min.css" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />
    <link href="plugins/sweetalert2/sweetalert2.min.css" rel="stylesheet" />
</head>
<body>
    <div class="ui container" style="padding-top:10%">
        <div class="ui grid center aligned">
            <div class="row">
                <div class="sixteen wide tablet six wide computer column">
                    <div class="ui left aligned segment">

                        <div id="form1" class="ui form">

                            <h1 class="ui header center aligned">

                                <div class="content">
                                    Guys
                                </div>
                            </h1>

                            <div class="field">
                                <label>
                                    手机号：
                                </label>
                                <div class="ui fluid icon input">
                                    <input name="tel" id="tel" type="tel" style="width:100%!important;min-width:100%;width:100%;">
                                    <i class="icon phone"></i>
                                </div>
                            </div>
                            <div class="field">
                                <label>
                                    密码：
                                </label>
                                <div class="ui fluid icon input">
                                    <input name="password" id="pwd" type="password" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                    <i class="icon key"></i>
                                </div>
                            </div>
                            <div class="field">
                                <button id="register" onclick="login()" class="ui blue right labeled icon button fluid">
                                    登录
                                    <i class="icon spy"></i>
                                </button>
                                <button id="login" onclick="register()" class="ui teal right labeled icon button fluid">
                                    转到注册
                                    <i class="icon sign in"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        function login(){
            // alert('login');
            var tel = document.getElementById('tel').value;
            var pwd = document.getElementById('pwd').value;
            if(!(/^[1][3,4,5,7,8][0-9]{9}$/.test(tel))){
                swal({
                    title : "Error",
                    text : "手机号码输入错误",
                    type : "warning",
                    cancelButtonText : "No"
                });
            }else if (!(/^(\w){6,20}$/.test(pwd))){
                swal({
                    title : "Error",
                    text : "密码格式错误（只能输入6-20个字母、数字、下划线）",
                    type : "warning",
                    cancelButtonText : "No"
                });
            }else{
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    url: 'login',
                    data: {
                        tel: tel,
                        pwd: pwd
                    },
                    success: function (result){
                        // alert(result);
                        if (result == '1'){
                            // alert(result);
                            swal(
                                'success',
                                '登录成功，即将跳转至主页！'
                            );
                            var url = 'window.location.href = \'index?tel=' + tel + '\'';
                            setTimeout(url ,2000);

                        }else if (result == '2'){
                            swal({
                                title : "Error",
                                text : "密码错误，请重新输入",
                                type : "warning",
                                cancelButtonText : "No"
                            });
                        } else if (result == '3'){
                            swal({
                                title : "Error",
                                text : "手机号码不存在，请重新输入",
                                type : "warning",
                                cancelButtonText : "No"
                            });
                        }
                    }
                });
            }
        }
        function register() {
            window.location.href = 'register.jsp';
        }
    </script>
    <script>
        var colors = ["#F25F5C", "#247BA0", "#8e44ad", "#ED6A5A", "#32936F", "#2c3e50", "#E83F6F", "#32936F", "#2E294E"];
        var rand = Math.floor(Math.random() * colors.length);
        $('body').css("background-color", colors[rand]);
    </script>
    <script src="plugins/sweetalert2/sweetalert2.min.js"></script>
    <script src="plugins/sweetalert2/custom-alert.js"></script>
</body>
</html>
