<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<head>
<title>在线选座-MStore</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" type="text/css" href="../css/jquery.seat-charts.css">
<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>

<style>
.btn{
    width:80px; 
    height:24px; 
    line-height:20px;
    text-align:center;
    margin: 10px auto;
    cursor:pointer;
	display: block;
	padding:8px 10px;
	font-family: 'ambleregular';
	background:#FC7D01;
	color: #FFF;
	text-decoration: none;
	outline: 0;
	-webkit-transition: all 0.5s ease-in-out;
	-moz-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
}
.btn:hover{
	  text-shadow: 0px 0px 1px #000;
	  background:#292929;
}
    </style>
<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
<script src="../js/jquery.seat-charts.min.js"></script> 
</head>
<body>
	<div class="header">
  	  		 <div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="index.jsp">首页</a></li>
						<li><a href="MStore/list">影片场次</a></li>
						<li><a href="http://www.wandafilm.com/jingxuan/main.jsp">电影谈资</a></li>
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
						<%
						    }
						%>
							<li><a href="#">我的MStore</a></li>
						</ul>
					</div>
				<div class="clear"></div>
			</div>
	  	</div>
  	  		<div class="wrap">
				<div class="header_top">
					<div class="logo">
						<a href="index.jsp"><img src="../images/logo.png" alt="" /></a>
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
   		</div>
   </div>
   <!------------End Header ------------>
 <div class="main">
 	<div class="wrap">
     <div class="content">
     	<div class="content_top">
    		<div class="back-links">
    		<p><a href="/MStores/list" class="active">影片场次</a>&gt;&gt;&gt; <a href="" class="active">在线选座</a></p>
    	    </div>
    		<div class="clear"></div>
    	</div>
        <div class="section group">
            <div class="seat_container">
                <div id="seat-map"> 
                  <div class="front">屏幕</div>                     
                </div> 
            <div class="booking-details">
            <form action="/MStores/buy" method="post" id="buy-form">
            <%
            String movie_name = (String)request.getServletContext().getAttribute("name");
			if(movie_name != null){
			   String time = (String)request.getServletContext().getAttribute("time");
			   String pid = (String)request.getServletContext().getAttribute("pid");
             %>
                <input type="text" value="<%=pid %>" name="pid" style="display:none">
                <input type="text" id="sale" value="" name="sale" style="display:none">
                <p>影片：<span><%=movie_name %></span></p> 
                <p>时间：<span><%=time %></span></p> 
             <%
			 }
             %>
                <p>座位：</p> 
                <ul id="selected-seats"></ul> 
                <p>票数：<span id="counter">0</span></p> 
                <p>总计：<b>￥<span id="total">0</span></b></p> 
                      
                <span class="btn">确定购买</span> 
             </form>       
                <div id="legend"></div> 
            </div>
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
  <%
    String sale = (String)request.getServletContext().getAttribute("sale");
    int seat = (Integer)request.getServletContext().getAttribute("seat"); 
    int price = (Integer)request.getServletContext().getAttribute("price");
%>
   <script type="text/javascript">
   var price = <%=price%>; //票价 
   $(document).ready(function() {
       var $cart = $('#selected-seats'), //座位区 
           $counter = $('#counter'), //票数 
           $total = $('#total'); //总计金额 
           
        var temp_sold = "";
       	var temp = [];
       	var sold_id =[];

       var sc = $('#seat-map').seatCharts({ 
           map: [  //座位图 
               'aaaaaaaaaaaaaaaaaaaaa', 
               'aaaaaaaaaaaaaaaaaaaaa', 
               '_____________________', 
               'aaaaaaaa__aaaaaaaaaaa', 
               'aaaaaaaaaaaaaaaaaaaaa', 
               'aaaaaaaaaaaaaaaaaaaaa', 
               'aaaaaaaaaaaaaaaaaaaaa', 
               'aaaaaaaaaaaaaaaaaaaaa', 
               'aaaaaaaaaaaaaaaaaaaaa', 
               'aa__aa__aaaaaaaaaaaaa' 
           ],
           legend:{ //定义图例 
               node : $('#legend'), 
               items : [ 
                   [ 'a', 'available',   '可选座' ], 
                   [ 'a', 'unavailable', '已售出'] 
               ]                     
    }, 
    click:function () { //点击事件 
       if (this.status() == 'available') { //可选座 
           $('<li>'+(this.settings.row+1)+'排'+this.settings.label+'座</li>') 
                .attr('id', 'cart-item-'+this.settings.id) 
                .data('seatId', this.settings.id) 
                .appendTo($cart); 

            $counter.text(sc.find('selected').length+1); 
            $total.text(recalculateTotal(sc)+price);
            
            var str = (this.settings.row+1)+"_"+this.settings.label;
			temp.push(str);
			sold_id.push[this.settings.id];
                         
            return 'selected'; 
        } else if (this.status() == 'selected') { //已选中 
           //更新数量 
           $counter.text(sc.find('selected').length-1); 
            //更新总计 
           $total.text(recalculateTotal(sc)-price); 
                     
            //删除已预订座位 
           $('#cart-item-'+this.settings.id).remove(); 
            //可选座 
           for(var i=0;i<sold_id.length;i++){
				if(sold_id[i]==this.setting.id){
					sold_id.splice(i,1);
					temp.splice(i,1);
				}
			}
           return 'available'; 
        } else if (this.status() == 'unavailable') { //已售出 
           return 'unavailable'; 
        } else { 
            return this.style(); 
        } 
    } 
}); 
//已售出的座位 
       var sold = "<%=sale%>";
   	   if(sold!=""){
   		var tmp = sold.split("/");
   		for(var i=0;i<tmp.length;i++){
   			sc.get(tmp[i]).status('unavailable');
   		}
   	   }
   	   
   	$(".btn").click(function(){
   		for(var i=0;i<temp.length;i++){
			temp_sold = temp_sold+temp[i]+"/";
		}
   		document.getElementById("sale").value = temp_sold;
		$("#buy-form").submit();
	});
//sc.get(['1_2', '4_4','4_5','6_6','6_7','8_5','8_6','8_7','8_8', '10_1', '10_2']).status('unavailable'); 
     
}); 
//计算总金额 
function recalculateTotal(sc) { 
var total = 0; 
sc.find('selected').each(function () { 
    total += price; 
}); 
         
return total; 
}
   </script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

