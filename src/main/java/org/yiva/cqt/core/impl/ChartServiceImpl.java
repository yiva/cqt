package org.yiva.cqt.core.impl;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IChartService;
import org.yiva.cqt.dao.IChartDao;
import org.yiva.cqt.model.vo.JounalCategoryCountsVO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service("chartService")
public class ChartServiceImpl implements IChartService{

	@Autowired
	@Qualifier("chartDao")
	private IChartDao chartDao;
	
	@Override
	public String showJounalCategoryCounts() {
		ArrayList<JounalCategoryCountsVO> arr = new ArrayList<>();
		arr = chartDao.showJounalCategoryCounts();
		JSONArray data_name = new JSONArray();
		JSONArray data_set = new JSONArray();
		for(JounalCategoryCountsVO item : arr) {
			if(StringUtils.isNotEmpty(item.getAc_category())) {
				data_name.add(item.getAc_category());
				data_set.add(JSON.parseObject(item.toString()));
			}
		}
		JSONObject res = JSON.parseObject("{\"data_name\":"+data_name.toJSONString()+",\"data_set\":"+data_set.toJSONString()+"}");
		return res.toJSONString();
	}
}
