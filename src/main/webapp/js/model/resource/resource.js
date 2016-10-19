$().ready(function () {
    $("#resourceForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 5,
            }
        },
        messages:{
            name: {
                required: "用户名必填"
            }
        }

    });

    //2.修改的时候取消不保存
    $("#cancelBtn").click(function(){
        window.history.back();//获取浏览器缓存对象
        //location.href="employee.action";//很多人同时管理数据使用此方法，每次获取实时数据
    });

    //3.实现重置的功能,新建和修改
    $("#resetBtn").click(function(){
        $("input[name!='id'][name!='baseQuery.currentPage'][name!='baseQuery.pageSize']").val("");
        $("select").val(-1);
    });
})