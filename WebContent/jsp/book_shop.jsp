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
 <!-- Top -->
			
            
            
            
    <div class="main">
 	<div class="wrap">
     <div class="content">
    <div class="component">
		
		<% 
		   String[] shop_name=(String[])request.getServletContext().getAttribute("shopName");
		  int[] nums = (int[])request.getServletContext().getAttribute("nums");
		  int num = (Integer)request.getServletContext().getAttribute("num");
		  String[][] planIDs = (String[][])request.getServletContext().getAttribute("planIDs");
			   String[][] productIDs = (String[][])request.getServletContext().getAttribute("productIDs");
			   int[][] quantity = (int[][])request.getServletContext().getAttribute("quantity");
			
		 for(int i = 0;i<num;i++){
		%>
		<table>
		 <label >店面:<%=shop_name[i] %>  </label>
   
			<thead>
			 <tr>
                    <th>计划ID</th>
					<th>产品ID</th>
					<th>售出数量</th>
				</tr>
				<!-- -->	
			</thead>
			
			<tbody>
			<% 
			   for(int j = 0;j<nums[i];j++){
			%>     
				  <tr><td><%=planIDs[i][j] %></td><td><%=productIDs[i][j] %></td><td ><%=quantity[i][j] %></td></tr>
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
 
 
 
 
    <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

