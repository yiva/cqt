package org.yiva.cqt.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 余额表
 * @author LCY
 *
 */
public class Balance implements RowMapper<Balance>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;//账户ID
	private Float ba_balance;//账户余额
	private Integer ba_status;//账户状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getBa_balance() {
		return ba_balance;
	}
	public void setBa_balance(Float ba_balance) {
		this.ba_balance = ba_balance;
	}
	public Integer getBa_status() {
		return ba_status;
	}
	public void setBa_status(Integer ba_status) {
		this.ba_status = ba_status;
	}
	@Override
	public Balance mapRow(ResultSet rs, int rowNum) throws SQLException {
		Balance item = new Balance();
		item.setId(rs.getString("id"));
		item.setBa_balance(rs.getFloat("ba_balance"));
		item.setBa_status(rs.getInt("ba_status"));
		return item;
	}
	@Override
	public String toString() {
		return "{\"id\":\""+ this.id + "\",\"ba_balance\":\"" + this.ba_balance + "\", \"ba_status\":\"" + this.ba_status + "\"}";
	}
	
	
}
