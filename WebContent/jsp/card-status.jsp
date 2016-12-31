<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>不同年龄段的卡有效/暂停/停止柱状图</title>
	<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
	<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
	<script type="text/javascript" src="../js/highcharts/highcharts.js"></script> 
	<script type="text/javascript" src="../js/highcharts/exporting.js"></script> 
	<script type="text/javascript">
	<%
	int[] active = (int[])request.getServletContext().getAttribute("active");
	int[] pause = (int[])request.getServletContext().getAttribute("pause");
	int[] stop = (int[])request.getServletContext().getAttribute("stop");
     %>
	
	$(function () {
	    $('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '不同年龄段的卡有效/暂停/停止柱状图'
	        },
	        xAxis: {
	            categories: ['10-20', '20-30', '30-40', '40-50', '50-60', '60-70']
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '会员人数'
	            },
	            stackLabels: {
	                enabled: true,
	                style: {
	                    fontWeight: 'bold',
	                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
	                }
	            }
	        },
	        legend: {
	            align: 'right',
	            x: -70,
	            verticalAlign: 'top',
	            y: 20,
	            floating: true,
	            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
	            borderColor: '#CCC',
	            borderWidth: 1,
	            shadow: false
	        },
	        tooltip: {
	            formatter: function() {
	                return '<b>'+ this.x +'</b><br/>'+
	                    this.series.name +': '+ this.y +'<br/>'+
	                    'Total: '+ this.point.stackTotal;
	            }
	        },
	        plotOptions: {
	            column: {
	                stacking: 'normal',
	                dataLabels: {
	                    enabled: true,
	                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
	                }
	            }
	        },
	        series: [{
	            name: '激活',
	            data: [<%=active[0]%>, <%=active[1]%>, <%=active[2]%>, <%=active[3]%>, <%=active[4]%>,<%=active[5]%>]
	        }, {
	            name: '暂停',
	            data: [<%=pause[0]%>, <%=pause[1]%>, <%=pause[2]%>, <%=pause[3]%>, <%=pause[4]%>,<%=pause[5]%>]
	        }, {
	            name: '停止',
	            data: [<%=stop[0]%>, <%=stop[1]%>,<%=stop[2]%>,<%=stop[3]%>,<%=stop[4]%>,<%=stop[5]%>]
	        }]
	    });
	});	
	</script>
</head>
<body>
	<div id="container" style="min-width:700px;height:400px"></div>
</body>
</html>