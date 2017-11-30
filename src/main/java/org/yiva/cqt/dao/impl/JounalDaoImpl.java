package org.yiva.cqt.dao.impl;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.dao.IJounalDao;
import org.yiva.cqt.model.Jounal;

@Repository("jounalDao")
public class JounalDaoImpl extends BaseDao implements IJounalDao{
	
	
	@Override
	public ArrayList<Jounal> queryJounals() {
		String sql = findSqlByName("SQL_JOUNAL_ALL", SQLCATEGORY.SELECT);
		try {
			RowMapper<Jounal> rowMapper = new BeanPropertyRowMapper<Jounal>(
					Jounal.class);
			ArrayList<Jounal> list = (ArrayList<Jounal>) jdbcTemplate
					.query(sql, rowMapper);
			return list;
		} catch (Exception e) {
			return null;
		}
	}


}
