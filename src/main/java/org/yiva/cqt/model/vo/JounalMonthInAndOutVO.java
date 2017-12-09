package org.yiva.cqt.model.vo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class JounalMonthInAndOutVO implements RowMapper<JounalMonthInAndOutVO>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String j_month;
	private Integer counts_in;
	private Integer counts_out;
	private Float price_in;
	private Float price_out;
	public String getJ_month() {
		return j_month;
	}
	public void setJ_month(String j_month) {
		this.j_month = j_month;
	}
	
	public Integer getCounts_in() {
		return counts_in;
	}
	public void setCounts_in(Integer counts_in) {
		this.counts_in = counts_in;
	}
	public Integer getCounts_out() {
		return counts_out;
	}
	public void setCounts_out(Integer counts_out) {
		this.counts_out = counts_out;
	}
	public Float getPrice_in() {
		return price_in;
	}
	public void setPrice_in(Float price_in) {
		this.price_in = price_in;
	}
	public Float getPrice_out() {
		return price_out;
	}
	public void setPrice_out(Float price_out) {
		this.price_out = price_out;
	}
	@Override
	public JounalMonthInAndOutVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		JounalMonthInAndOutVO model = new JounalMonthInAndOutVO();
		model.setJ_month(rs.getString("j_month"));
		model.setCounts_in(rs.getInt("counts_in"));
		model.setCounts_out(rs.getInt("counts_out"));
		model.setPrice_in(rs.getFloat("price_in"));
		model.setPrice_out(rs.getFloat("price_out"));
		return model;
	}
}
