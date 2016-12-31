<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录-DessertHouse</title>
		<meta charset="utf-8">
        <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
		<link href="../css/login-register.css" rel='stylesheet' type='text/css' />
		<link href='../images/newlogo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
	 <!-----start-main---->
	 <div class="main">
         <div class="wrap">
         <div class="header_top">
					<div class="logo">
						<a href="index.html"><img src="../images/newlogo.png" alt="" /></a>
					</div>
						<div class="header_top_right">
							  
						 <div class="clear"></div>
					</div>
			 <div class="clear"></div>
  		</div>
        </div>
		<div class="login-form">
			<h1><b>登录</b></h1>
					<div class="head">
						<img src="../images/user.png" alt=""/>
					</div>
				<form action="/MyDessertSystem/login" method="post">
				<%
				if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
				%>
				<p style="color: red;">您的账号或密码有误</p>
				<%
				}
				%>
						<input type="text" class="text" name="account" placeholder="手机号/会员卡号" onfocus="this.value = '';"  >
						<input type="password" name="password" placeholder="密码" onfocus="this.value = '';" >
						<div class="submit">
							<input type="submit" value="登录" >
					    </div>	
					<p><a href="register.jsp">还没有账号？点击免费注册</a></p>
				</form>
			</div>
			<!--//End-login-form-->
		</div>
			 <!-----//end-main---->
</body>
</html>