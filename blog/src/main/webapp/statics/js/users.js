$(document).ready(function () {
    yz();
    cha();
    $(".shou").click(function () {
        pageIndex = 1;
        $(".tj").val("");
        cha();
    })
    $(".shang").click(function () {
        $(".tj").val("");
        pageIndex--;
        if (pageIndex < 1) {
            alert("当前已经是第一页了。不能再往前了");
            pageIndex = 1;
            return;
        } else {
            cha();
        }
    })
    $(".xia").click(function () {
        $(".tj").val("");
        pageIndex++;
        if (pageIndex > lastPage) {
            pageIndex = lastPage;
        }
        cha();
    })
    $(".wei").click(function () {
        $(".tj").val("");
        pageIndex = lastPage;
        cha()
    })
})


var pageIndex = 1;
var pageSize = 2;
var lastPage;


function cha() {
    $(".aaa").remove();
    var json = {
        "pageIndex": pageIndex,
        "pageSize": pageSize
    }
    $.post("/dousers", json, function (data) {
        if (pageIndex > data.pageInfo.pages) {
            alert("超出总页数，跳转到最后一夜")
        }
        lastPage = data.pageInfo.lastPage;
        $(".mei").text("每页" + data.pageInfo.pageSize + "条");
        $(".zong").text("共" + data.pageInfo.total + "条记录");
        $(".ye").text("第" + data.pageInfo.pageNum + "页/共" + data.pageInfo.pages + "页");
        $.each(data.pageInfo.list, function (i, v) {
            var $tr = $("<tr class='aaa' align='center'><td><img src='statics/uploadfiles/" + v.picpath + "'width='50px'; height='50px'><br>" + v.username + "</td><td>" + v.nickname + "</td><td>" + v.address + "</td><td>" + v.mobile + "</td><td><a href='javascript:void(0)' class='delete'>删除</a><input type='hidden' value='" + v.id + "'/></td></tr>");
            $(".table-fenye").append($tr);
        })
    }, "json");
}

function tj() {
    var tj = $(".tj").val();
    if (tj == "") {
        alert("请输入跳转页码！");
        return;
    } else {
        pageIndex = tj;
        cha();
    }
}

function xg(id) {
    window.location = "/toupdate?id=" + id;

}

function yz() {
    var json = {
        "pageIndex": pageIndex,
        "pageSize": pageSize
    }
    $.post("/dousers", json, function (data) {
        if (data.usernum != 1) {
            var $a = $("<a href='javascript:void(0)' onclick='xg(" + data.userid + ")'>修改个人密码</a>");
            $(".zj").append($a);
        }
    }, "json");
}