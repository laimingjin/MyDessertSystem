<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>DessertHouse</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/checkbox.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/component.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../js/move-top.js"></script>

<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>

</head>
<body>
 <!-- Top -->
			 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="/MyDessertSystem/systemmanage">店员管理</a></li>
						<li><a href="/MyDessertSystem/shopmanage">店面管理</a></li>
					</ul>
				</div>
				
					<div class="account_desc">
						<ul>
						<%
						    String lname = (String)request.getServletContext().getAttribute("account_name");
						    if(lname == null){
						%>
							<li><a href="login.jsp" target="_blank">请登录</a></li>
							<li><a href="register.jsp" target="_blank">免费注册</a></li>
						<%
						    }else{
						%>
						    <li><a href="#" target="_blank">欢迎你，<%=lname %></a></li>
						     <li><a href="login.jsp" target="_blank">退出登录</a></li>
						<%
						    }
						%>
							<li><a href="/MyDessertSystem/systemmanageraccount.action">我的账户</a></li>
						</ul>
					</div>
				<div class="clear"></div>
			</div>
	  	</div>
            <!-- /Top -->
    <div class="main">
 	<div class="wrap">
     <div class="content">
     
    		

    <div class="component">
		<table>
			<thead>
			 <tr>
                    <th>账号</th>
					<th>名称</th>
					<th>密码</th>
					<th>级别</th>
					<th>所属店面</th>
				</tr>
				<!-- -->	
			</thead>
			<%
            String[] account = (String[])request.getServletContext().getAttribute("waiter_account");
			if(account != null){
			   String[] name = (String[])request.getServletContext().getAttribute("name");
			   String[] password = (String[])request.getServletContext().getAttribute("password");
			   String[] level = (String[])request.getServletContext().getAttribute("level");
			   String[] shop=(String[])request.getServletContext().getAttribute("shop");
			   int num = (Integer)request.getServletContext().getAttribute("num");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<num;i++){
				   int index=i;
			%>     
				  <tr><td><%=account[i] %></td><td><%=name[i] %></td><td ><%=password[i] %></td><td><%=level[i] %></td><td><%=shop[i] %></td><td><a href="/MyDessertSystem/deletewaiter.action?waiter_account=<%=account[i]%>">删除</a></td><td><a href="updateWaiter.jsp?waiter_account=<%=account[i]%>&name=<%=name[i]%>&password=<%=password[i]%>&level=<%=level[i]%>&shop=<%=shop[i]%>">修改</a></td></tr>
			<!--
			<tr><td><a><img src="../images/11.jpg" alt="" /></a></td><td><h2>product_name[i]</h2><h2>branch[i]</h2></td></tr>
			-->
			<%
			   }
			}
			%>
			</tbody>
		</table>
	</div>
        
         </div> 
    </div>
 </div>
 
 <!-- <div class="login-form">
 	<form action="/DessertHouse/addwaiter" method="post">
		<div class="submit">
			<input type="submit" value="新增" >
		</div>	
					    
 </form>
 </div>
 
 -->
 
 <form action="registerWaiter.jsp" method="post">
 <div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			 <button class="btn btn-warning" type="submit">新增服务员</button>
		</div>
	</div>
</div>
</form>
   <div class="footer">
   	  <div class="wrap">	
	     <div class="section group">
				<div class="col_1_of_4 span_1_of_4">
                    <h4><b>相关信息</b></h4>
                    <ul>
                        <li><a href="contact.jsp">联系我们</a></li>
						<li><a href="#">帮助中心</a></li>
						</ul>
					</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4><b>后台入口</b></h4>
                    <ul>
						<li><a href="login.jsp" target="_blank">员工登录</a></li>
						<li><a href="login.jsp" target="_blank">经理登录</a></li>
                    </ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4><b>联系方式</b></h4>
                    <ul>
                        <li><span>+91-123-456789</span></li>
                        <li><span>+00-123-000000</span></li>
                    </ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4><b>链接分享</b></h4>
                    <div class="social-icons">
                        <ul>
							 <li><a href="#" target="_blank"><img src="../images/facebook.png" alt="" /></a></li>
							 <li><a href="#" target="_blank"><img src="../images/twitter.png" alt="" /></a></li>
							 <li><a href="#" target="_blank"><img src="../images/skype.png" alt="" /> </a></li>
							 <li><a href="#" target="_blank"><img src="../images/linkedin.png" alt="" /></a></li>
							 <div class="clear"></div>
                        </ul>
                    </div>
				</div>
			</div>
			 <div class="copy_right">
				<p>Copyright &copy; 2015.Company name All rights reserved.</p>
		   </div>			
        </div>
    </div>
    <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

