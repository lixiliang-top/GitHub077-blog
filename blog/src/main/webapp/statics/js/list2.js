$(document).ready(function () {
    cha();
    $(".shou").click(function () {
        pageIndex = data.firstPage;
        cha()
    })
    $(".shang").click(function () {
        pageIndex = data.prePage;
        cha()
        if(pageIndex==1){
            alert("当前已经是第一页了。不能再往前了");
            return;
        }
    })
    $(".xia").click(function () {
        pageIndex = data.nextPage;
        cha()
    })
    $(".wei").click(function () {
        pageIndex = data.lastPage;
        cha()
    })
})

var pageSize = 2;
var pageIndex = 1;
var data;
function cha() {
    // $(".table-fenye tr:gt(1)").remove();
    $(".aaa").remove();
    var json = {
        pageSize : pageSize,
        pageIndex : pageIndex
    }
    console.log(json)
    $.post("/doIndex2",json,function (result) {
        console.log(result.data)
        data = result.data;
        $(".ye").text("第"+result.data.pageNum + "页/共" + result.data.pages+"页");
        $(".mei").text("每页"+pageSize+"条");
        $(".zong").text("共"+result.data.total+"条记录");
        $.each(result.data.list, function (i, v) {
            var $tr = $("<tr class='aaa'><td>"+v.id+"</td><td>" + v.content + "</td><td>" + v.publishtime + "</td><td><a href='javascript:void(0)' class='delete'>删除</a><input type='hidden' value='" + v.id + "'/></td></tr>");
            $(".table-fenye").append($tr);
        })
    },"json");
}