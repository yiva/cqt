package org.yiva.cqt.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

/**
 * 台账信息
 * 
 * @author yiva 对应t_account_detail
 *
 */
public class Account implements RowMapper<Account>,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;// ID
	private String ac_title;// 主题
	private String ac_date;// 日期
	private Integer ac_type;// 收支类别(1:转入，2：转出，3：收入，4：开支)
	private String ac_content;// 摘要
	private Float ac_cost;// 收支金额
	private String ac_handler;// 经手人
	private String ac_comment;// 备注
	private Integer ac_category;// 台账类型(0：一对一，1:公益金，2：赞赏款，3：奖学金，4：滞留助学金收支，5：其他，6：独立流水，7：微信提现流水，8：微信公众号入账，9：余额宝收益,10:待助)
	private Integer ac_num;//学生编号
	private String student;//学生
	private String rewarder;//资助人
	private String comments;//备注
	private Float poudage;//提现费
	private String save_style;//款项结存
	private String channel;//进款通道
	private String editor;//记账人
	private String ac_rewarder;//资助人
	private String ac_rewarder_name;//资助人姓名

	private Date create_time;//创建时间
	private Date update_time;//更新时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAc_title() {
		return ac_title;
	}

	public void setAc_title(String ac_title) {
		this.ac_title = ac_title;
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

	public Float getAc_cost() {
		return ac_cost;
	}

	public void setAc_cost(Float ac_cost) {
		this.ac_cost = ac_cost;
	}

	public String getAc_handler() {
		return ac_handler;
	}

	public void setAc_handler(String ac_handler) {
		this.ac_handler = ac_handler;
	}

	public String getAc_comment() {
		return ac_comment;
	}

	public void setAc_comment(String ac_comment) {
		this.ac_comment = ac_comment;
	}

	public Integer getAc_category() {
		return ac_category;
	}

	public void setAc_category(Integer ac_category) {
		this.ac_category = ac_category;
	}

	public Integer getAc_num() {
		return ac_num;
	}

	public void setAc_num(Integer ac_num) {
		this.ac_num = ac_num;
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

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getRewarder() {
		return rewarder;
	}

	public void setRewarder(String rewarder) {
		this.rewarder = rewarder;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Float getPoudage() {
		return poudage;
	}

	public void setPoudage(Float poudage) {
		this.poudage = poudage;
	}

	public String getSave_style() {
		return save_style;
	}

	public void setSave_style(String save_style) {
		this.save_style = save_style;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
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

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setAc_title(rs.getString("ac_title"));
		account.setAc_date(rs.getDate("ac_date").toString());
		account.setAc_type(rs.getInt("ac_type"));
		account.setAc_content(rs.getString("ac_content"));
		account.setAc_cost(rs.getFloat("ac_cost"));
		account.setAc_handler(rs.getString("ac_handler"));
		account.setAc_comment(rs.getString("ac_comment"));
		account.setAc_category(rs.getInt("ac_category"));
		account.setAc_num(rs.getInt("ac_num"));
		account.setStudent(rs.getString("student"));
		account.setRewarder(rs.getString("rewarder"));
		account.setComments(rs.getString("comments"));
		account.setPoudage(rs.getFloat("poudage"));
		account.setSave_style(rs.getString("save_style"));
		account.setChannel(rs.getString("channel"));
		account.setEditor(rs.getString("editor"));
		account.setCreate_time(rs.getDate("create_time"));
		account.setUpdate_time(rs.getDate("update_time"));
		return account;
	}
}
