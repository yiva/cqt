package org.yiva.cqt.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
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

	@Override
	public ArrayList<Jounal> queryJounalsTmp() {
		// TODO Auto-generated method stub
		String sql = findSqlByName("SQL_JOUNAL_TMP", SQLCATEGORY.SELECT);
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

	@Override
	public int updateJounalStatus(final int status_index,final int status_res) {
		String sql = findSqlByName("SQL_JOUNAL_TMP_ALL_STATUS_UPDATE", SQLCATEGORY.UPDATE);
		int res = 0;
		try {
			res = jdbcTemplate.update(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, status_res);
					ps.setInt(2, status_index);
				}
			});
		} catch (Exception e) {
			res = -1;
		}
		return res;
	}

	@Override
	public int putTmpIntoJounal() {
		String sql = findSqlByName("SET_JOUNAL_PRO", SQLCATEGORY.PROCEDURE);
		int res = 0;
		try {
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			res = -1;
		}
		return res;
	}

}
