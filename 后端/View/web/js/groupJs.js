var globalid = 1;

function createDemand() {
    var title = document.getElementById('title').value;
    var content = document.getElementById('content').value;
    var ok = true;
    var data = getData();
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
    if (data == null || data == '' || data == ' '){
        swal({
            title : "Error",
            text : "订单项不能为空！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (ok){
        $.ajax({
            type: 'post',
            url: 'createDemand',
            data:{
                data: data,
                title: title,
                content: content
            },
            success: function (data) {
                if (data == '1'){
                    swal(
                        "Success",
                        "需求创建成功！",
                        "success"
                    );
                    var url = 'window.location.href = \'groupDemand\'';
                    setTimeout(url ,2000);
                }else if (data == '3'){
                    window.location.href = 'index';
                }else{
                    window.location.href = 'login.jsp';
                }
            }
        });
    }
}

function getData() {
    var split = '=====';
    var data = '';
    for (var i = 1; i<=globalid; i++){
        var d = document.getElementById('span'+i);
        if (d != null){
            var str = d.innerText;
            // alert(str);
            data = data + str + split;
        }
    }
    // alert(data);
    return data;
}

function createBill() {
    var bills = document.getElementById('bills');
    var text = document.getElementById('billTitle').value;
    var desc = document.getElementById('billDesc').value;
    var link = document.getElementById('billLink').value;
    var price = document.getElementById('billPrice').value;
    var ok = true;
    if (text.length <= 0 || text.length >= 10){
        swal({
            title : "Error",
            text : "标题长度需要在1-10个字之间！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (desc.length <= 10 || desc.length >= 80){
        swal({
            title : "Error",
            text : "描述内容需要在10-80个字之间！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (price <= 0){
        swal({
            title : "Error",
            text : "价格输入不正确！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (ok){
        var trid = 'tr' + globalid;
        var iid = 'i' + globalid;
        var sid = 'span' + globalid;
        globalid++;
        var data = text + '-----' + desc + '-----' + link + '-----' + price;
        var line = '<tr id="'+ trid +'"><td>' + text + '</td><td><code>'+ desc +'</code></td><td>'+ price +'</td><td>' +
            '<i id="'+iid+'" class="big red cancel icon" onclick="removeBill(\''+ iid +'\')"></i>' +
            '<span id="'+ sid +'" style="display: none">'+data+'</span></td></tr>';
        bills.innerHTML += line;
    }
}

function removeBill(iid) {
    var id = iid.substr(1,2);
    var trid = 'tr' + id;
    var bills = document.getElementById('bills');
    var tr = document.getElementById(trid);
    bills.removeChild(tr);
    swal({
        title : "Success",
        text : "删除订单成功！"
    });
}

function createSV() {
    var title = document.getElementById('title').value;
    var content = document.getElementById('content').value;
    var punish = document.getElementById('punish').value;
    var time = document.getElementById('time').value;
    // alert(title+ content + time + members);
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
    if (time <= 10 || time >= 6000){
        swal({
            title : "Error",
            text : "有效时间需在10-6000分钟之间！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (title.length <= 0 ){
        swal({
            title : "Error",
            text : "惩罚不能为空！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }else if (title.length >= 30){
        swal({
            title : "Error",
            text : "惩罚长度超出限制",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (ok){
        $.ajax({
            type: 'post',
            url: 'createSV',
            data: {
                title: title,
                content: content,
                punish: punish,
                time: time
            },
            success: function (data) {
                // alert(data);
                if (data == '1'){
                    swal({
                        title : "Success",
                        text : "监督发布成功！"
                    });
                    var url = 'window.location.href = \'supervision\'';
                    setTimeout(url ,2000);
                }else if (data == '3'){
                    window.location.href = 'index';
                }else{
                    window.location.href = 'login.jsp';
                }
            }
        });
    }
}

function cancelSV(sid) {
    $.ajax({
        type: 'post',
        url: 'cancelSV',
        data: {
            sid: sid
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title: "Success",
                    text: "取消监督成功！"
                });
                var url = 'window.location.href = \'supervision\'';
                setTimeout(url ,2000);
            }else if(data == '4'){
                window.location.href = 'login.jsp';
            }else{
                window.location.href = 'index';
            }
        }
    });
}

function supervise(sid) {
    $.ajax({
        type: 'post',
        url: 'supervise',
        data: {
            sid: sid
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title: "Success",
                    text: "加入监督成功！"
                });
                var url = 'window.location.href = \'supervision\'';
                setTimeout(url ,2000);
            }else if(data == '4'){
                window.location.href = 'login.jsp';
            }else{
                window.location.href = 'index';
            }
        }
    });
}

function supervised(sid) {
    $.ajax({
        type: 'post',
        url: 'supervised',
        data: {
            sid: sid
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title: "Success",
                    text: "加入被监督成功！"
                });
                var url = 'window.location.href = \'supervision\'';
                setTimeout(url ,2000);
            }else if(data == '4'){
                window.location.href = 'login.jsp';
            }else{
                window.location.href = 'index';
            }
        }
    });
}

function changeStatus() {
    var status = document.getElementById('status').value;
    if (status.length <= 1 || status.length >= 20){
        swal({
            title: "Failed",
            text: "状态字长度应在2-20之间！"
        });
    }else {
        $.ajax({
            type: 'post',
            url: 'changeStatus',
            data: {
                status: status
            },
            success: function (data) {
                if (data == '1'){
                    swal({
                        title: "Success",
                        text: "修改状态成功！"
                    });
                    document.getElementById('statusDesc').innerText = status;
                }else if(data == '4'){
                    window.location.href = 'login.jsp';
                }else{
                    window.location.href = 'index';
                }
            }
        });
    }
}

function achiveTask(tid) {
    $.ajax({
        type: 'post',
        url: 'achiveTask',
        data: {
            tid: tid
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title: "Success",
                    text: "任务完成成功！"
                });
                var url = 'window.location.href = \'task\'';
                setTimeout(url ,2000);
            }else if(data == '4'){
                window.location.href = 'login.jsp';
            }else{
                window.location.href = 'index';
            }
        }
    });
}

function cancelTask(tid) {
    $.ajax({
        type: 'post',
        url: 'cancelTask',
        data: {
            tid: tid
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title: "Success",
                    text: "任务取消成功！"
                });
                var url = 'window.location.href = \'task\'';
                setTimeout(url ,2000);
            }else if(data == '4'){
                window.location.href = 'login.jsp';
            }else{
                window.location.href = 'index';
            }
        }
    });
}

