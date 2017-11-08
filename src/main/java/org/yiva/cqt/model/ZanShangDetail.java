package org.yiva.cqt.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 微信赞赏明细
 * @author LCY
 *
 */
public class ZanShangDetail implements RowMapper<ZanShangDetail>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String zs_title;
	private String zs_date;
	private Float zs_cost_in;
	private Float zs_cost_get;
	private Integer zs_counts;
	private String zs_author;
	private String zs_comments;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZs_title() {
		return zs_title;
	}
	public void setZs_title(String zs_title) {
		this.zs_title = zs_title;
	}
	public String getZs_date() {
		return zs_date;
	}
	public void setZs_date(String zs_date) {
		this.zs_date = zs_date;
	}
	public Float getZs_cost_in() {
		return zs_cost_in;
	}
	public void setZs_cost_in(Float zs_cost_in) {
		this.zs_cost_in = zs_cost_in;
	}
	public Float getZs_cost_get() {
		return zs_cost_get;
	}
	public void setZs_cost_get(Float zs_cost_get) {
		this.zs_cost_get = zs_cost_get;
	}
	public Integer getZs_counts() {
		return zs_counts;
	}
	public void setZs_counts(Integer zs_counts) {
		this.zs_counts = zs_counts;
	}
	public String getZs_author() {
		return zs_author;
	}
	public void setZs_author(String zs_author) {
		this.zs_author = zs_author;
	}
	public String getZs_comments() {
		return zs_comments;
	}
	public void setZs_comments(String zs_comments) {
		this.zs_comments = zs_comments;
	}
	@Override
	public ZanShangDetail mapRow(ResultSet arg0, int arg1) throws SQLException {
		ZanShangDetail model = new ZanShangDetail();
		model.setId(arg0.getInt("id"));
		model.setZs_title(arg0.getString("zs_title"));
		model.setZs_date(arg0.getString("zs_date"));
		model.setZs_cost_in(arg0.getFloat("zs_cost_in"));
		model.setZs_cost_get(arg0.getFloat("zs_cost_get"));
		model.setZs_counts(arg0.getInt("zs_counts"));
		model.setZs_author(arg0.getString("zs_author"));
		model.setZs_comments(arg0.getString("zs_comments"));
		return model;
	}
	
}
