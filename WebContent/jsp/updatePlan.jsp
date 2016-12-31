<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Desserthouse</title>
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
			<h1><b>修改计划</b></h1>
					
				<form action="/MyDessertSystem/updatePlan" method="post">
				<%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
                %>
                        <p style="color: red;">请填写完整信息</p>
                 <%
                }
				%>
			<% 	
			String pid =(String)request.getParameter("pid");
			String product_name = (String)request.getParameter("product_name");
			String starttime = (String)request.getParameter("starttime");
			String shop = (String)request.getParameter("shop");
			String quantity =(String)request.getParameter("quantity");
			String status =(String)request.getParameter("status");
			String price = (String)request.getParameter("price");
			String planid =(String)request.getParameter("planid");
			String wid=(String)request.getParameter("wid");		
			
			
			%>
			<label>计划id</label><input type="text" class="text" name="planid" value=<%=planid %> readonly="true" >
			<label>产品id</label><input type="text" class="text" name="pid" value=<%=pid %> readonly="true" >
						<label>产品名</label><input type="text" class="text" name="product_name" value=<%=product_name %> onfocus="this.value = '';"readonly="true" >
                        <label>商店</label> <input type="text" class="text" name="shop" value=<%=shop %> onfocus="this.value = '';"readonly="true" >
	                     <label>销售日期</label><input type="text" class="text" name="starttime" value=<%=starttime %> onfocus="this.value = '';" >
		                  <label>数量</label><input type="text" class="text" name="quantity" value=<%=quantity %> onfocus="this.value = '';" >
		                 <label>价格</label><input type="text" class="text" name="price" value=<%=price %> onfocus="this.value = '';" >
		                 <label>服务员账号</label><input type="text" class="text" name="wid" value=<%=wid %> readonly="true" >
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