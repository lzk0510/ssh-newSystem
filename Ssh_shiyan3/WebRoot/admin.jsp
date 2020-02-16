<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${pageContext.request.contextPath}/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- /. WRAPPER  -->
        
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	 
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="${pageContext.request.contextPath}/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/morris/morris.js"></script>
	
	
	<script src="${pageContext.request.contextPath}/assets/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/easypiechart-data.js"></script>
	
	
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/assets/js/custom-scripts.js"></script>
    
</head>
<script>
  	function setCategoryList() {
		$.post(
			"${pageContext.request.contextPath}/admin/user_setCategoryList.action",
			{},
			function(data) {
		
		});
	}
</script>
<script type="text/javascript">
	var message = "${requestScope.message}";
	if (message != "") {
		alert(message);
	}
</script>
<body>
<%
if(session.getAttribute("admin")==null){
response.setHeader("refresh", "0;url=/SSH-keshe/login.jsp");
}
%>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <%--  <a class="navbar-brand" href="index.html"><i class="fa fa-comments"></i> <strong>SISE前线 </strong></a> --%>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
           
                        管理员<%=session.getAttribute("admin") %> <i class="fa fa-caret-down"></i>
                        
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="quit.action" id="quit"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i>类型管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="typePut.action"  target="aaa">类型发布</a>
                            </li>
                            <li>
                                <a href="showCategory.action" target="aaa">类型查看</a>
                            </li>
                        </ul>
                        
                    </li>
                    
                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> 新闻管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="showNewsCateName.action" onClick="setCategoryList()" target="aaa">新闻发布</a>
                            </li>
                             <li>
                            <a href="showNews.action"  target="aaa">新闻查看</a>
                            </li>
                        </ul>
                        
                    </li>
         
                </ul>

            </div>

        </nav>                
        <div id="page-wrapper">
        	     
            <div id="page-inner">
		
              <div >
            <iframe  name="aaa"  style="width:100%;height:100%;border:0 ;"></iframe>
              </div>
        </div>
    </div>

   
</body>

</html>