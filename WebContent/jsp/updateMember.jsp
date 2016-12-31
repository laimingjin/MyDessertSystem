<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>-Desserthouse</title>
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
			<h1><b>修改会员信息</b></h1>
					<div class="head">
						<img src="../images/user.png" alt=""/>
					</div>
				<form action="/MyDessertSystem/updatemember.action" method="post">
				<%-- <%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
                %>
                        <p style="color: red;">请填写完整信息</p>
                 <%
                }
				%> --%>
			<% 	
			String account=(String)request.getParameter("account");
			String name=(String)request.getParameter("name");
			String password=(String)request.getParameter("password");
			String age=(String)request.getParameter("age");
			String gender=(String)request.getParameter("gender");
			String address=(String)request.getParameter("address");
			String card=(String)request.getParameter("card");
			
			String tel=(String)request.getParameter("tel");
			String status=(String)request.getParameter("status");
			String credit=(String)request.getParameter("credit");
			String date=(String)request.getParameter("date");
			String money=(String)request.getParameter("money");
			String allcost=(String)request.getParameter("allcost");
			String level=(String)request.getParameter("level");
			%>
			<label>账号</label><input type="text" class="text" name="account" value=<%=account %> readonly="true" >
			<label>手机号</label><input type="text" class="text" name="tel" value=<%=tel %> readonly="true" >
						<label>状态</label><input type="text" class="text" name="status" value=<%=status %> readonly="true" >
						<label>积分</label><input type="text" class="text" name="credit" value=<%=credit %> readonly="true" >
						<label>日期</label><input type="text" class="text" name="date" value=<%=date %> readonly="true" >
						<label>级别</label><input type="text" class="text" name="level" value=<%=level %> readonly="true" >
						<label>账户金额</label><input type="text" class="text" name="money" value=<%=money %> readonly="true" >
						<label>金额</label><input type="text" class="text" name="allcost" value=<%=allcost %> readonly="true" >
						<label>姓名</label><input type="text" class="text" name="name" value=<%=name %> onfocus="this.value = '';" >
                        <label>密码</label> <input type="text" class="text" name="password" value=<%=password %> onfocus="this.value = '';" >
	                    <label>年龄</label><input type="text" class="text" name="age" value=<%=age %> onfocus="this.value = '';" >
	                    <label>性别</label>
	                    	<span class="standard_select"><!--边框-->
		                     <span class="select_shelter"><!--遮挡默认边框-->
		                       <select type="select" name="gender" id="type">
		                      
		                        	<option value="男" selected="selected">男</option>
		                         	<option value="女">女</option>
		                      
		                       </select>
		                    </span>
	                       </span>
	                       <label>居住地</label><input type="text" class="text" name="address" value=<%=address %> onfocus="this.value = '';" >
		                 <label>银行卡</label><input type="text" class="text" name="card" value=<%=card %> onfocus="this.value = '';" >
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