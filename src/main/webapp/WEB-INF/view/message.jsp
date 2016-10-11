<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
    <s:actionerror/>
</s:if>
<s:if test="hasFieldErrors()">
    <s:fielderror/>
</s:if>
<s:if test="hasActionMessages()">
    <s:actionmessage/>
</s:if>