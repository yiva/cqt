package org.yiva.cqt.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.dao.IExcelDao;
import org.yiva.cqt.model.Account;

@Repository("excelDao")
public class ExcelDaoImpl extends BaseDao implements IExcelDao{

	@Override
	public int saveAccountFromExecl(ArrayList<Account> arr) {
		String sql = "insert into db_cqt.t_account_detail"
				+"(ac_title, ac_date, ac_type, ac_content, ac_cost,"
				+"ac_handler,ac_comment,ac_category,ac_num,create_time," 
				+"update_time)"
				+" values(:ac_title,:ac_date,:ac_type,:ac_content,"
				+":ac_cost,:ac_handler,:ac_comment,:ac_category,:ac_num,"
				+":create_time,:update_time')";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("ac_title", value)
		return 0;
	}

}
