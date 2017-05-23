<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>login.jsp</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script src="js/anychart.min.js"></script>
        <script src="js/anychart-ui.min.js"></script>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" />
        <link rel="stylesheet" href="http://cdn.anychart.com/playground-css/custom-drawing/cherry-chart.css" />
        
        <style>
       	 #container {
             width: 300px;
             height: 280px;
             margin: 0;
             padding: 0;
             border: 1px green dashed;
         	}
        </style>
  </head>
  
<body>  
    <form  action="<%=request.getContextPath() %>/LoginAction.action" method="post">  
        <center>
        USERNAME:<input type="text" name="username"/><br>  
        PASSWORD:<input type="password" name="password"/><br>  
        <input type="submit" name="Login"/><br>  
        </center>
    </form>  
    
   	<hr color="green" size="4">
    <!--  -->
	<form action="${pageContext.request.contextPath}/servlet/ListFileServlet" 
		method="post" name="form1">  
        <input type="submit" name="submit" value="DownloadList">  
    </form>${pageContext.request.contextPath}
	<input type="button" value="Upload" onclick="window.location.href='${pageContext.request.contextPath}/jsp/upload.jsp';"/>
	<input type="button" value="JQueryExport" onclick="window.location.href='${pageContext.request.contextPath}/index2.html';"/>
<!-- 

 --><hr color="green" size="4">
	AnyChart!
	<div id="container" style="height: 180px;width: 1304px;">
	</div>

    <script type="text/javascript">
         	anychart.onDocumentReady(function () {
    		// create select
		    var select = $('<select class="select"></select>');
		    var pallete = [
		        'Blue', 'Coffee', 'DefaultPalette',
		        'Earth', 'Glamour', 'Monochrome',
		        'Morning', 'Pastel', 'Provence',
		        'Sea', 'Turquoise', 'V6', 'Wines'
		    ];
		
		    // create and append the options to select
		    for (var i = 0; i < pallete.length; i++) {
		        var option = document.createElement("option");
		        option.value = pallete[i].toLowerCase();
		        option.text = pallete[i];
		        select.append(option);
		    }
		
		    // append title to container
		    $('#container').append('<div class="title-container"><h1>Cherry Chart</h1></div>');
		    // append select to title
		    $('.title-container').append(select);
		
		    // init select2.js
		    // tie event change select value
		    // wrap select to label
		    $('.select').val('defaultpalette').select2({
		        placeholder: "Select palette",
		        minimumResultsForSearch: -1,
		        width: '150'
		    }).on('change', function () {
		        var val = $(this).val();
		
		        if (val === 'defaultpalette') {
		            val = 'defaultPalette';
		        }
		        chart.palette(anychart.palettes[val]);
		    }).wrap('<label>Select Palette: </label>');
		
		    // create column chart
		    chart = anychart.column();
		
		    // create data set on our data
		    var dataSet = anychart.data.set([
		        ['Apr 2016', 29, 37],
		        ['May 2016', 15, 43],
		        ['Jun 2016', 29, 47],
		        ['Jul 2016', 12, 27],
		        ['Aug 2016', 20, 33],
		        ['Sep 2016', 35, 44],
		        ['Okt 2016', 20, 31],
		        ['Nov 2016', 44, 51]
		    ]);
		
		    // set chart padding
		    chart.padding().top(50);
		
		    // map data for the series, take name from the zero column,
		    // low value from the first column and high value from the second column of data set
		    var seriesData = dataSet.mapAs({x: [0], low: [1], high: [2]});
		
		    // create first series with mapped data
		    var series = chart.rangeColumn(seriesData);
		
		    // get shapes
		    var shapes = series.rendering().shapes();
		
		    // add 'line' shape to shapes group
		    shapes.push({
		        // shape name
		        "name": "line",
		        // shape type ("path", "circle", "ellipse" or "rect")
		        "shapeType": "path",
		        // ZIndex for the balance of shapes relative to each other
		        "zIndex": 2
		    });
		
		    // choose the color palettes of the fill point
		    series.fill(function () {
		        return anychart.color.lighten(chart.palette().itemAt(this.index), 0.25);
		    });
		    // choose the color palettes of the stroke point
		    series.stroke(function () {
		        return anychart.color.darken(chart.palette().itemAt(this.index), 0.1);
		    });
		    // set rendering settings
		    series.rendering()
		            // set point function to drawing
		            .point(drawer)
		            // set update point function to drawing, change the point shape when the state changes
		            .updatePoint(drawer)
		            // set shapes
		            .shapes(shapes);
		
		    // set titles for Y-axis
		    chart.yAxis().title('Forecast Revenue in Dollars');
		    // set minimum for y-scale
		    chart.yScale().minimum(0).ticks().interval(5);
		    // set container id for the chart and initiate chart drawing
		    chart.container('container').draw();
		});
		
		function drawer() {
		    // if missing (not correct data), then skipping this point drawing
		    if (this.missing) {
		        return;
		    }
		
		    // get shapes group
		    var shapes = this.shapes || this.getShapesGroup(this.pointState);
		    // column width
		    var columnWidth = 5;
		    // calculate the left value of the x-axis
		    var leftX = this.x - columnWidth / 2;
		    // calculate the right value of the x-axis
		    var rightX = leftX + columnWidth / 2;
		    // stage width
		    var stageWidth = shapes['line'].getStage().width();
		
		    // if pointState > 0, then hover or select point state
		    if (this.pointState > 0) {
		        shapes['line']
		                // resets all 'line' operations
		                .clear()
		                // draw dash line
		                .moveTo(0, this.low)
		                .lineTo(leftX, this.low)
		                .moveTo(0, this.high)
		                .lineTo(leftX, this.high)
		                .moveTo(rightX, this.low)
		                .lineTo(stageWidth, this.low)
		                .moveTo(rightX, this.high)
		                .lineTo(stageWidth, this.high)
		                // set stroke to line, get color from shapes['path']
		                .stroke({
		                    'color': shapes['path'].stroke().color,
		                    'dash': '5 10'
		                })
		
		    } else {
		        // pointState === 0, then normal point state
		        shapes['line']
		                // resets all 'line' operations
		                .clear();
		        shapes['path']
		                // resets all 'path' operations
		                .clear()
		                // draw bulb
		                .moveTo(leftX, this.low)
		                .lineTo(leftX, this.high)
		                .lineTo(rightX, this.high)
		                .lineTo(rightX, this.low)
		                .arcToByEndPoint(leftX, this.low, columnWidth * 2, columnWidth * 2, true, true)
		                // close by connecting the last point with the first straight line
		                .close();
		    }
		}
    
        </script>
</body>   
</html:html>
