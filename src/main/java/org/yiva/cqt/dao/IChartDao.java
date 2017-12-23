package org.yiva.cqt.dao;

import java.util.ArrayList;

import org.yiva.cqt.model.Balance;
import org.yiva.cqt.model.vo.JounalCategoryCountsVO;
import org.yiva.cqt.model.vo.JounalMonthInAndOutVO;

public interface IChartDao {

	ArrayList<JounalCategoryCountsVO> showJounalCategoryCounts();
	
	ArrayList<JounalMonthInAndOutVO> showJounalMonthPrice();
	
	Balance showJounalBalance(String id);
}
