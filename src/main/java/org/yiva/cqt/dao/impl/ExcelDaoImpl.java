package org.yiva.cqt.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.dao.ConstantSQL;
import org.yiva.cqt.dao.IExcelDao;
import org.yiva.cqt.dao.BaseDao.SQLCATEGORY;
import org.yiva.cqt.model.Account;
import org.yiva.cqt.model.Article;
import org.yiva.cqt.model.Jounal;

@Repository("excelDao")
public class ExcelDaoImpl extends BaseDao implements IExcelDao {


	private static Logger logger = Logger.getLogger(ExcelDaoImpl.class);

	/**
	 * 导入台账
	 */
	@Override
	public int saveAccountFromExecl(final ArrayList<Account> arr) {
		/**
		 * 批量处理List，分别对每次执行的SQL返回执行成功行数，并存入数据result_count_size;
		 */
		int[] result_count_size = jdbcTemplate.batchUpdate(
				ConstantSQL.SQL_ACCOUNT_DETAIL_GONGYI_INSERT,
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						ps.setString(1, arr.get(i).getAc_title());
						ps.setString(2, arr.get(i).getAc_date());
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
		for (int i = 0; i < result_count_size.length; ++i) {
			if (0 == result_count_size[i]) {
				logger.warn("error insert Accounts of row num is " + i);
			}
			sum_inserted_count += result_count_size[i];
		}
		logger.info("insert Accounts counts is " + sum_inserted_count);
		return sum_inserted_count;
	}


	/**
	 * 导入学习用品台账
	 */
	@Override
	public int saveArctileFromExecl(final ArrayList<Article> arr) {
		int sum_inserted_count = 0;
		int[] result_count_size = jdbcTemplate.batchUpdate(
				ConstantSQL.SQL_ARCTICLE_INSERT,
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
							ps.setString(1, arr.get(i).getArt_num());
							ps.setString(2, arr.get(i).getArt_name());
							ps.setString(3, arr.get(i).getArt_loc());
							ps.setString(4, arr.get(i).getArt_reward());
							ps.setString(5, arr.get(i).getArt_school());
							ps.setString(6, arr.get(i).getArt_grade());
							ps.setString(7, arr.get(i).getArt_mode());
							ps.setFloat(8, arr.get(i).getArt_price());
							ps.setString(9, arr.get(i).getArt_trans());
							ps.setFloat(10, arr.get(i).getArt_trans_cost());
							ps.setString(11, arr.get(i).getArt_sender());
							ps.setString(12, arr.get(i).getArt_time());
							ps.setString(13, arr.get(i).getArt_remit_time());
							ps.setTimestamp(14,
									new Timestamp(new Date().getTime()));
							ps.setTimestamp(15,
									new Timestamp(new Date().getTime()));
					}

					@Override
					public int getBatchSize() {
						// TODO Auto-generated method stub
						return arr.size();
					}
				});

		for (int i = 0; i < result_count_size.length; ++i) {
			if (0 == result_count_size[i]) {
				logger.warn("error insert Articles of row num is " + i);
			}
			sum_inserted_count += result_count_size[i];
		}
		logger.info("insert Articles counts is " + sum_inserted_count);
		return sum_inserted_count;
	}

	@Override
	public int saveJounalFromExecl(final ArrayList<Jounal> arr) {
		String sql = findSqlByName("SQL_JOUNAL_INSERT", SQLCATEGORY.INSERT);
		int sum_inserted_count = 0;
		int[] result_count_size = jdbcTemplate.batchUpdate(
				sql,
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
							ps.setString(1, arr.get(i).getAc_category());
							ps.setString(2, arr.get(i).getAc_date());
							ps.setInt(3, arr.get(i).getAc_type());
							ps.setString(4, arr.get(i).getAc_type_name());
							ps.setString(5, arr.get(i).getAc_content());
							ps.setFloat(6, arr.get(i).getAc_price());
							ps.setString(7, arr.get(i).getAc_operater());
							ps.setString(8, arr.get(i).getAc_channel());
							ps.setString(9, arr.get(i).getAc_save_style());
							ps.setFloat(10, arr.get(i).getAc_poudage());
							ps.setString(11, arr.get(i).getAc_comment());
							ps.setString(12, arr.get(i).getAc_rewarder());
							ps.setString(13, arr.get(i).getAc_rewarder_name());
							ps.setString(14, arr.get(i).getAc_student());
							ps.setString(15, arr.get(i).getAc_student_name());
							ps.setTimestamp(16,
									new Timestamp(new Date().getTime()));
							ps.setTimestamp(17,
									new Timestamp(new Date().getTime()));
					}

					@Override
					public int getBatchSize() {
						// TODO Auto-generated method stub
						return arr.size();
					}
				});

		for (int i = 0; i < result_count_size.length; ++i) {
			if (0 == result_count_size[i]) {
				logger.warn("error insert Jounal of row num is " + i);
			}
			sum_inserted_count += result_count_size[i];
		}
		logger.info("insert Jounal counts is " + sum_inserted_count);
		return sum_inserted_count;
	}

}
