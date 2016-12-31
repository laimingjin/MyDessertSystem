<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    
    <title>我的DessertHouse</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../css/slider.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" type="text/css" href="../css/account/reset.css"/> 
    <link rel="stylesheet" type="text/css" href="../css/account/style.css"/>
    <link rel="stylesheet" type="text/css" href="../css/account/fancybox.css"/>
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,300,800,700,400italic|PT+Serif:400,400italic"/>
    <link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
    <script type="text/javascript" src="../js/account/jquery.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.easytabs.min.js"></script>
    <script type="text/javascript" src="../js/account/respond.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.easytabs.min.js"></script>   
	<script type="text/javascript" src="../js/account/jquery.adipoli.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.fancybox-1.3.4.pack.js"></script>
    <script type="text/javascript" src="../js/account/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="../js/account/jquery.gmap.min.js"></script>
    <script type="text/javascript" src="../js/account/custom.js"></script>
    
</head>
    <body>
     <!-- Top -->
			 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="index.jsp">首页</a></li>
						<li><a href="/MyDessertSystem/list">产品预定</a></li>
						<!--  <li><a href="http://www.wandafilm.com/jingxuan/main.jsp">电影谈资</a></li>-->
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
							<li><a href="/MyDessertSystem/account.action">我的账户</a></li>
						</ul>
					</div>
				<div class="clear"></div>
			</div>
	  	</div>
            <!-- /Top -->
    
       <!-- Container -->
        <div id="container">
        
           
            
            <!-- Content -->
            <div id="content" >
            
                <!-- Profile -->
                <div id="profile"> 
                 	<!-- About section -->
                	<div class="about">
                	<%
                	     String name = (String)request.getServletContext().getAttribute("account_name");
                	     String password = (String)request.getServletContext().getAttribute("password");
                	     String account = (String)request.getServletContext().getAttribute("account");
                	     String tel = (String)request.getServletContext().getAttribute("tel");
                	     String credit = (String)request.getServletContext().getAttribute("credit");
                	     String status = (String)request.getServletContext().getAttribute("status");
                	     String level = (String)request.getServletContext().getAttribute("level");
                	     String money = (String)request.getServletContext().getAttribute("money");
                	     String allcost= (String)request.getServletContext().getAttribute("allcost");
                	     String card=(String)request.getServletContext().getAttribute("card");
                	     String age=(String)request.getServletContext().getAttribute("age");
                	     String gender=(String)request.getServletContext().getAttribute("gender");
                	     String address=(String)request.getServletContext().getAttribute("address");
                	     String date=(String)request.getServletContext().getAttribute("date");
                	     if(account==null){
                	    	 response.sendRedirect("login.jsp"); 
                	     }
                	%>
                    	<div class="photo-inner"><img src="../images/account/ava.jpg" height="186" width="153" /></div>
                        </br></br><br />
                        <h1><%=name %></h1>
                        <br />
                        <%
				        if(request.getParameter("error") != null && request.getParameter("error").equals("1")){
				        %>
				        <p style="color: red;">您输入的密码或充值金额不正确，请重新充值</p>
				        <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("2")){
				        %>
				        <p style="color: red;">第一次充值，充值金额需大于等于200元，请重新充值</p>
				        <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("3")){
				         %>
				         <p style="color: red;">第一次充值，请绑定银行卡</p>
				         <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("4")){
				         %>
				         <p style="color: red;">您的账户尚未激活，请先激活后再购票</p>
				         <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("5")){
				         %>
				         <p style="color: red;">您的账户余额不足，请先充值后购票</p>
				         <%
				         }
				        if(request.getParameter("error") != null && request.getParameter("error").equals("6")){
					         %>
					         <p style="color: red;">该账户已停止使用</p>
					         <%
					         }
				        %>
                        <p>友情提示：当您账户余额不足30元或账户状态处于暂停时，请及时充值以确保您的账号可以正常使用。</p>
                    </div>
                    <!-- /About section -->
                     
                    <!-- Personal info section -->
                	<ul class="personal-info">
                        
                        <li><label>姓名</label><span><%=name %></span></li>
                        <li><label>性别</label><span><%=age %></span></li>
                        <li><label>年龄</label><span><%=gender %></span></li>
                        <li><label>居住地</label><span><%=address %></span></li>
                        <li><label>会员卡号</label><span><%=account %></span></li>
                         <li><label>密码</label><span><%=password %></span></li>
                        <li><label>手机号</label><span><%=tel %></span></li>
                        <li><label>银行卡号</label><span><%=card %></span></li>
                        <li><label>积分</label><span><%=credit %></span></li>
                        <li><label>账户级别</label><span><%=level %></span></li>
                        <li><label>账户余额</label><span><%=money %></span></li>
                        <li><label>账户状态</label><span><%=status %></span></li>
                        <li><a href="updateMember.jsp?name=<%=name %>&age=<%=age %>&gender=<%= gender%>&address=<%=address %>&account=<%=account%>&password=<%=password%>&card=<%=card%>&tel=<%=tel%>&credit=<%=credit%>&status=<%=status%>&date=<%=date%>&allcost=<%=allcost%>&level=<%=level%>&money=<%=money%>">修改会员信息</a>  &nbsp <a href="/MyDessertSystem/stopMember.action?stop_account=<%=account%>">停止会员</a></li>
                    </ul>
                    <!-- /Personal info section -->
                </div>        
                <!-- /Profile --> 

                <!-- Menu -->
                <div class="menu">
                	<ul class="tabs">
                    	<li><a href="#profile" class="tab-profile">我的资料</a></li>
                    	<li><a href="#resume" class="tab-resume">消费记录</a></li>
                    	<li><a href="#contact" class="tab-contact">充值</a></li>
                    </ul>
                </div>
                <!-- /Menu --> 
                
                <!-- Resume -->
                <div id="resume">
                	 <div class="timeline-section">
                        <!-- Timeline for Employment  -->   
                        <h3 class="main-heading"><span>消费记录</span></h3>   
                        <ul class="timeline">
                        <% 
                                String[] money_cost = (String[])request.getServletContext().getAttribute("money_cost");
                        		String[] time_cost = (String[])request.getServletContext().getAttribute("time_cost");
                        		int num_cost = (Integer)request.getServletContext().getAttribute("num_cost");
                        		for(int i = 0;i<num_cost;i++){
                	     %>
                            <li>                
                                <div class="timelineUnit">
                                    <h4>消费金额：<span class="timelineDate"><%=time_cost[i] %></span></h4>
                                    <h5><%=money_cost[i] %></h5>
                                </div>
                            </li>
                          <%
                        		}
                          %>  
                            <div class="clear"></div>
                        </ul> 
                        <!-- /Timeline for Employment  -->

                        <!-- Timeline for Education  -->   
                        <h3 class="main-heading"><span>缴费记录</span></h3>   
                         <ul class="timeline">
                         <% 
                                String[] money_recharge = (String[])request.getServletContext().getAttribute("money_recharge");
                        		String[] time_recharge = (String[])request.getServletContext().getAttribute("time_recharge");
                        		int num_recharge = (Integer)request.getServletContext().getAttribute("num_recharge");
                        		for(int i = 0;i<num_recharge;i++){
                	     %>
                            <li>            
                                <div class="timelineUnit">
                                    <h4>充值金额：<span class="timelineDate"><%=time_recharge[i] %></span></h4>
                                    <h5><%=money_recharge[i] %></h5>
                                </div>
                            </li>
                         <%
                        		}
                         %>
                            <div class="clear"></div>
                        </ul> 
                        <!-- /Timeline for Education  -->              
                    </div>
                </div>
                <!-- /Resume --> 
                                        
                <!-- Portfolio -->
              
                <!-- /Portfolio -->   
                
                <!-- Contact -->
                <div id="contact">
                	<!-- Contact Info -->
                    <div class="contact-info">
                    <h3 class="main-heading"><span>温馨提示</span></h3>
                	<ul>
                        <li>如果您进行过账户充值，则直接在右侧确认登录密码并输入充值金额即可<br /><br /></li>
                        <li>如果这是您第一次进行账户充值，请输入要绑定的银行卡号且充值金额不可小于200元</li>
                    </ul>
                    </div>
                    <!-- /Contact Info -->
                    
                    <!-- Contact Form -->
                    <div class="contact-form">
                        <h3 class="main-heading"><span>账户充值</span></h3>
                        <div id="contact-status"></div>
                          <form action="/MyDessertSystem/card?status=<%=status %>" method="post" id="contactform"> 
                            <p>
                            	<label for="name">登录密码</label>
                            	<input type="text" name="password" class="input" >
                            </p>
                            <p>
                            	<label for="email">充值金额（RMB）</label>
                            	<input type="text" name="money" class="input">
                            </p>
                             <p>
                            	<label for="email">银行卡号</label>
                            	<input type="text" name="card" class="input" value=<%=card %>>
                            </p>
                            <input type="submit" name="submit" value="确认充值" class="submit">
                        </form>
                    </div>
                    <!-- /Contact Form -->
                </div>
                <!-- /contact -->  

            </div>
            <!-- /Content -->
            
            <!-- Footer -->
			<div class="footer">
            	<div class="copyright">Copyright &copy; 2015.Company name All rights reserved.</div>
            </div>
            <!-- /Footer -->  
            
        </div>
		<!-- /Container -->

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>