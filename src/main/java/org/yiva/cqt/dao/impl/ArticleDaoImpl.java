package org.yiva.cqt.dao.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.yiva.cqt.dao.BaseDao;
import org.yiva.cqt.dao.IArticleDao;
import org.yiva.cqt.model.Article;

@Repository("articleDao")
public class ArticleDaoImpl extends BaseDao implements IArticleDao{

	private final Logger article_logger = Logger.getLogger(this.getClass());

	public ArrayList<Article> queryArticles() {
		StringBuffer sql = new StringBuffer();
		sql.append("select id, art_num,art_name, art_loc, art_reward,art_school,");
		sql.append("art_grade,art_mode, art_price, art_trans,art_trans_cost,art_sender,");
		sql.append("art_time,art_remit_time,create_time, update_time ");
		sql.append("from db_cqt.t_articles");
		try {
			RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(
					Article.class);
			ArrayList<Article> list = (ArrayList<Article>) jdbcTemplate
					.query(sql.toString(), rowMapper);
			return list;
		} catch (Exception e) {
			article_logger.warn(e.getMessage());
			return null;
		}
	}

}
