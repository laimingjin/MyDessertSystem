<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>首页-DessertHouse</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/newlogo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../js/move-top.js"></script>
<script type="text/javascript" src="../js/easing.js"></script>
<script type="text/javascript" src="../js/jquery.nivo.slider.js"></script>
<script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
</head>
<body>
	<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="">首页</a></li>
						<li><a href="/MyDessertSystem/list">产品预定</a></li>
						<li><a href="/MyDessertSystem/returnList">产品退订</a></li>
						<!--  <li><a href="http://www.wandafilm.com/jingxuan/main.jsp">电影谈资</a></li>-->
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
  	  		<div class="wrap">
				<div class="header_top">
					<div class="logo">
						<a href="index.jsp"><img src="../images/newlogo.png" alt="" /></a>
					</div>
						<div class="header_top_right">
							  <div class="search_box">
					     		<form>
					     			<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
					     		</form>
					     	</div>
						 <div class="clear"></div>
					</div>
			 <div class="clear"></div>
  		</div>     
				<div class="header_bottom">		 
						 	    <!------ Slider ------------>
								  <div class="slider">
							      	<div class="slider-wrapper theme-default">
							            <div id="slider" class="nivoSlider">
							                <img src="../images/111.jpg" data-thumb="images/111.jpg" alt="" />
							                <img src="../images/222.jpg" data-thumb="images/222.jpg" alt="" />
							                <img src="../images/333.jpg" data-thumb="images/333.jpg" alt="" />
							                <img src="../images/444.jpg" data-thumb="images/444.jpg" alt="" />
							            </div>
							        </div>
						   		</div>
						<!------End Slider ------------>
			     <div class="clear"></div>
			</div>
   		</div>
   </div>
   <!------------End Header ------------>
  <div class="main">
  	<div class="wrap">
      <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>New Products</h3>
    		</div>
    	</div>
	      <div class="section group">
	      
				<div class="grid_1_of_5 images_1_of_5">
					 <a href="preview.jsp"><img src="../images/11.jpg" alt="" /></a>
					 <h2><a href="preview.jsp">Mango Jerry</a></h2>
					 <h2><a href="preview.jsp">芒果慕斯</a></h2>
				</div>
				<div class="grid_1_of_5 images_1_of_5">
					 <a href="preview.jsp"><img src="../images/22.jpg" alt="" /></a>
					 <h2><a href="preview.jsp">Cappuccino</a></h2>
					 <h2><a href="preview.jsp">卡布奇诺</a></h2>
				</div>
				<div class="grid_1_of_5 images_1_of_5">
					 <a href="preview.jsp"><img src="../images/33.jpg" alt="" /></a>
					 <h2><a href="preview.jsp">Crumble</a></h2>
					 <h2><a href="preview.jsp">克鲁兹</a></h2>
				</div>
				<div class="grid_1_of_5 images_1_of_5">
					 <a href="preview.jsp"><img src="../images/44.jpg" alt="" /></a>
					 <h2><a href="preview.jsp">Fruit Pocket</a></h2>
					 <h2><a href="preview.jsp">花格</a></h2>
				</div>
				<div class="grid_1_of_5 images_1_of_5">
					 <a href="preview.jsp"><img src="../images/55.jpg" alt="" /></a>
					 <h2><a href="preview.jsp">Strawberry Fool</a></h2>
					 <h2><a href="preview.jsp">卡百利</a></h2>
				</div>
				
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
						<li><a href="admin.html" target="_blank">员工登录</a></li>
						<li><a href="admin.html" target="_blank">经理登录</a></li>
						<li><a href="admin.html" target="_blank">系统管理员登录</a></li>
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