function applyTask(tid) {
    $.ajax({
        type: 'post',
        url: 'applyTask',
        data: {
            tid: tid
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title: "Success",
                    text: "任务接受成功！"
                });
                var url = 'window.location.href = \'task\'';
                setTimeout(url ,2000);
            }else if(data == '4'){
                window.location.href = 'login.jsp';
            }else{
                window.location.href = 'index';
            }
        }
    });
}

function refuseTask(tid) {
    $.ajax({
        type: 'post',
        url: 'refuseTask',
        data: {
            tid: tid
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title: "Success",
                    text: "任务拒绝成功！"
                });
                var url = 'window.location.href = \'task\'';
                setTimeout(url ,2000);
            }else if(data == '4'){
                window.location.href = 'login.jsp';
            }else{
                window.location.href = 'index';
            }
        }
    });
}


function createTask() {
    var title = document.getElementById('title').value;
    var content = document.getElementById('content').value;
    var time = document.getElementById('time').value;
    var members = document.getElementById('members').value;
    // alert(title+ content + time + members);
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
    if (time <= 10 || time >= 6000){
        swal({
            title : "Error",
            text : "有效时间需在10-6000分钟之间！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (members < 1){
        swal({
            title : "Error",
            text : "人数必须大于1！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }
    if (ok){
        $.ajax({
            type: 'post',
            url: 'createTask',
            data: {
                title: title,
                content: content,
                time: time,
                members: members
            },
            success: function (data) {
                // alert(data);
                if (data == '1'){
                    swal({
                        title : "Success",
                        text : "任务发布成功！"
                    });
                    var url = 'window.location.href = \'task\'';
                    setTimeout(url ,2000);
                }else if (data == '3'){
                    window.location.href = 'index';
                }else{
                    window.location.href = 'login.jsp';
                }
            }
        });
    }
}

function editNotif(nid) {
    var title = document.getElementById('title' + nid).value;
    // alert(title);
    var content = document.getElementById('content' + nid).value;
    // alert(content);
    var endDate = document.getElementById('endDate' + nid).value;
    // alert(endDate);
    var priority = document.getElementById('priority' + nid).options[document.getElementById('priority' + nid).selectedIndex].value;
    // alert(priority);
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
    var pattern =
        '((((0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)/(0[1-9]|[12][0-9]|30))|((02)/(0[1-9]|[1][0-9]|2[0-8])))/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(02/29/(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))';
    // alert(pattern);
    if (endDate.search(/pattern/i) == null){
        swal({
            title : "Error",
            text : "日期格式不正确！",
            type : "warning",
            cancelButtonText : "No"
        });
        ok = false;
    }else {
        // alert("正确");
    }
    $.ajax({
        type: 'post',
        url: 'editNotif',
        data:{
            nid: nid,
            title: title,
            content: content,
            endDate: endDate,
            priority: priority
        },
        success: function (data) {
            if (data == '1'){
                swal({
                    title : "Success",
                    text : "编辑成功！"
                });
                var url = 'window.location.href = \'notice\'';
                setTimeout(url ,2000);
            }else if(data == '2'){
                swal({
                    title : "Failed",
                    text : "截止日期不能早于开始日期！"
                });
            }
        }
    });
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
    // alert(uid + ',' + gid);
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