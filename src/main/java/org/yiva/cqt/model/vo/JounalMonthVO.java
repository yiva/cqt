package org.yiva.cqt.model.vo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class JounalMonthVO implements RowMapper<JounalMonthVO>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String j_month;
	private Integer counts_month;
	private Float sum_price;
	private Integer jounal_type;
	public String getJ_month() {
		return j_month;
	}
	public void setJ_month(String j_month) {
		this.j_month = j_month;
	}
	public Integer getCounts_month() {
		return counts_month;
	}
	public void setCounts_month(Integer counts_month) {
		this.counts_month = counts_month;
	}
	public Float getSum_price() {
		return sum_price;
	}
	public void setSum_price(Float sum_price) {
		this.sum_price = sum_price;
	}
	public Integer getJounal_type() {
		return jounal_type;
	}
	public void setJounal_type(Integer jounal_type) {
		this.jounal_type = jounal_type;
	}
	@Override
	public JounalMonthVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		JounalMonthVO model = new JounalMonthVO();
		model.setJ_month(rs.getString("j_month"));
		model.setCounts_month(rs.getInt("counts_month"));
		model.setSum_price(rs.getFloat("sum_price"));
		model.setJounal_type(rs.getInt("jounal_type"));
		return model;
	}
	
	

}
