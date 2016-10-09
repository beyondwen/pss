<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
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
                <s:select list="{5,10,20}" name="baseQuery.pageSize" onchange="document.forms[0].submit()"/>
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
