package org.yiva.cqt.dao;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.yiva.cqt.dao.BaseDao.SQLCATEGORY;
import org.yiva.cqt.model.vo.JounalCategoryCountsVO;
import org.yiva.cqt.utils.ExcelCqtJounal;
import org.yiva.cqt.utils.JsonUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class BaseDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	protected String sql_str;
	protected Logger logger;

	protected String json_sql;
	protected HashMap<String, HashMap<String, String>> sql_map;

	public enum SQLCATEGORY {
		INSERT, UPDATE, DELETE, SELECT, PROCEDURE
	}

	public BaseDao() {
		gatherSQL();
	}

	private void gatherSQL() {
		Logger logger = Logger.getLogger(this.getClass());

		String json_name = StringUtils.substringBefore(this.getClass().getSimpleName(), "Dao");
		// Json文件解析
		String json = "";
		try {
			json = JsonUtil.readJsonFile("db/" + json_name + "_SQL.json");
			JSONObject jo = JSON.parseObject(json);
			JSONArray arr = jo.getJSONArray("sql");
			sql_map = new HashMap<>();
			for (int i = 0; i < arr.size(); ++i) {
				JSONObject item = arr.getJSONObject(i);
				JSONArray i_arr = item.getJSONArray("sql_arr");
				HashMap<String, String> map = new HashMap<>();
				for (int j = 0; j < i_arr.size(); ++j) {
					JSONObject io = i_arr.getJSONObject(j);
					map.put(io.getString("sql_name"), io.getString("sql_str"));
				}
				sql_map.put(item.getString("name"), map);
			}
		} catch (IOException e1) {
			logger.warn("filename: " + json_name + " -- " + e1.getMessage());
		} catch (Exception ex) {
			logger.warn("filename: " + json_name + " -- " + ex.getMessage());
		}
	}

	protected String findSqlByName(String name, SQLCATEGORY category) {
		String sql = "";
		switch (category) {
		case INSERT:
			sql = sql_map.get("insert").get(name);
			break;
		case UPDATE:
			sql = sql_map.get("update").get(name);
			break;
		case DELETE:
			sql = sql_map.get("delete").get(name);
			break;
		case SELECT:
			sql = sql_map.get("select").get(name);
			break;
		case PROCEDURE:
			sql = sql_map.get("procedure").get(name);
			break;
		default:
			break;
		}
		return sql;
	}

	/**
	 * 
	 * @param name
	 * @param sub
	 *            追加条件
	 * @param category
	 * @return
	 */
	protected String findSqlByName(String name, String sub, SQLCATEGORY category) {
		return this.findSqlByName(name, category) + " " + sub;
	}
}
