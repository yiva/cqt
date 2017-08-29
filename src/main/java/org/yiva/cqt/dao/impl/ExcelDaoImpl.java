package org.yiva.cqt.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.dao.IExcelDao;
import org.yiva.cqt.model.Account;

@Repository("excelDao")
public class ExcelDaoImpl extends BaseDao implements IExcelDao{

	@Override
	public int saveAccountFromExecl(final ArrayList<Account> arr) {
		
		int[] result_count_size = jdbcTemplate.batchUpdate("insert into db_cqt.t_account_detail"
				+"(ac_title, ac_date, ac_type, ac_content, ac_cost,"
				+"ac_handler,ac_comment,ac_category,ac_num,create_time," 
				+"update_time)"
				+" values(?,?,?,?,?,?,?,?,?,?,?)", new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1,arr.get(i).getAc_title());
						ps.setString(2,arr.get(i).getAc_date());
						ps.setInt(3, arr.get(i).getAc_type());
						ps.setString(4, arr.get(i).getAc_content());
						ps.setFloat(5, arr.get(i).getAc_cost());
						ps.setString(6, arr.get(i).getAc_handler());
						ps.setString(7, arr.get(i).getAc_comment());
						ps.setInt(8, arr.get(i).getAc_category());
						ps.setInt(9, arr.get(i).getAc_num());
						ps.setTimestamp(10, new Timestamp(new Date().getTime()));
						ps.setTimestamp(11, new Timestamp(new Date().getTime()));
						
						
					}
					
					@Override
					public int getBatchSize() {
						// TODO Auto-generated method stub
						return arr.size();
					}
				});
		int sum_inserted_count = 0;
		for (int a : result_count_size) {
			sum_inserted_count += a;
		}
		
//		String sql = "insert into db_cqt.t_account_detail"
//				+"(ac_title, ac_date, ac_type, ac_content, ac_cost,"
//				+"ac_handler,ac_comment,ac_category,ac_num,create_time," 
//				+"update_time)"
//				+" values(:ac_title,:ac_date,:ac_type,:ac_content,"
//				+":ac_cost,:ac_handler,:ac_comment,:ac_category,:ac_num,"
//				+":create_time,:update_time')";
//		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("ac_title", value)
		return sum_inserted_count;
	}

}
