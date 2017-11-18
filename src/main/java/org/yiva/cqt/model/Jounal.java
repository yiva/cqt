package org.yiva.cqt.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

/**
 * 流水账信息
 * 
 * @author yiva 对应t_account
 *
 */
public class Jounal implements RowMapper<Jounal>,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;// ID
	private String ac_category;// 台账类型(0：一对一，1:公益金，2：赞赏款，3：奖学金，4：滞留助学金收支，5：其他，6：独立流水，7：微信提现流水，8：微信公众号入账，9：余额宝收益,10:待助)
	private String ac_date;// 日期
	private Date ac_date_t;//读取日期
	private Integer ac_type;// 收支类别(1:转入，2：转出，3：收入，4：开支)
	private String ac_type_name;// 收支类别名(1:转入，2：转出，3：收入，4：开支)
	private String ac_content;// 摘要
	private Float ac_price;// 收支金额
	private Float ac_price_in;//收入
	private Float ac_price_out;//支出
	private String ac_operater;// 经手人
	private String ac_channel;//进款通道
	private String ac_save_style;//款项结存
	private Float ac_poudage;//提现费
	private String ac_comment;// 备注
	private String ac_rewarder;//资助人
	private String ac_rewarder_name;//资助人
	private String ac_student;//学生编号
	private String ac_student_name;//学生

	private Date create_time;//创建时间
	private Date update_time;//更新时间
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAc_category() {
		return ac_category;
	}

	public void setAc_category(String ac_category) {
		this.ac_category = ac_category;
	}

	public String getAc_date() {
		return ac_date;
	}

	public void setAc_date(String ac_date) {
		this.ac_date = ac_date;
	}

	public Integer getAc_type() {
		return ac_type;
	}

	public void setAc_type(Integer ac_type) {
		this.ac_type = ac_type;
	}

	public String getAc_content() {
		return ac_content;
	}

	public void setAc_content(String ac_content) {
		this.ac_content = ac_content;
	}

	public Float getAc_price() {
		return ac_price;
	}

	public void setAc_price(Float ac_price) {
		this.ac_price = ac_price;
	}

	public String getAc_operater() {
		return ac_operater;
	}

	public void setAc_operater(String ac_operater) {
		this.ac_operater = ac_operater;
	}


	public String getAc_comment() {
		return ac_comment;
	}

	public void setAc_comment(String ac_comment) {
		this.ac_comment = ac_comment;
	}
	public String getAc_channel() {
		return ac_channel;
	}

	public void setAc_channel(String ac_channel) {
		this.ac_channel = ac_channel;
	}

	public String getAc_save_style() {
		return ac_save_style;
	}

	public void setAc_save_style(String ac_save_style) {
		this.ac_save_style = ac_save_style;
	}

	public Float getAc_poudage() {
		return ac_poudage;
	}

	public void setAc_poudage(Float ac_poudage) {
		this.ac_poudage = ac_poudage;
	}

	public String getAc_rewarder() {
		return ac_rewarder;
	}

	public void setAc_rewarder(String ac_rewarder) {
		this.ac_rewarder = ac_rewarder;
	}

	public String getAc_rewarder_name() {
		return ac_rewarder_name;
	}

	public void setAc_rewarder_name(String ac_rewarder_name) {
		this.ac_rewarder_name = ac_rewarder_name;
	}

	public String getAc_student() {
		return ac_student;
	}

	public void setAc_student(String ac_student) {
		this.ac_student = ac_student;
	}

	public String getAc_student_name() {
		return ac_student_name;
	}

	public void setAc_student_name(String ac_student_name) {
		this.ac_student_name = ac_student_name;
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

	public Float getAc_price_in() {
		return ac_price_in;
	}

	public void setAc_price_in(Float ac_price_in) {
		this.ac_price_in = ac_price_in;
	}

	public Float getAc_price_out() {
		return ac_price_out;
	}

	public void setAc_price_out(Float ac_price_out) {
		this.ac_price_out = ac_price_out;
	}

	public String getAc_type_name() {
		return ac_type_name;
	}

	public void setAc_type_name(String ac_type_name) {
		this.ac_type_name = ac_type_name;
	}

	public Date getAc_date_t() {
		return ac_date_t;
	}

	public void setAc_date_t(Date ac_date_t) {
		this.ac_date_t = ac_date_t;
	}

	@Override
	public Jounal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Jounal model = new Jounal();
		model.setId(rs.getInt("id"));
		model.setAc_category(rs.getString("ac_category"));
		model.setAc_date(rs.getDate("ac_date").toString());
		model.setAc_date_t(rs.getDate("ac_date_t"));
		model.setAc_type(rs.getInt("ac_type"));
		model.setAc_type_name(rs.getString("ac_type_name"));
		model.setAc_content(rs.getString("ac_content"));
		model.setAc_price(rs.getFloat("ac_price"));
		model.setAc_price_in(rs.getFloat("ac_price_in"));
		model.setAc_price_out(rs.getFloat("ac_price_out"));
		model.setAc_operater(rs.getString("ac_operater"));
		model.setAc_channel(rs.getString("ac_channel"));
		model.setAc_save_style(rs.getString("ac_save_style"));
		model.setAc_poudage(rs.getFloat("ac_poudage"));
		model.setAc_comment(rs.getString("ac_comment"));
		model.setAc_rewarder(rs.getString("ac_rewarder"));
		model.setAc_rewarder_name(rs.getString("ac_rewarder_name"));
		model.setAc_student(rs.getString("ac_student"));
		model.setAc_student_name(rs.getString("ac_student_name"));
		model.setCreate_time(rs.getDate("create_time"));
		model.setUpdate_time(rs.getDate("update_time"));
		return model;
	}
}
