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
		<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="index.jsp">首页</a></li>
						<li><a href="/MyDessertSystem/list">产品预定</a></li>
						<li><a href="/MyDessertSystem/returnList">产品退订</a></li>
					</ul>
				</div>
					<div class="account_desc">
						<ul>
						<%
						    String name = (String)request.getServletContext().getAttribute("account_name");
						    if(name == null){
						%>
							<li><a href="login.jsp" target="_blank">请登录</a></li>
							<li><a href="register.jsp" target="_blank">免费注册</a></li>
						<%
						    }else{
						%>
						  <li><a href="#" target="_blank">欢迎你，<%=name %></a></li>
						    <li><a href="login.jsp" target="_blank">退出登录</a></li>
						<%
						    }
						%>
							<li><a href="/MyDessertSystem/account.action">我的账户</a></li>
						</ul>
					</div>
				<div class="clear"></div>
			</div>
	  	</div>
  	  		
   </div>
   <!------------End Header ------------>
    <div class="main">
 	<div class="wrap">
     <div class="content">
     	<div class="content_top">
    		<div class="back-links">
    		<p><a href="index.jsp">首页</a> &gt;&gt;&gt; <a href="#" class="active">产品预定</a></p>
    	    </div>
    		<div class="clear"></div>
    	</div>
    		

    <div class="component">
		<table>
			<thead>
			 <tr>
			        <th>所有产品计划id</th>
                    <th>所有产品id</th>
					<th>所有产品名称</th>
					<th>所有产品价格</th>
					<th>所有产品数量</th>
					<th>总价钱</th>
                    <th>下单时间</th>
				</tr>
				<!-- -->	
			</thead>
			<%
			  int[] aid = (int[])request.getServletContext().getAttribute("aid");
            int[] member_account = (int[])request.getServletContext().getAttribute("member_account");
			   String[] planIDs = (String[])request.getServletContext().getAttribute("planIDs");
			   String[] productIDs = (String[])request.getServletContext().getAttribute("productIDs");
			   String[] productNames = (String[])request.getServletContext().getAttribute("productNames");
			   String[] prices = (String[])request.getServletContext().getAttribute("prices");
			   String[] quantities = (String[])request.getServletContext().getAttribute("quantities");
			   double[] totalPrice = (double[])request.getServletContext().getAttribute("totalPrice");
			   String[] date = (String[])request.getServletContext().getAttribute("date");
			   int num = (Integer)request.getServletContext().getAttribute("num");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<num;i++){
			%>
				  <tr><td><%=planIDs[i]%></td><td><%=productIDs[i] %></td><td><%=productNames[i] %></td><td ><%=prices[i] %></td><td><%=quantities[i] %></td><td><%=totalPrice[i] %></td><td><%=date[i]%></td><td><a href="/MyDessertSystem/deleteAllsale?aid=<%=aid[i]%>&member_account=<%=member_account[i]%>&totalPrice=<%=totalPrice[i]%>">删除订单</a></td></tr>
			<!--
			<tr><td><a><img src="../images/11.jpg" alt="" /></a></td><td><h2>product_name[i]</h2><h2>branch[i]</h2></td></tr>
			-->
			<%
			   }
			
			%>
			
			
			</tbody>
		</table>
		
	</div>
        
         </div> 
    </div>
 </div>
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

