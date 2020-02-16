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
	var message = "${session.news}";
	if (message != "") {
		alert(message);
	}
</script>
<body>
	<%-- 水水水水：<s:property value="#session.news"/> --%>
	<%session.setAttribute("news", null); %>
	<s:form action="showNewsByCate" namespace="/sh" theme="simple">
	<table border="1" cellspacing="0" style="width:780px;height:50px">
		<tr>
			<td>
				<s:select style="height:25px;margin-left:280px" name="cid" headerKey="-1" headerValue="--请选择新闻类型--" list="categories" listKey="id" listValue="categoryName"/>
				<s:submit value="查看新闻"/>
			</td>
		</tr>
	</table><br/>
	<table border="1" cellspacing="0">
		<tr>
			<td width="50px" align="center" style="font-weight:bold">序号</td>
			<td width="250px" align="center" style="font-weight:bold">标题</td>
			<td width="200px" align="center" style="font-weight:bold">发布时间</td>
			<td width="100px" align="center" style="font-weight:bold">类型</td>
			<td width="150px" align="center" style="font-weight:bold">操作</td>
		</tr>
		<s:iterator value="newsList" var="news" status="stu">
		<tr>
			<td align="center"><s:property value="#stu.count"/></td>
			<td align="center"><s:a href="sh/aNewsShow.action?cid=%{#news.id}"><s:property value="#news.title"/></s:a></td>
			<td align="center"><s:date name="#news.issueTime"/></td>
			<td align="center"><s:property value="#news.category.categoryName"/></td>
			<td align="center">
				<s:a href="updateNews.action?cid=%{#news.id}">修改</s:a>
				<s:a href="#" onClick="del(%{#news.id});return false;">删除</s:a>
			</td>
		</tr>			
		</s:iterator>
	</table>
	</s:form>
</body>
<script type="text/javascript" language="javaScript">
function del(id){
	if (confirm("确认要删除？")) {
		window.location.href = "deleteNews.action?cid="+id;
	} 
}
</script>
</html>
