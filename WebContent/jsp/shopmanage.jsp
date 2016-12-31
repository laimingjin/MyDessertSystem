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
<script language="javascript">
function ale()
{//这个基本没有什么说的，就是弹出一个提醒的对话框
   alert("该店面存在店员，无法删除");
}
function firm()
{//利用对话框返回的值 （true 或者 false）
if(confirm("你确信要转去 天轰穿的博客？"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
        location.href="http://thcjp.cnblogs.com";
}
else
{//否则说明下了，赫赫
       alert("你按了取消，那就是返回false");
  }
}
function prom()
{
  var name=prompt("请输入您的名字","");//将输入的内容赋给变量 name ，
   //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值
  if(name)//如果返回的有内容
  {
    alert("欢迎您："+ name)
  }
}
</script>

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
       <%
                if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
               
                	%>
                <script type="text/javascript">
                   ale();
                </script>
                <%
                }
                %>
    		

    <div class="component">
		
		<% 
		   String[] shop_name=(String[])request.getServletContext().getAttribute("shop_name");
		  String[] tel=(String[])request.getServletContext().getAttribute("tel");
		  int[] nums = (int[])request.getServletContext().getAttribute("nums");
		  int num = (Integer)request.getServletContext().getAttribute("num");
		  String[][] account = (String[][])request.getServletContext().getAttribute("account");
			   String[][] name = (String[][])request.getServletContext().getAttribute("name");
			   String[][] password = (String[][])request.getServletContext().getAttribute("password");
			   String[][] level = (String[][])request.getServletContext().getAttribute("level");
			   String[][] shop=(String[][])request.getServletContext().getAttribute("shop");
			
		 for(int i = 0;i<num;i++){
		%>
		<table>
		 <label >店面:<%=shop_name[i] %>  电话:<%=tel[i] %></label>
   
		<a href="/MyDessertSystem/deleteShop?shop_name=<%=shop_name[i]%>">删除店面</a><a>   </a>
		<a href="updateShop.jsp?shop_name=<%=shop_name[i]%>&tel=<%=tel[i]%>">修改店面信息</a>
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
			
			<tbody>
			<% 
			   for(int j = 0;j<nums[i];j++){
			%>     
				  <tr><td><%=account[i][j] %></td><td><%=name[i][j] %></td><td ><%=password[i][j] %></td><td><%=level[i][j] %></td><td><%=shop[i][j] %></td><td><a href="/MyDessertSystem/deletewaiter.action?waiter_account=<%=account[i][j] %>">删除</a></td><td><a href="updateWaiter.jsp?waiter_account=<%=account[i][j]%>&name=<%=name[i][j]%>&password=<%=password[i][j]%>&level=<%=level[i][j]%>&shop=<%=shop[i][j]%>">修改</a></td></tr>
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
 
 <form action="addShop.jsp" method="post">
 <div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			 <button class="btn btn-warning" type="submit">新增店面</button>
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

