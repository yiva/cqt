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
		StringBuffer sql = new StringBuffer();
		sql.append("select id,ac_category,ac_date,ac_type,ac_type_name,ac_content,ac_price,");
		sql.append("ac_operater,ac_channel,ac_save_style,ac_poudage,ac_comment,ac_rewarder,");
		sql.append("ac_rewarder_name,ac_student,ac_student_name,create_time,update_time ");
		sql.append("from db_cqt.t_jounal");
		try {
			RowMapper<Jounal> rowMapper = new BeanPropertyRowMapper<Jounal>(
					Jounal.class);
			ArrayList<Jounal> list = (ArrayList<Jounal>) jdbcTemplate
					.query(sql.toString(), rowMapper);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

}
