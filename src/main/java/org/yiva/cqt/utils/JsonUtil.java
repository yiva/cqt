package org.yiva.cqt.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.yiva.cqt.dao.BaseDao.SQLCATEGORY;

import com.alibaba.fastjson.JSONArray;
import com.google.common.io.Resources;

public class JsonUtil {

	/**
	 * 解析文件中的Json 文件放在src/main/resources
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String readJsonFile(String filename) throws IOException {
		BufferedInputStream bi = (BufferedInputStream) Resources.getResource(filename).getContent();
		byte[] bs = new byte[4096];
		StringBuilder sb = new StringBuilder();
		while (bi.read(bs) != -1) {
			sb.append(new String(bs, "utf-8"));
		}
		bi.close();
		return sb.toString().trim();
	}

	public static String findSqlByName(String name, HashMap map, SQLCATEGORY category) {
		String sql = "";
		switch(category) {
		case INSERT:
			sql = (String) ((HashMap)map.get("insert")).get(name);
			break;
		case UPDATE:
			sql = (String) ((HashMap)map.get("update")).get(name);
			break;
		case SELECT:
			sql = (String) ((HashMap)map.get("select")).get(name);
			break;
		default:
			break;
		}
		return sql;
	}
}
