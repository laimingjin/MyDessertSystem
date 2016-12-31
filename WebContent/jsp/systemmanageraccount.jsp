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
							<li><a href="/DessertHouse/systemmanageraccount.action">我的账户</a></li>
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
                	     //String name = (String)request.getServletContext().getAttribute("account_name");
                	     String account = (String)request.getServletContext().getAttribute("account");
                	     String password = (String)request.getServletContext().getAttribute("password");
                	     
                	     if(account==null){
                	    	 response.sendRedirect("login.jsp"); 
                	     }
                	%>
                    	<div class="photo-inner"><img src="../images/account/ava.jpg" height="186" width="153" /></div>
                        </br></br><br />
                       </div>
                    <!-- /About section -->
                     
                    <!-- Personal info section -->
                	<ul class="personal-info">
                        
                        <li><label>账号</label><span><%=account %></span></li>
                        <li><label>名称</label><span><%=lname %></span></li>
                        <li><label>密码</label><span><%=password %></span></li>
                        <li></li>
                    </ul>
                   
                    <!-- /Personal info section -->
                </div>        
                <!-- /Profile --> 

               
                
               
                                        
              

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