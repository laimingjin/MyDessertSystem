<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>统计图表-DessertHouse</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/component.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../js/move-top.js"></script>
<style type="text/css">
.manager-count a{
        cursor:pointer;
        display:inline-block;
        color:#747474;
        margin:20px 20px 20px 5px;
        font-size:14px;
        width:140px;
        height:40px;
        background:#FFFFFF;
        border:1px solid #e5e5e5;
        border-radius:3px;
        text-align:center;
        line-height:20px;
    }
.manager-count a:hover{
        color:#FC7D01;
        border:1px solid #FC7D01;
        background:#fffefb;
    }
</style>
</head>
<body>
		<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						
						<%
						String type = (String)request.getServletContext().getAttribute("accountType");
						
						%>
						<li><a href="/MyDessertSystem/approveplan.action">审批计划</a></li>
						<li><a href="count.jsp">统计</a></li>
						
						
					</ul>
				</div>
				<div class="account_desc">
						<ul>
						<%
						    String name = (String)request.getServletContext().getAttribute("account_name");
						    if(name != null){
						%>
						    <li><a href="#" target="_blank">欢迎你，<%=name %></a></li>
						<%
						    }
						%>
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
    		
    	    </div>
    		<div class="clear"></div>
    	</div>
    		<div class="section group">
                        <div class="manager-count">
                        <label><h3><b>会员信息统计：</b></h3></label>
                        </br>
                        <a href="/MyDessertSystem/man_woman_number">不同年龄段的男女会员数量柱状图</a>
                        <a href="/MyDessertSystem/card_status">不同年龄段的卡有效/暂停/停止柱状图</a>
                        <a href="/MyDessertSystem/man_woman_cost">不同年龄段的男女会员消费柱状图</a>
                        <a href="/MyDessertSystem/man_woman">男女会员数量饼图</a>
                        </br>
                        <label><h3><b>销售状况统计：</b></h3></label>
                        </br>
                        <a href="/MyDessertSystem/book_shop">预订、售出情况（按照店面统计）</a>
                        <a href="/MyDessertSystem/hostSale">热卖产品</a>
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
                        <li><a href="contact.html">联系我们</a></li>
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
</body>
</html>

