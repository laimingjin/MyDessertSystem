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
						<li><a href="#">产品预定</a></li>
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
    <%
       double totalPrice_original =(double) request.getServletContext().getAttribute("totalPrice_original");
       double totalPrice_after =(double) request.getServletContext().getAttribute("totalPrice_after");
       int account =(int) request.getServletContext().getAttribute("account");
       String planIDs =(String) request.getServletContext().getAttribute("planIDs");
       String productIDs =(String) request.getServletContext().getAttribute("productIDs");
       String productNames =(String) request.getServletContext().getAttribute("productNames");
       String quantities =(String) request.getServletContext().getAttribute("quantities");
       String prices =(String) request.getServletContext().getAttribute("prices");
      
    %>
    <form action="/MyDessertSystem/paybycard?account=<%=account %>&planIDs=<%=planIDs %>&productIDs=<%=productIDs %>&productNames=<%= productNames%>&quantities=<%=quantities %>&prices=<%= prices%>&totalPrice_after=<%=totalPrice_after%>" method="post">
    
      <label>原价：</label><input type="text" class="text" name=totalPrice_original value=<%=totalPrice_original %> readonly="true" >
     <label>折价：</label><input type="text" class="text" name=totalPrice_after value=<%=totalPrice_after %> readonly="true" >
 
    
    
    <div class="container-fluid">
	        <div class="row-fluid">
		        <div class="span12">
			       <button class="btn btn-warning" type="submit">确认购买</button>
		        </div>
	        </div>
          </div>
    </form>
	</div>
        
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

