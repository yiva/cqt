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
import org.yiva.cqt.dao.IImportDao;
import org.yiva.cqt.dao.BaseDao.SQLCATEGORY;
import org.yiva.cqt.model.Account;
import org.yiva.cqt.model.Jounal;

/**
 * 手动导入台账信息
 * @author yeahwang
 *
 */
@Repository("importDao")
public class ImportDaoImpl extends BaseDao implements IImportDao{

	private static Logger logger = Logger.getLogger(ImportDaoImpl.class);
	/**
	 * 单条导入
	 */
	@Override
	public int saveSingleJounal(final Jounal jounal) {
		String sql = findSqlByName("SQL_JOUNAL_INSERT_MAUNAL", SQLCATEGORY.INSERT);
		/**
		 * 批量处理List，分别对每次执行的SQL返回执行成功行数，并存入数据result_count_size;
		 */
		
		int[] result_count_size = jdbcTemplate.batchUpdate(
				sql,
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						ps.setString(1, jounal.getAc_category());
						ps.setString(2, jounal.getAc_date());
						ps.setInt(3, jounal.getAc_type());
						ps.setString(4, jounal.getAc_type_name());
						ps.setString(5, jounal.getAc_content());
						ps.setFloat(6, jounal.getAc_price());
						ps.setString(7, jounal.getAc_operater());
						ps.setString(8, jounal.getAc_channel());
						ps.setString(9, jounal.getAc_save_style());
						ps.setFloat(10, jounal.getAc_poudage());
						ps.setString(11, jounal.getAc_comment());
						ps.setString(12, jounal.getAc_rewarder());
						ps.setString(13, jounal.getAc_rewarder_name());
						ps.setString(14, jounal.getAc_student());
						ps.setString(15, jounal.getAc_student_name());
						ps.setTimestamp(16,
								new Timestamp(new Date().getTime()));
						ps.setTimestamp(17,
								new Timestamp(new Date().getTime()));

					}

					@Override
					public int getBatchSize() {
						// TODO Auto-generated method stub
						return 1;
					}
				});
		logger.info("insert Accounts counts is " + result_count_size);
		return result_count_size[0];
	}
	
	
}
