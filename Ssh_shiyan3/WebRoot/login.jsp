<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
</head>
<script  type="text/javascript"   src="${pageContext.request.contextPath}/js/jquery-1.10.2.js" ></script>
<script type="text/javascript">
      function checkForm() {
         //判断两次密码输入是相同
    var username=""; 
    var password1="";
    var password2="";
    name=$('#name').val();
    password=$('#password').val();
    if(name==""){
    alert("用户名不能为空");
    return false;
    }
    if(password==""){
    alert("密码不能为空");
    return false;
    }
    if(name!="1740129327"){
    alert("账号输入不正确");
    	return false;
    } 
    if(password!="520123"){
    alert("密码输入不正确");
    	return false;
    } 
      }
    </script>
<body>
<div class="container">
<div class="login">
    <div class="login_title">登陆账号</div>
    <div class="login_body">
               <s:form name="form"  method="post" action="login" namespace="/lbl" onsubmit="return checkForm();">
                    
                       
                                <div class="item1">
                               <input type="text" name="name"  class="inputstyle" id="name"
                                   placeholder="管理员账号" /> 
                                  
                              </div>

                        
                              <div class="item1">
                             <input type="password" name="password"  class="inputstyle" id="password"
                                   placeholder="密码" />
                                   
                              </div>

                           <div class="item1">
                              <input type="submit" id="submit"  value="登录" name="submit" />
                            </div>
               </s:form>
                              
          </div>
     </div>
 <div class="container">
</body>
</html>