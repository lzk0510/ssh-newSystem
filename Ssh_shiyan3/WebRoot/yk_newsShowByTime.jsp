<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<script type="text/javascript">
	var message = "${requestScope.message}";
	if (message != "") {
		alert(message);
	}
</script>
<body>
	<%-- 水水水水：<s:property value="#session.news"/> --%>
	<s:form action="yk_showNewsByTime" namespace="/lbl" theme="simple">
	<table border="1" cellspacing="0" style="width:770px;height:50px">
		<tr>
			<td>
				<%-- <s:textfield style="height:25px;margin-left:280px" name="cateName" placeholder="请输入时间"/> --%>
				<s:textfield style="height:25px;margin-left:230px" type="date" name="dTime1"/>——
				<s:textfield  type="date" name="dTime2"/>
				<s:submit value="查看新闻"/>
			</td>
		</tr>
	</table><br/>
	<table border="1" cellspacing="0">
		<tr>
			<td width="50px" align="center" style="font-weight:bold">序号</td>
			<td width="300px" align="center" style="font-weight:bold">标题</td>
			<td width="250px" align="center" style="font-weight:bold">发布时间</td>
			<td width="150px" align="center" style="font-weight:bold">类型</td>
		</tr>
		<s:iterator value="newsList" var="news" status="stu">
		<tr>
			<td align="center"><s:property value="#stu.count"/></td>
			<td align="center"><s:a href="sh/aNewsShow.action?cid=%{#news.id}"><s:property value="#news.title"/></s:a></td>
			<td align="center"><s:date name="#news.issueTime"/></td>
			<td align="center"><s:property value="#news.category.categoryName"/></td>
		</tr>			
		</s:iterator>
	</table>
	</s:form>
</body>
</html>
