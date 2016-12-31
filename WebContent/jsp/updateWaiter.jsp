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
			<h1><b>修改服务员信息</b></h1>
					<div class="head">
						<img src="../images/user.png" alt=""/>
					</div>
				<form action="/MyDessertSystem/updatewaiter" method="post">
				<%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
                %>
                        <p style="color: red;">请填写完整信息</p>
                 <%
                }
				%>
			<% 	
			String account=(String)request.getParameter("waiter_account");
			String name=(String)request.getParameter("name");
			String password=(String)request.getParameter("password");
			String level=(String)request.getParameter("level");
			String shop=(String)request.getParameter("shop");
			%>
			<label>账号</label><input type="text" class="text" name="account" value=<%=account %> readonly="true" >
						<label>姓名</label><input type="text" class="text" name="name" value=<%=name %> onfocus="this.value = '';" >
                        <label>密码</label> <input type="text" class="text" name="password" value=<%=password %> onfocus="this.value = '';" >
	                    <label>总店服务员／分店服务员</label>
	                    	<span class="standard_select"><!--边框-->
		                     <span class="select_shelter"><!--遮挡默认边框-->
		                       <select type="select" name="Item" id="type">
		                        	<option value="总店服务员" selected="selected">总店服务员</option>
		                         	<option value="分店服务员">分店服务员</option>
		
		                       </select>
		                    </span>
	                       </span>
		                 <label>店面</label><input type="text" class="text" name="shop" value=<%=shop %> onfocus="this.value = '';" >
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