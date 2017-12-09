package org.yiva.cqt.model.vo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 流水账类别统计
 * @author LCY
 *
 */
public class JounalCategoryCountsVO implements RowMapper<JounalCategoryCountsVO>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ac_category;
	private Integer counts;
	
	public String getAc_category() {
		return ac_category;
	}

	public void setAc_category(String ac_category) {
		this.ac_category = ac_category;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	@Override
	public JounalCategoryCountsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		JounalCategoryCountsVO model = new JounalCategoryCountsVO();
		model.setAc_category(rs.getString("ac_category"));
		model.setCounts(rs.getInt("counts"));
		return model;
	}

	@Override
	public String toString() {
		return "{\"value\":\""+counts+"\",\"name\":\""+ac_category+"\"}";
	}
	
	
	
}
