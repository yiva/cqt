package org.yiva.cqt.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.IChartDao;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.model.Balance;
import org.yiva.cqt.model.vo.JounalCategoryCountsVO;
import org.yiva.cqt.model.vo.JounalMonthInAndOutVO;
import org.yiva.cqt.model.vo.JounalMonthVO;

@Repository("chartDao")
public class ChartDaoImpl extends BaseDao implements IChartDao{
	
	@Override
	public ArrayList<JounalCategoryCountsVO> showJounalCategoryCounts() {
		String sql = this.findSqlByName("SQL_JOUNAL_CATEGORY_COUNTS", SQLCATEGORY.SELECT);
		try {
			RowMapper<JounalCategoryCountsVO> rowMapper = new BeanPropertyRowMapper<JounalCategoryCountsVO>(
					JounalCategoryCountsVO.class);
			ArrayList<JounalCategoryCountsVO> list = (ArrayList<JounalCategoryCountsVO>) jdbcTemplate
					.query(sql, rowMapper);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<JounalMonthInAndOutVO> showJounalMonthPrice() {
		try {
			RowMapper<JounalMonthInAndOutVO> rowMapper = new BeanPropertyRowMapper<JounalMonthInAndOutVO>(
					JounalMonthInAndOutVO.class);
			ArrayList<JounalMonthInAndOutVO> list = (ArrayList<JounalMonthInAndOutVO>) jdbcTemplate
					.query(this.findSqlByName("SQL_JOUNAL_MONTH_IN_AND_OUT", SQLCATEGORY.SELECT), rowMapper);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.warn(e.getMessage());
		}
		return null;
	}

	@Override
	public Balance showJounalBalance(String id) {
		try {
			RowMapper<Balance> rowMapper = new BeanPropertyRowMapper<Balance>(
					Balance.class);
			ArrayList<Balance> list = (ArrayList<Balance>) jdbcTemplate
					.query(this.findSqlByName("SQL_JOUNAL_BALANCE_CURRENT", SQLCATEGORY.SELECT), rowMapper);
			return list.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.warn(e.getMessage());
		}
		return null;
	}

}
