package org.yiva.cqt.dao;

/**
 * SQL语句常量类
 * @author yiva
 *
 */
public final class ConstantSQL {

	/**
	 * 插入公益金
	 */
	public final static String SQL_ACCOUNT_DETAIL_GONGYI_INSERT = "insert into db_cqt.t_account_detail("
			+ "ac_title, ac_date, ac_type, ac_content, ac_cost,ac_handler,ac_comment,ac_category,"
			+ "create_time,update_time) values(?,?,?,?,?,?,?,?,?,?)";

}
