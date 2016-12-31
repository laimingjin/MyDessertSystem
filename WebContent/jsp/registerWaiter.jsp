<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册-Desserthouse</title>
		<meta charset="utf-8">
        <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="../css/selectstyle.css" rel="stylesheet" type="text/css" media="all"/>
		<link href="../css/login-register.css" rel='stylesheet' type='text/css' />
		<link href='../images/newlogo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
</head>
<body>
	 <!-----start-main---->
	 <div class="main">
         <div class="wrap">
         <div class="header_top">
					<div class="logo">
						<a href="index.jsp"><img src="../images/newlogo.png" alt="" /></a>
					</div>
						<div class="header_top_right">
							  
						 <div class="clear"></div>
					</div>
			 <div class="clear"></div>
  		</div>
        </div>
		<div class="login-form">
			<h1><b>新增服务员（四项必填）</b></h1>
					<div class="head">
						<img src="../images/user.png" alt=""/>
					</div>
				<form action="/MyDessertSystem/registerWaiter" method="post">
				<%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
                %>
                        <p style="color: red;">请正确填写注册信息</p>
                 <%
                }
				%>
                
				
						<input type="text" class="text" name="name" placeholder="姓名" onfocus="this.value = '';" >
                  <!--  <input type="text" class="text" name="level" placeholder="总店服务员／分店服务员" onfocus="this.value = '';" >--> 
						<input type="password" name="password" placeholder="请输入6-16位密码" onfocus="this.value = '';" >
                        <input type="password" name="confirm" placeholder="重复输入6-16位密码" onfocus="this.value = '';" >
						
						<input type="text" class="text" name="shop" placeholder="店面" onfocus="this.value = '';" >
						<span class="standard_select"><!--边框-->
		                     <span class="select_shelter"><!--遮挡默认边框-->
		                       <select type="select" name="Item" id="type">
		                            <option value="请选择总店服务员/分店服务员" selected="selected">请选择总店服务员/分店服务员</option>
		                        	<option value="总店服务员" >总店服务员</option>
		                         	<option value="分店服务员">分店服务员</option>
		
		                       </select>
		                    </span>
	                       </span>
						<div class="submit">
							<input type="submit" value="确定" >
					</div>	
				</form>
			</div>
			<!--//End-login-form-->
		</div>
			 <!-----//end-main---->
</body>
</html>