<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="css/index.css" rel="stylesheet" type="text/css"/>
    <script src="/js/validate/jquery.js" type="text/javascript"></script>
    <script src="/js/commons.js" type="text/javascript"></script>
    <title>成都蓝源进销存系统(教学版)-员工列表页</title>
</head>
<body>
<s:form id="domainForm" action="employee">
    <div class="content-right">
        <div class="content-r-pic">
            <div style="margin:8px auto auto 12px;"><img src="images/ping.gif" width="138" height="17"/></div>
        </div>
        <div class="content-text">
            <%@include file="message.jsp" %>
            <div class="square-o-top">
                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                       style="font-size:14px; font-weight:bold; font-family:" 黑体
                ";">
                <tr>
                    <td height="24">&nbsp;</td>
                </tr>
                <tr>
                    <td width="60" height="30">用户名:</td>
                    <td width="133">
                        <s:textfield name="baseQuery.name"/>
                    </td>
                    <td width="49">邮箱:</td>
                    <td width="142">
                        <s:textfield name="baseQuery.email"/>
                    </td>
                    <td width="52">部门:</td>
                    <td width="149">
                        <s:select list="#allDepts" name="baseQuery.deptId" listKey="id" listValue="name"
                                  headerKey="-1" headerValue="--请选择--"/>
                    </td>
                    <td width="85"><img onclick="go(1)" src="/images/can_b_01.gif"/></td>
                    <td width="136"><a href="employee_input.action"><img src="/images/can_b_02.gif" border="0"/></a>
                    </td>
                </tr>
                </table>
            </div><!--"square-o-top"end-->
            <div class="square-order">
                <table width="100%" border="1" cellpadding="0" cellspacing="0">
                    <tr align="center" style="background:url(/images/table_bg.gif) repeat-x;">
                        <td width="13%" height="30">编号</td>
                        <td width="16%">用户名</td>
                        <td width="15%">年龄</td>
                        <td width="14%">邮箱</td>
                        <td width="14%">部门部门</td>
                        <td width="16%">操作</td>
                    </tr>
                    <s:iterator value="pageResult.row">
                        <tr align="center" bgcolor="#FFFFFF">
                            <td height="28">${id}</td>
                            <td>${name}</td>
                            <td>${age}</td>
                            <td>${email}</td>
                            <td>${department_id.name}</td>
                            <td><img src="images/icon_3.gif"/>
                                <span style="line-height:12px; text-align:center;">
	                            <a class="xiu" href="#" onclick="updateDomain('employee_input.action?id=${id}');">修改</a>
	                            </span>
                                <img src="/images/icon_04.gif"/> <span style="line-height:12px; text-align:center;">
	                            <a class="xiu" href="#" onclick="deleteDomain('employee_delete.action','${id}');">删除</a>
                                </span>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div><!--"square-order"end-->
        </div><!--"content-text"end-->
        <%@include file="page.jsp" %>
    </div>
    </body>
    </html>
</s:form>
<script type="text/javascript">
    function updateDomain(url) {
        $("#domainForm").attr("action", url);
        $("#domainForm").submit();
    }
    ;

    function deleteDomain(url, did) {
        $.post(url, {id: did},
                function (data) {
                    if (data.success) {
                        $("#domainForm").submit();
                        //alert(data.msg);
                    } else {
                        alert(data.msg);
                    }
                })
    }
</script>
