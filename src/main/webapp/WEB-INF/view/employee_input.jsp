<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <link href="css/index.css" rel="stylesheet" type="text/css"/>
    <title>成都蓝源进销存系统(教学版)-员工编辑界面</title>
</head>
<body>
<s:fielderror/>
<s:form action="employee_save">
    <s:hidden name="id"/>
    <div class="content-right">
        <div class="content-r-pic">
            <div style="margin:5px auto auto 12px;"><img src="images/canping.gif" width="138" height="17"/></div>
        </div>
        <div class="content-text">
            <div class="square-order">
                <div style="border:1px solid #cecece;">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tr bgcolor="#FFFFFF">
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tr bgcolor="#FFFFFF">
                            <td width="13%" height="30" align="center">用户名</td>
                            <td width="36%">
                                <s:textfield name="name" size="25"/>
                            </td>
                        </tr>
                        <s:if test="id==null">
                            <tr bgcolor="#FFFFFF">
                                <td height="30" align="center">密码</td>
                                <td>
                                    <s:password name="password" size="25"/>
                                </td>
                            </tr>
                        </s:if>
                        <tr bgcolor="#FFFFFF">
                            <td height="30" align="center">年龄</td>
                            <td><s:textfield name="age" size="25"/></td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                            <td height="30" align="center">Email</td>
                            <td><s:textfield name="email" size="25"/></td>
                        </tr>
                        <tr bgcolor="#FFFFFF">
                            <td height="30" align="center">部门</td>
                            <td>
                                <s:select list="#allDepts" name="department_id.id" listKey="id" listValue="name"/>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="order-botton">
                    <div style="margin:1px auto auto 1px;">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td><input type="image" src="images/order_tuo.gif" border="0"/></td>
                                <td>&nbsp;</td>
                                <td><a href="#"><img src="images/order_tuo.gif" border="0"/></a></td>
                                <td>&nbsp;</td>
                                <td><a href="#"><img src="images/order_tuo.gif" border="0"/></a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div><!--"square-order"end-->
        </div><!--"content-text"end-->
        <div class="content-bbg"><img src="images/content_bbg.jpg"/></div>
    </div>
    <!--"content-right"end-->
</s:form>
</body>
</html>
