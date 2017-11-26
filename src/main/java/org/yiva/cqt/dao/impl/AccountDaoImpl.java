package org.yiva.cqt.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.dao.IAccountDao;
import org.yiva.cqt.model.Account;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDao implements IAccountDao{


	@Override
	public ArrayList<Account> queryAccounts() {
		StringBuffer sql = new StringBuffer();
		sql.append("select id, ac_title,ac_date, ac_type, ac_content,ac_cost,");
		sql.append("ac_handler,ac_comment, ac_category, ac_num,");
		sql.append("create_time, update_time ");
		sql.append("from db_cqt.t_account_detail");
		try {
			RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(
					Account.class);
			ArrayList<Account> list = (ArrayList<Account>) jdbcTemplate
					.query(sql.toString(), rowMapper);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

}
