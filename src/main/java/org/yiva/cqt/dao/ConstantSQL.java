package org.yiva.cqt.dao;

/**
 * SQL语句常量类
 * @author yiva
 *
 */
public final class ConstantSQL {

	/**
	 * 插入台账
	 */
	public final static String SQL_ACCOUNT_DETAIL_GONGYI_INSERT = "insert into db_cqt.t_account_detail("
			+ "ac_title, ac_date, ac_type, ac_content, ac_cost,ac_handler,ac_comment,ac_category,ac_num,"
			+ "create_time,update_time) values(?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * 插入学习用品台账
	 */
	public final static String SQL_ARCTICLE_INSERT = "insert into db_cqt.t_articles("
			+ "art_num, art_name, art_loc, art_reward, art_school,art_grade,art_mode,art_price,art_trans,"
			+ "art_trans_cost,art_sender,art_time,art_remit_time,create_time,update_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String SQL_ARCTICLE_INSERT_T = "insert into db_cqt.t_articles("
			+ "art_num, art_name, art_loc, art_reward, art_school,art_grade,art_mode,art_price,art_trans,"
			+ "art_trans_cost,art_sender) values(?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 插入流水账
	 */
	public final static String SQL_JOUNAL_INSERT = "insert into db_cqt.t_jounal("
			+ "ac_category,ac_date,ac_type,ac_type_name,ac_content,ac_price,ac_operater,ac_channel,"
			+ "ac_save_style,ac_poudage,ac_comment,ac_rewarder,ac_rewarder_name,ac_student,ac_student_name,"
			+ "create_time,update_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	/**
	 * select类
	 */
	
	/**
	 * 按账目类型查询流水账
	 */
	public final static String SQL_JOUNAL_BY_CATEGORY_SELECT = "select * from t_jounal j where j.ac_category = '?'";
	
	
}
