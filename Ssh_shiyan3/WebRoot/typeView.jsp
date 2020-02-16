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
	var message = "${session.cate}";
	if (message != "") {
		alert(message);
	}
</script>
<body>
	<%session.setAttribute("cate", null); %>
	<h3>查看新闻类型： </h3>
	<s:form>
		<table border="1" cellspacing="0">
			<tr>
				<td width="100px" align="center" style="font-weight:bold">序号</td>
				<td width="150px" align="center" style="font-weight:bold">类型名</td>
				<td width="150px" align="center" style="font-weight:bold">操作</td>
			</tr>
			<s:iterator value="categories" var="cate" status="stu">
			<tr>
				<td align="center"><s:property value="#stu.count"/></td>
				<td align="center"><s:property value="#cate.categoryName"/></td>
				<td align="center">
					<s:a href="updateCategory.action?cid=%{#cate.id}">修改</s:a>
					<s:a href="#" onClick="del(%{#cate.id });return false;">删除</s:a>
				</td>
			</tr>			
			</s:iterator>
		</table>
	</s:form>
</body>
<script type="text/javascript" language="javaScript">
function del(id){
	if (confirm("确认要删除？将会删除该类型的所有新闻")) {
		window.location.href = "deleteCategory.action?cid="+id;
	} 
}
</script>
</html>
