<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>销售</title>
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
						<li><a href="#">销售</a></li>
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
    		<p>所有产品：</p>
    	    </div>
    		<div class="clear"></div>
    	</div>
    		

    <div class="component">
    <form action="/MyDessertSystem/sale" method="post">
		<table>
			<thead>
			 <tr>
			        <th>选择</th>
			        <th>销售日期</th>
                    <th>名称</th>
					<th>品牌</th>
					<th>分类</th>
					<th>保鲜条件</th>
					<th>原材料</th>
                    <th>价格</th>
                    <th>数量</th>
				</tr>
				<!-- -->	
			</thead>
			<%
            String[] product_name = (String[])request.getServletContext().getAttribute("product_name");
			if(product_name != null){
			   String[] starttime = (String[])request.getServletContext().getAttribute("starttime");
			   String[] branch = (String[])request.getServletContext().getAttribute("branch");
			   String[] catagory = (String[])request.getServletContext().getAttribute("catagory");
			   String[] condition = (String[])request.getServletContext().getAttribute("keepingcondition");
			   String[] content = (String[])request.getServletContext().getAttribute("content");
			   String[] price = (String[])request.getServletContext().getAttribute("price");
			   String[] pid = (String[])request.getServletContext().getAttribute("pid");
			   String[] planid = (String[])request.getServletContext().getAttribute("planid");
			   String[]quantity=(String[])request.getServletContext().getAttribute("quantity");
			   int num = (Integer)request.getServletContext().getAttribute("num");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<num;i++){
			%>
				  <tr><td><input type="checkbox" name="checkbox" value="<%=planid[i]%>;<%=i%>;<%=price[i]%>"/></td><td><%=starttime[i]%></td>
<td><%=product_name[i] %></td><td><%=branch[i] %></td><td ><%=catagory[i] %></td><td><%=content[i] %></td><td><%=condition[i] %></td><td><%=price[i]%></td><td><input type="text" class="text" name="quantity" onfocus="this.value = '';"></td></tr>
			<!--
			<tr><td><a><img src="../images/11.jpg" alt="" /></a></td><td><h2>product_name[i]</h2><h2>branch[i]</h2></td></tr>
			-->
			<%
			   }
			}
			%>
			
			
			</tbody>
		</table>
		
		<label>会员账号（非会员则填0）：<input type="text" name="member_account" value="0"/></label>
		<label>服务员id：<input type="text" name="waiter_account" value="<%=(String)request.getServletContext().getAttribute("account")%>"/></label> 
		
		<div class="container-fluid">
	        <div class="row-fluid">
		        <div class="span12">
		        <input type="checkbox" name="paytype" value="paybycash"/>现金支付
		        <input type="checkbox" name="paytype" value="paybycard"/>银行卡支付
		        <input type="checkbox" name="paytype" value="paybycredit"/>积分兑换
			       <button class="btn btn-warning" type="submit">购买</button>
		        </div>
	        </div>
          </div>
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

