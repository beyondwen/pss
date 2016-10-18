function go(no) {
    //document.getElementById("pageNo").value = no;
    //document.forms[0].submit();
    $("#pageNo").val(no);
    $("#domainForm").submit();
};
function updateDomain(url) {
    $("#domainForm").attr("action", url);
    $("#domainForm").submit();
};

function deleteDomain(url, did, src) {
    $.post(url, {id: did},
        function (data) {
            if (data.success) {
                if ($("#tablelist tr").size() == 2) {
                    $("#domainForm").submit();
                } else {
                    $(src).closest("tr").remove();
                }
                $("#totalCount").html($("#totalCount").html() - 1);
            } else {
                alert(data.msg);
            }
        })
}
$().ready(function () {
    //1.输入查询页面的时候,只要用户输入非数字,就把非数字退掉
    $("#pageNo").keyup(function () {  //keyup事件处理
        $(this).val($(this).val().replace(/\D|^0/g, ''));
    }).bind("paste", function () {  //CTR+V事件处理
        $(this).val($(this).val().replace(/\D|^0/g, ''));
    }).css("ime-mode", "disabled");  //CSS设置输入法不可用
})

