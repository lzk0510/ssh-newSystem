<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
  
<body>
    <h3>修改新闻：</h3>
    <s:form action="updatedNews" namespace="/lbl" theme="simple">
    	<s:hidden name="news.id" value="%{news.id}"/>
    	<s:hidden name="news.issueTime" value="%{news.issueTime}"/>
    	<%-- <s:hidden name="cateName" value="%{news.category.categoryName}"/> --%>
    	<table border="1" cellspacing="0" width="100%">
    		<tr>
    			<td width="20%">标题</td>
    			<td width="80%"><s:textfield name="news.title" label="标题"/></td>
    		</tr>
    		<tr>
    			<td width="20%">类型</td>
    			<td width="80%">
    				<s:select name="cid" headerKey="-1" headerValue="--请选择类型--" list="categories" listKey="id" listValue="categoryName" value="cid"/>
    			</td>
    		</tr>
    		<tr>
    			<td width="20%">内容</td>
    			<td width="80%"><s:textarea name="news.content" rows="10" cols="60"/></td>
    		</tr>
    		<tr>
    			<td width="20%">来源</td>
    			<td width="80%"><s:textfield name="news.source" label="标题"/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><s:submit value="更新"/></td>
    		</tr>
    	</table>
    </s:form>
</body>
</html>
