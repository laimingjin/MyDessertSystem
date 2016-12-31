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
         
        </div>
		<div class="login-form">
			<h1><b>修改店面信息</b></h1>
					
				<form action="/MyDessertSystem/updateShop" method="post">
				<%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
                %>
                        <p style="color: red;">请填写完整信息</p>
                 <%
                }
				%>
			<% 	
			String name=(String)request.getParameter("shop_name");
			String tel=(String)request.getParameter("tel");
			%>
			<label>店名</label><input type="text" class="text" name="shop_name" value=<%=name %> readonly="true" >
						<label>电话</label><input type="text" class="text" name="tel" value=<%=tel %> onfocus="this.value = '';" >
                      
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