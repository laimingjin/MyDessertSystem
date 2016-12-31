<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>计划</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/component.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../css/date.css" rel="stylesheet" type="text/css" media="all"/>
  <link href="../css/newselectstyle.css" rel="stylesheet" type="text/css" media="all"/>
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../js/move-top.js"></script>
<style>
.btn{
    text-align:center;
    cursor:pointer;
	padding:10px 10px;
	font-family: 'ambleregular';
	background:#FC7D01;
	color: #FFF;
	text-decoration: none;
	outline: 0;
}
.btn:hover{
	  text-shadow: 0px 0px 1px #000;
	  background:#292929;
}
   
input:focus{border-color:#ccc;color:#333;}
</style>
</head>
<body>
	<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						
						
						<li><a href="/MyDessertSystem/plan.action">产品计划</a></li>
						<li><a href="/MyDessertSystem/allplan.action">历史计划</a></li>
						<li><a href="/MyDessertSystem/allmember.action">查看会员</a></li>
						
					</ul>
				</div>
				<div class="account_desc">
						<ul>
						<%
						    String lname = (String)request.getServletContext().getAttribute("account_name");
						    if(lname != null){
						%>
						    <li><a href="#" target="_blank">欢迎你，<%=lname %></a></li>
						    <li><a href="login.jsp" target="_blank">退出登录</a></li>
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
     	
    	
    	
    <div class="component">
        <form method="post" action="#">
		<table>
			<thead>
				<tr>
				    <th>会员卡号</th>
                    <th>名字</th>
					<th>手机号</th>
					<th>年龄</th>
					<th>性别</th>
                   <!--  <th>居住地</th> -->
                    <th>银行卡</th>
                    <th>积分</th>
                    <th>账户级别</th>
                    <th>账户余额</th>
				    <th>账户状态</th>
				</tr>
			</thead>
			<%
	     String[] name = (String[])request.getServletContext().getAttribute("name");
   	     String[] password = (String[])request.getServletContext().getAttribute("password");
   	     String[] account = (String[])request.getServletContext().getAttribute("account");
   	     String[] tel = (String[])request.getServletContext().getAttribute("tel");
   	     String[] credit = (String[])request.getServletContext().getAttribute("credit");
   	     String[] status = (String[])request.getServletContext().getAttribute("status");
   	     String[] level = (String[])request.getServletContext().getAttribute("level");
   	     String[] money = (String[])request.getServletContext().getAttribute("money");
   	     String[] allcost= (String[])request.getServletContext().getAttribute("allcost");
   	     String[] card=(String[])request.getServletContext().getAttribute("card");
   	     String[] age=(String[])request.getServletContext().getAttribute("age");
   	     String[] gender=(String[])request.getServletContext().getAttribute("gender");
   	     String[] address=(String[])request.getServletContext().getAttribute("address");
   	     String[] date=(String[])request.getServletContext().getAttribute("date");
			int num = (Integer)request.getServletContext().getAttribute("num");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<num;i++){
			%>
				<tr><td><%=account[i] %></td><td><%=name[i] %></td><td ><%=tel[i] %></td><td><%=age[i] %></td><td><%=gender[i] %></td><td><%=card[i] %></td><td><%=credit[i] %></td><td><%=level[i] %></td><td><%=money[i] %></td><td><%=status[i] %></td><td><a href="/MyDessertSystem/rechargehistory?member_account=<%=account[i]%>">缴费记录</a></td><td><a href="/MyDessertSystem/buyhistory?member_account=<%=account[i]%>">消费记录</a></td></tr>
			<%
			   }
			
			%>
			</tbody>  
		</table>
        </form>
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

