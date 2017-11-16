package org.yiva.cqt.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.yiva.cqt.model.Account;
import org.yiva.cqt.model.Article;
import org.yiva.cqt.model.Jounal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExcelCqtJounal {

	private static Logger logger = Logger.getLogger(ExcelCqtJounal.class);

	/**
	 * 导入流水账
	 * 
	 * @param workbook,source_name
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Jounal> importExcelJounal(Workbook wb, String sourceName) {

		// Json文件解析
		String json = "";
		try {
			json = JsonUtil.readJsonFile(sourceName + ".json");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.warn("filename: " + sourceName + " -- " + e1.getMessage());
			return null;
		} catch (Exception ex) {
			logger.warn("filename: " + sourceName + " -- " + ex.getMessage());
			return null;
		}
		JSONObject jo = JSON.parseObject(json);
		String sheet_name = jo.getString("sheet");// 获取工作表名
		int row = jo.getIntValue("row");// 起始行
		int category = jo.getIntValue("ac_category");
		JSONObject jo_columns = jo.getJSONObject("columns");

		Sheet sheet = wb.getSheet(sheet_name);// 获取工作表
		if (sheet == null) {
			return null;
		}

		ArrayList<Jounal> arr = new ArrayList<Jounal>();
		for (int i = row; i < sheet.getLastRowNum(); i++) {

			try {
				// 获得Jounal类
				Class<Jounal> cl = Jounal.class;
				// new the model
				Jounal item = cl.newInstance();
				// get all methods of the class
				Method[] methods = cl.getDeclaredMethods();
				// 获得所有属性
				Field[] fields = cl.getDeclaredFields();
				// 历遍属性并赋值
				for (Field field : fields) {
					String name = field.getName();
					if (jo_columns.containsKey(name) && -1 != jo_columns.getIntValue(name)) {
						String method_name = "set" + name.toUpperCase().substring(0, 1) + name.substring(1);
						Method method = cl.getMethod(method_name, new Class[] { field.getType() });
						String fieldType = field.getType().getSimpleName();//获取属性类型
						switch(fieldType) {
						case "String":
							method.invoke(item,
									sheet.getRow(i).getCell(jo_columns.getIntValue(name)).toString().trim());
							break;
						case "Integer":
						case "int":
							method.invoke(item,
									Integer.parseInt(sheet.getRow(i).getCell(jo_columns.getIntValue(name)).toString().trim()));
							break;
						case "float":
						case "Float":
							method.invoke(item,
									Float.parseFloat(sheet.getRow(i).getCell(jo_columns.getIntValue(name)).toString().trim()));
							break;
						}
					}
				}
				arr.add(item);

			} catch (Exception e) {
				logger.warn(i + " -- " + e.getMessage());
			}
		}
		return arr;
	}

}
