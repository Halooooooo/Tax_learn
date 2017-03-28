<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Calendar cal = Calendar.getInstance();
	int currentYear = cal.get(Calendar.YEAR);
	request.setAttribute("currentYear", currentYear);
	List list = new ArrayList<Integer>();
	for(int i=currentYear;i>currentYear-5;i--)
	{
		list.add(i);
	}
	request.setAttribute("listYear", list);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <%@include file="/common/head.jsp"%>
    <title>年度投诉统计图</title>
  </head>
  <script type="text/javascript" src="${basePath }js/fusioncharts/fusioncharts.js"></script>
  <script type="text/javascript" src="${basePath }js/fusioncharts/fusioncharts.charts.js"></script>
  <script type="text/javascript" src="${basePath }js/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
  <script type="text/javascript">
  //加载完元素后执行
  $(document).ready(doAnnualStatistic());
  
  function doAnnualStatistic(){
  	var year=$("#year option:selected").val();
  	if(year==""||year==undefined){
  		year="${currentYear}";
  	}
  	
	 $.ajax({
		url:"${basePath }/nsfw/complain_getAnnualStatisticData.action",
		data:{"year":year},
	 	type: "post",
		dataType:"json",
  		success:function(data){
  			if(data!=null && data!=""&&data!=undefined){
		  		var revenueChart = new FusionCharts({
		  			"type":"line",
		  			"renderAt":"chartContainer",
		  			"width":"600",
		  			"height":"400",
		  			"dataFormat":"json",
		  			"dataSource": {
		  				"chart":{
		  					"caption":year+"投诉统计",
		  					"xAxisName":"月 份",
		  					"yAxisName":"投 诉 数",
		  					"theme":"fint"
		  				},
		  				"data":data.chartData
		  			}
		  		});
		  		revenueChart.render();
  			}else{
  				alert("数据请求失败！");
  			}
  		},
  		error:function(){alert("数据请求失败！");}
  	});
  }
  
  		
  
  </script>
  <body>
  	<br>
    <s:select id="year" list="#request.listYear" onchange="doAnnualStatistic()"></s:select>
    <br>
    <div id="chartContainer">loading</div>
  </body>
</html>
