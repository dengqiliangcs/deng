<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path= request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=path%>/js/echarts.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#button01").click(function(){
			 $.ajax({
				   url: "<%=path%>/tongji",
				   dataType:"json",
				   success: function(msg){
					   var myChart = echarts.init(document.getElementById('main'));
					   var posList = [
						    'left', 'right', 'top', 'bottom',
						    'inside',
						    'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
						    'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
						];

					   myChart.configParameters = {
						    rotate: {
						        min: -90,
						        max: 90
						    },
						    align: {
						        options: {
						            left: 'left',
						            center: 'center',
						            right: 'right'
						        }
						    },
						    verticalAlign: {
						        options: {
						            top: 'top',
						            middle: 'middle',
						            bottom: 'bottom'
						        }
						    },
						    position: {
						        options: echarts.util.reduce(posList, function (map, pos) {
						            map[pos] = pos;
						            return map;
						        }, {})
						    },
						    distance: {
						        min: 0,
						        max: 100
						    }
						};

					   myChart.config = {
						    rotate: 90,
						    align: 'left',
						    verticalAlign: 'middle',
						    position: 'insideBottom',
						    distance: 15,
						    onChange: function () {
						        var labelOption = {
						            normal: {
						                rotate: myChart.config.rotate,
						                align: myChart.config.align,
						                verticalAlign: myChart.config.verticalAlign,
						                position: myChart.config.position,
						                distance: myChart.config.distance
						            }
						        };
						        myChart.setOption({
						            series: [{
						                label: labelOption
						            }, {
						                label: labelOption
						            }, {
						                label: labelOption
						            }, {
						                label: labelOption
						            }]
						        });
						    }
						};


						var labelOption = {
						    normal: {
						        show: true,
						        position: myChart.config.position,
						        distance: myChart.config.distance,
						        align: myChart.config.align,
						        verticalAlign: myChart.config.verticalAlign,
						        rotate: myChart.config.rotate,
						        formatter: '{c}  {name|{a}}',
						        fontSize: 16,
						        rich: {
						            name: {
						                textBorderColor: '#fff'
						            }
						        }
						    }
						};

						option = {
						    color: ['#003366', '#006699', '#4cabce', '#e5323e'],
						    tooltip: {
						        trigger: 'axis',
						        axisPointer: {
						            type: 'shadow'
						        }
						    },
						    legend: {
						        data: ['Forest', 'Steppe', 'Desert', 'Wetland']
						    },
						    toolbox: {
						        show: true,
						        orient: 'vertical',
						        left: 'right',
						        top: 'center',
						        feature: {
						            mark: {show: true},
						            dataView: {show: true, readOnly: false},
						            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
						            restore: {show: true},
						            saveAsImage: {show: true}
						        }
						    },
						    calculable: true,
						    xAxis: [
						        {
						            type: 'category',
						            axisTick: {show: false},
						            data: msg.phone
						        }
						    ],
						    yAxis: [
						        {
						            type: 'value'
						        }
						    ],
						    series: [
						        {
						            name: 'Forest',
						            type: 'bar',
						            barGap: 0,
						            label: labelOption,
						            data: msg.upLoad
						        },
						        {
						            name: 'Steppe',
						            type: 'bar',
						            label: labelOption,
						            data: msg.downLoad
						        },
						        {
						            name: 'Desert',
						            type: 'bar',
						            label: labelOption,
						            data: msg.totalLoad
						        },
						       
						    ]
						};
					   myChart.setOption(option);
				   }
				 });			
		});
	});
</script>
<body>
	<input type="button" value="点我显示" id="button01"/>
	<div id="main" style="width: 1800px;height:500px;"></div>
</body>
</html>