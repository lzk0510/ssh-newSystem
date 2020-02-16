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
	<h3>更新新闻类型：</h3>
	<s:form action="updatedCategory" namespace="/lbl">
		<s:hidden name="category.id" value="%{category.id}"/>
    	<s:textfield name="category.categoryName" label="类型名"/>
    	<s:submit value="更新"/>
    </s:form>
</body>
</html>
