<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>  
	<title>mvc-suc</title>  
	 <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="./js/echarts.js"></script>
    <script src="./js/jquery-3.2.1.js"></script>
    
  </head>  	
<body>  
    <h1 align="center"><font color="green"> Success! </font> </h1>  
    <center>
	    USERNAME:<font size="5" color="green"><%=request.getParameter("username") %></font> &nbsp;&nbsp;&nbsp;&nbsp;
	    PASSWORD:<font size="5" color="green"><%=request.getParameter("password") %></font><p>  
    </center>
    <hr color="green" size="4">
    <font color="green">
		EChart!
    </font>
	<div id="eChartLm" style="height: 480px;width: 1304px;"> </div>
</body>  
<script>
   	  	$(function(){
	        var eChart = echarts.init(document.getElementById("eChartLm"));
	        test();
			function test(){
				$.ajax({
					type:"post",
					async:false,
					url:"172.0.0.1:8080/nativeMVC/servlet/GetJsonData.action",//请求路径
					dataType:"json",//返回数据形式为json
					success:function(result){
				           if(result){
				           alert(5);
				           debugger;
				           		var result = eval(result);
			                    options.legend.data = result.legend;  //legend赋值数据
			                  //  options.xAxis[0].data=  result[0].xdata；//x轴赋值数据
			                  //  options.series[0].data= result[0].data；//y轴赋值数据
			                    eChart.hideLoading();  
				                    //myChart.setOption(options); 
								eChart.setOption(option);
				           }
					 },
					error:function(errorMsg){
				           alert("图表请求数据失败啦!");
				           eChart.hideLoading(); 
				 	}
		        });
			}        
		});  
    </script>
</html>  