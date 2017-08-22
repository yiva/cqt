package org.yiva.cqt.model;

import java.util.Date;

/**
 * 台账信息
 * 
 * @author yiva 对应t_account_detail
 *
 */
public class Account {

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
}
