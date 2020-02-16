<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
	.title{
	font-size:20px;
	font-weight:bold;
	font-family:宋体;
	text-align:center;
	}
	.source{
	font-size:16px;
	font-family:宋体;
	text-align:center;
	float:center;
	}
	.content{
	font-size:15px;
	font-family:宋体;
	margin-left:10px;
	margin-right:10px;
	}
</style>
</head>
  
<body>
    <div class="title"><s:property value="news.title"/></div><br/>
    <div class="source">
    	来源：<s:property value="news.source"/>&nbsp
    	发布时间：<s:date name="news.issueTime"/>
    </div><br/>
    <hr style="background:black"/>
    <div class="content">&nbsp<s:property value="news.content"/></div>
</body>
</html>
