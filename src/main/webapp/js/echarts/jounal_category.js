function showJounalCategoryPie(dataName, dataSet, idName) {
	var j_category_chart = echarts.init($('#' + idName)[0]);
	option = {
		title : {
			text : '各类别流水账情况',
			subtext : '',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c}笔 ({d}%)"
		},
		legend : {
			orient : 'vertical',
			left : 'left',
			data : dataName
		// ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
		},
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : dataSet,
			/*
			 * [ {value:335, name:'直接访问'}, {value:310, name:'邮件营销'}, {value:234,
			 * name:'联盟广告'}, {value:135, name:'视频广告'}, {value:1548, name:'搜索引擎'} ] ,
			 */
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	j_category_chart.setOption(option);
}