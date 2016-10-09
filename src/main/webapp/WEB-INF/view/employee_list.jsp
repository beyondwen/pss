<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <link href="css/index.css" rel="stylesheet" type="text/css"/>
    <title>成都蓝源进销存系统(教学版)-员工列表页</title>
</head>
<body>
<s:form action="employee">
    <div class="content-right">
        <div class="content-r-pic">
            <div style="margin:8px auto auto 12px;"><img src="images/ping.gif" width="138" height="17"/></div>
        </div>
        <div class="content-text">
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
                    <td width="149"><select name="" size="1" class="kuan">&nbsp;</select></td>
                    <td width="85"><input type="image" src="/images/can_b_01.gif"/></td>
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
                            <td></td>
                            <td><img src="images/icon_3.gif"/>
                                <span style="line-height:12px; text-align:center;">
	       <a class="xiu" href="employee_input.action?employee.id=${id}">修改</a>
	       </span> <img src="/images/icon_04.gif"/> <span style="line-height:12px; text-align:center;">
	       <a class="xiu" href="employee_delete.action?employee.id=${id}">删除</a></span></td>
                        </tr>
                    </s:iterator>
                </table>
            </div><!--"square-order"end-->
        </div><!--"content-text"end-->
        <div class="content-bbg">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td></td>
                    <td>共${pageResult.totalCount}条记录</td>
                    <td>当前第<span style="color:red;">${pageResult.currentPage}</span>/${pageResult.totalPage}
                    </td>
                    <td>每页${pageResult.pageSize}条记录</td>
                    <s:if test="pageResult.currentPage==1">
                        <td>首页</td>
                        <td><a>上一页</a></td>
                    </s:if>
                    <s:else>
                        <td><a href="#" onclick="go(1)">首页</a></td>
                        <td><a class="sye" href="#" onclick="go(${pageResult.currentPage-1})">上一页</a></td>
                    </s:else>
                    <s:if test="pageResult.currentPage==pageResult.totalPage">
                        <td><a>下一页</a></td>
                        <td>末页</td>
                    </s:if>
                    <s:else>
                        <td><a class="sye" href="#" onclick="go(${pageResult.currentPage+1})">下一页</a></td>
                        <td><a href="#" onclick="go(${pageResult.totalPage})">末页</a></td>
                    </s:else>
                    <td>
                        <s:select list="{5,10,20}" name="baseQuery.pageSize"  onchange="document.forms[0].submit()"/>
                        <s:textfield id="pageNo" name="baseQuery.currentPage" value="%{pageResult.currentPage}" size="1"/>
                        <s:submit value="go"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function go(no) {
            document.getElementById("pageNo").value = no;
            document.forms[0].submit();
        }
    </script>
    </body>
    </html>
</s:form>