package org.yiva.cqt.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.IChartDao;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.model.vo.JounalCategoryCountsVO;

@Repository("chartDao")
public class ChartDaoImpl extends BaseDao implements IChartDao{
	
	@Override
	public ArrayList<JounalCategoryCountsVO> showJounalCategoryCounts() {
		String sql = findSqlByName("SQL_JOUNAL_CATEGORY_COUNTS", SQLCATEGORY.SELECT);
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

}
