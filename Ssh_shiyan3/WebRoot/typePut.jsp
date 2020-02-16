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
	<h3>发布新闻类型：</h3>
	<s:form action="addCategory" namespace="/lbl">
    	<s:textfield name="categoryName" label="类型名"/>
    	<s:submit value="添加"/>
    </s:form>
</body>
</html>
