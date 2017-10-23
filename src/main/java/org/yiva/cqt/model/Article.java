package org.yiva.cqt.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

/**
 * 学习用品转发情况汇总表
 * @author yeahwang
 *
 */
public class Article implements RowMapper<Article>,Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;//序号
	private String art_num;//编号
	private String art_name;//姓名
	private String art_loc;//资助地
	private String art_reward;//资助人
	private String art_school;//就读学校
	private String art_grade;//年级
	private String art_mode;//采购环节
	private Float art_price;//采购单价
	private String art_trans;//转运环节
	private Float art_trans_cost;//转运费用
	private String art_sender;//学习用品转发人
	private String art_time;//转发时间
	private String art_remit_time;//采购款划拨时间
	private Date create_time;//创建时间
	private Date update_time;//更新时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArt_num() {
		return art_num;
	}
	public void setArt_num(String art_num) {
		this.art_num = art_num;
	}
	public String getArt_name() {
		return art_name;
	}
	public void setArt_name(String art_name) {
		this.art_name = art_name;
	}
	public String getArt_loc() {
		return art_loc;
	}
	public void setArt_loc(String art_loc) {
		this.art_loc = art_loc;
	}
	public String getArt_reward() {
		return art_reward;
	}
	public void setArt_reward(String art_reward) {
		this.art_reward = art_reward;
	}
	public String getArt_school() {
		return art_school;
	}
	public void setArt_school(String art_school) {
		this.art_school = art_school;
	}
	public String getArt_grade() {
		return art_grade;
	}
	public void setArt_grade(String art_grade) {
		this.art_grade = art_grade;
	}
	public String getArt_mode() {
		return art_mode;
	}
	public void setArt_mode(String art_mode) {
		this.art_mode = art_mode;
	}
	public Float getArt_price() {
		return art_price;
	}
	public void setArt_price(Float art_price) {
		this.art_price = art_price;
	}
	public String getArt_trans() {
		return art_trans;
	}
	public void setArt_trans(String art_trans) {
		this.art_trans = art_trans;
	}
	public Float getArt_trans_cost() {
		return art_trans_cost;
	}
	public void setArt_trans_cost(Float art_trans_cost) {
		this.art_trans_cost = art_trans_cost;
	}
	public String getArt_sender() {
		return art_sender;
	}
	public void setArt_sender(String art_sender) {
		this.art_sender = art_sender;
	}
	
	public String getArt_time() {
		return art_time;
	}
	public void setArt_time(String art_time) {
		this.art_time = art_time;
	}
	public String getArt_remit_time() {
		return art_remit_time;
	}
	public void setArt_remit_time(String art_remit_time) {
		this.art_remit_time = art_remit_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	@Override
	public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setArt_num(rs.getString("art_num"));
		article.setArt_name(rs.getString("art_name"));
		article.setArt_loc(rs.getString("art_loc"));
		article.setArt_reward(rs.getString("art_reward"));
		article.setArt_school(rs.getString("art_school"));
		article.setArt_grade(rs.getString("art_grade"));
		article.setArt_mode(rs.getString("art_mode"));
		article.setArt_price(rs.getFloat("art_price"));
		article.setArt_trans(rs.getString("art_trans"));
		article.setArt_trans_cost(rs.getFloat("art_trans_cost"));
		article.setArt_sender(rs.getString("art_sender"));
		article.setArt_time(rs.getString("art_time"));
		article.setArt_remit_time(rs.getString("art_remit_time"));
		article.setCreate_time(rs.getDate("create_time"));
		article.setUpdate_time(rs.getDate("update_time"));
		return article;
	}

}
