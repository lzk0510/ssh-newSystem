<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script  type="text/javascript"   src="${pageContext.request.contextPath}/js/jquery-1.10.2.js" ></script>
<script>
  function checkForm() {
		// 校验新闻标题:
		// 获得新闻标题文本框的值:
		var title = $("#title").val();
		if (title == null || title == '') {
			alert("标题不能为空!");
			return false;
		}
       //校验新闻类型
       var category=$("#category").val();
       if(category==-1){
       alert("类型不能为空");
       return false;
       }
       //校验新闻内容
       //获得新闻标题文本框的值
       var content=$("#content").val();
       if(content==null||content==''){
       alert("内容不能为空");
       return false;
       }
       //校验新闻来源
       //获取新闻来源文本框的值
       var source=$("#source").val();
       if(source==null||source==''){
       alert("新闻来源不能为空");
       return false;
       }
	}
</script>
</head>
<body>
    <h3>发布新闻：</h3>
    <s:form action="addNews" namespace="/lbl" theme="simple" onsubmit="return checkForm();">
    	<table border="1" cellspacing="0" width="100%">
    		<tr>
    			<td width="20%">标题</td>
    			<td width="80%"><s:textfield id="title" name="title" label="标题"/></td>
    		</tr>
    		<tr>
    			<td width="20%">类型</td>
    			<td width="80%">
    				<s:select id="category" name="cid" headerKey="-1" headerValue="--请选择类型--" list="categories" listKey="id" listValue="categoryName"/>
    			</td>
    		</tr>
    		<tr>
    			<td width="20%">内容</td>
    			<td width="80%"><s:textarea id="content" name="content" rows="10" cols="90"/></td>
    		</tr>
    		<tr>
    			<td width="20%">来源</td>
    			<td width="80%"><s:textfield id="source" name="source" label="标题"/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><s:submit value="添加"/></td>
    		</tr>
    	</table>
    </s:form>
    
</body>
</html>
