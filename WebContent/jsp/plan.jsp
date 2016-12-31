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
						
						<%
						String type = (String)request.getServletContext().getAttribute("accountType");
						if(type=="waiter"){
						%>
						<li><a href="/MyDessertSystem/plan.action">产品计划</a></li>
						<li><a href="/MyDessertSystem/allplan.action">历史计划</a></li>
						<li><a href="/MyDessertSystem/allmember.action">查看会员</a></li>
						<%
						}
						if(type=="manager"){
						%>
						<li><a href="/MStores/allowplan.action">放映计划</a></li>
						<li><a href="/MStores/movie">电影上线、下线</a></li>
						<li><a href="/MStores/count.jsp">统计图表</a></li>
						<%
						}
						%>
					</ul>
				</div>
				<div class="account_desc">
						<ul>
						<%
						    String name = (String)request.getServletContext().getAttribute("account_name");
						    if(name != null){
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
     	
    	<h2>制定产品计划：</h2>
    	<br />
    	 <div class="section group">
		
			<form method="post" action="/MyDessertSystem/addPlan">
               <script type="text/javascript" src="../js/date.js"></script>
               
               <%
               int all_product_size=(int)request.getServletContext().getAttribute("all_product_size");
               String[] all_product_pid = (String[])request.getServletContext().getAttribute("all_product_pid");
               String[] all_product_name = (String[])request.getServletContext().getAttribute("all_product_name");
                String[] all_shop_name=(String[])request.getServletContext().getAttribute("all_shop_name");
                int all_shop_size=(int)request.getServletContext().getAttribute("all_shop_size");
                %>
               <label>产品:</label>
           	<span class="standard_select"><!--边框-->
                <span class="select_shelter"><!--遮挡默认边框-->
                  <select type="select" name="product" id="type">
                  <% 
               for(int j=0;j<all_product_size;j++){
            	  %>
               	<option value="<%=all_product_pid[j]%>  <%=all_product_name[j]%>"><%=all_product_pid[j]%>  <%=all_product_name[j]%></option>
            	<% 
              }
               %>
                  </select>
               </span>
              </span>
             
                          <label>  选择日期：</label><input name="member.birth" type="text" value="" size="14" readonly onClick="showcalendar(event,this);" onFocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''">
                          <label>数量：<input type="text" name="quantity" value=""/></label>
                          <label> 价格：<input type="text" name="price" value=""/></label>
                     <label>店面：</label>
           	<span class="standard_select"><!--边框-->
                <span class="select_shelter"><!--遮挡默认边框-->
                  <select type="select" name="shop" id="type">
                  <% 
               for(int k=0;k<all_shop_size;k++){
            	  %>
               	<option value="<%=all_shop_name[k]%>"><%=all_shop_name[k]%></option>
            	<% 
              }
               %>
                  </select>
               </span>
              </span>
			    <input type="submit" value="确认"  class="btn">
			</form>          
    </div>
    	
    <div class="component">
        <form method="post" action="#">
		<table>
			<thead>
				<tr>
				    <th>计划id</th>
                    <th>产品id</th>
					<th>产品名</th>
					<th>销售日期</th>
					<th>销售商店</th>
					<th>数量</th>
                    <th>价格</th>
                    <th>状态</th>
                    <th>修改</th>
				</tr>
			</thead>
			<%
			String[] pid = (String[])request.getServletContext().getAttribute("pid");
			String[] product_name = (String[])request.getServletContext().getAttribute("product_name");
			String[] starttime = (String[])request.getServletContext().getAttribute("starttime");
			String[] shop = (String[])request.getServletContext().getAttribute("shop");
			String[] quantity = (String[])request.getServletContext().getAttribute("quantity");
			String[] status = (String[])request.getServletContext().getAttribute("status");
			String[] price = (String[])request.getServletContext().getAttribute("price");
			String[] planid =(String[])request.getServletContext().getAttribute("planid");
			int num = (Integer)request.getServletContext().getAttribute("num");
             %>
			<tbody>
			<% 
			   for(int i = 0;i<num;i++){
			%>
				<tr><td><%=planid[i] %></td><td><%=pid[i] %></td><td><%=product_name[i] %></td><td ><%=starttime[i] %></td><td><%=shop[i] %></td><td><%=quantity[i] %></td><td>￥<%=price[i] %></td><td><%=status[i] %></td><td><a href="updatePlan.jsp?planid=<%= planid[i]%>&pid=<%=pid[i] %>&product_name=<%=product_name[i] %>&price=<%= price[i]%>&quantity=<%=quantity[i] %>&shop=<%=shop[i] %>&starttime=<%=starttime[i] %>&wid=<%=(String)request.getServletContext().getAttribute("account") %>" id="alter">修改</a></td></tr>
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

