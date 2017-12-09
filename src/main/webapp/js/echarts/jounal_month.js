function showJounalSumMonthBar(dataName, dataSet, idName) {
	var j_month_bar = echarts.init($('#'+idName)[0]);
	var xAxisData = dataName;//坐标名
	var inData = dataSet.data_in;//收入
	var outData = dataSet.data_out;//支出

	var itemStyle = {
		normal : {},
		emphasis : {
			barBorderWidth : 1,
			shadowBlur : 10,
			shadowOffsetX : 0,
			shadowOffsetY : 0,
			shadowColor : 'rgba(0,0,0,0.5)'
		}
	};

	option = {
		backgroundColor : '#eee',
		legend : {
			data : [ '收入', '支出' ],
			align : 'left',
			left : 10
		},
		brush : {
			toolbox : [ 'rect', 'polygon', 'lineX', 'lineY', 'keep', 'clear' ],
			xAxisIndex : 0
		},
		toolbox : {
			feature : {
				magicType : {
					type : [ 'stack', 'tiled' ]
				},
				dataView : {}
			}
		},
		tooltip : {},
		xAxis : {
			data : xAxisData,
			name : '月份',
			silent : false,
			axisLine : {
				onZero : true
			},
			splitLine : {
				show : false
			},
			splitArea : {
				show : false
			}
		},
		yAxis : {
			inverse : false,
			splitArea : {
				show : false
			}
		},
		grid : {
			left : 100
		},
		series : [ {
			name : '收入',
			type : 'bar',
			stack : 'one',
			itemStyle : itemStyle,
			data : inData
		}, {
			name : '支出',
			type : 'bar',
			stack : 'two',
			itemStyle : itemStyle,
			data : outData
		} ]
	};

	j_month_bar.on('brushSelected', renderBrushed);
	// 使用刚指定的配置项和数据显示图表。
	j_month_bar.setOption(option);
}
function renderBrushed(params) {
	var brushed = [];
	var brushComponent = params.batch[0];

	for (var sIdx = 0; sIdx < brushComponent.selected.length; sIdx++) {
		var rawIndices = brushComponent.selected[sIdx].dataIndex;
		brushed.push('[Series ' + sIdx + '] ' + rawIndices.join(', '));
	}

	j_month_bar.setOption({
		title : {
			backgroundColor : '#333',
			text : 'SELECTED DATA INDICES: \n' + brushed.join('\n'),
			bottom : 0,
			right : 0,
			width : 100,
			textStyle : {
				fontSize : 12,
				color : '#fff'
			}
		}
	});
}