package org.yiva.cqt.core.impl;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IChartService;
import org.yiva.cqt.dao.IChartDao;
import org.yiva.cqt.model.Balance;
import org.yiva.cqt.model.vo.JounalCategoryCountsVO;
import org.yiva.cqt.model.vo.JounalMonthInAndOutVO;
import org.yiva.cqt.model.vo.JounalMonthVO;

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
		chartDao.showJounalMonthPrice();
		arr = chartDao.showJounalCategoryCounts();
		if(null == arr) {
			return "0";
		}
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

	@Override
	public String showJouanlMonthPrice() {
		ArrayList<JounalMonthInAndOutVO> arr = new ArrayList<>();
		arr = chartDao.showJounalMonthPrice();
		if(null == arr) {
			return "0";
		}
		JSONArray data_name = new JSONArray();
		JSONObject data_set = new JSONObject();
		JSONArray data_in = new JSONArray();
		JSONArray data_out = new JSONArray();
		for(JounalMonthInAndOutVO item : arr) {
			data_name.add(StringUtils.substringAfter(item.getJ_month(), "-")+"月");
			data_in.add(item.getPrice_in());
			data_out.add(item.getPrice_out());
		}
		data_set.put("data_in", data_in);
		data_set.put("data_out", data_out);
		JSONObject res = JSON.parseObject("{\"data_name\":"+data_name.toJSONString()+",\"data_set\":"+data_set.toJSONString()+"}");
		return res.toJSONString();
	}

	@Override
	public String showJouanlBalance(String id) {
		Balance item = new Balance();
		item = chartDao.showJounalBalance(id);
		if(null == item) {
			return "0";
		}
		JSONObject res = JSON.parseObject("{\"data_name\":\"账户余额\",\"data_set\":"+item.toString()+"}");
		return res.toJSONString();
	}

	/**
	 * {"j_month":"2018-01","price_in":"1111.11","count_in":"2000.00","price_out":"1111.11","count_out":"2000.00"}
	 */
	@Override
	public String showJouanlCurrentMonthPrice() {
		JounalMonthInAndOutVO item = new JounalMonthInAndOutVO();
		item = chartDao.showJounalMonthPriceByCurrentMonth();
		if(item == null) {
			return "0";
		}
		JSONObject res = JSON.parseObject("{\"data_name\":\"当月收支情况\",\"data_set\":"+item.toString()+"}");
		return res.toJSONString();
	}
}
