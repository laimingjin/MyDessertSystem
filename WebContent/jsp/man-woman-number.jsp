<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>不同年龄段男女会员数量柱状图</title>
	<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
	<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
	<script type="text/javascript" src="../js/highcharts/highcharts.js"></script> 
	<script type="text/javascript" src="../js/highcharts/exporting.js"></script> 
	<script type="text/javascript">

	<%
	int[] man = (int[])request.getServletContext().getAttribute("man");
	int[] woman = (int[])request.getServletContext().getAttribute("woman");
     %>
	
	$(function () {
	    $('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '不同年龄段男女会员数量柱状图'
	        },
	        xAxis: {
	            categories: [
	                '0-20',
	                '20-30',
	                '30-40',
	                '40-50',
	                '50-60',
	                '60以上'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '购票人数'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f}人</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: 'Male',
	            data: [<%=man[0]%>, <%=man[1]%>, <%=man[2]%>, <%=man[3]%>, <%=man[4]%>, <%=man[5]%>]

	        }, {
	            name: 'Female',
	            data: [<%=woman[0]%>, <%=woman[1]%>, <%=woman[2]%>, <%=woman[3]%>, <%=woman[4]%>, <%=woman[5]%>]

	        }]
	    });
	});				
	</script>
</head>
<body>
	<div id="container" style="min-width:700px;height:400px"></div>
</body>
</html>