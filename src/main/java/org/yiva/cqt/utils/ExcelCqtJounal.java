package org.yiva.cqt.utils;

import java.io.IOException;
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
	public static ArrayList<Jounal> importExcelJounal(Workbook wb,
			String sourceName) {

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

			Jounal item = new Jounal();

			try {
//				if (-1 != jo_columns.getIntValue("ac_title")) {
//					item.setAc_title(sheet.getRow(i)
//							.getCell(jo_columns.getIntValue("ac_title"))
//							.toString().trim());
//				}
//
//				item.setAc_num((-1 == jo_columns.getIntValue("ac_num")) ? -1
//						: Integer.parseInt(sheet.getRow(i)
//								.getCell(jo_columns.getIntValue("ac_num"))
//								.toString().trim()));
//				item.setAc_category(category);
//
//				Date date = sheet.getRow(i)
//						.getCell(jo_columns.getIntValue("ac_date"))
//						.getDateCellValue();
//				String df = DateFormatUtils.format(date, "yyyy-MM-dd");
//				item.setAc_date(df);
//
//				item.setAc_content(sheet.getRow(i)
//						.getCell(jo_columns.getIntValue("ac_content"))
//						.toString().trim());
//
//				// 类型
//				String str_type = sheet.getRow(i)
//						.getCell(jo_columns.getIntValue("ac_type")).toString()
//						.trim();
//				int ac_type = 0;
//				switch (str_type) {
//				case "转入":
//					ac_type = 1;
//					break;
//				case "转出":
//					ac_type = 2;
//					break;
//				case "收入":
//					ac_type = 3;
//					break;
//				case "开支":
//					ac_type = 4;
//					break;
//				case "转发":
//					ac_type = 6;
//					break;
//				default:
//					break;
//				}
//				// 金额
//				item.setAc_type(ac_type);
//				if (0 != ac_type && 0 == ac_type % 2) {
//					item.setAc_cost(Float.valueOf(sheet.getRow(i)
//							.getCell(jo_columns.getIntValue("ac_cost_out"))
//							.toString().trim()));
//				} else if (1 == ac_type % 2) {
//					item.setAc_cost(Float.valueOf(sheet.getRow(i)
//							.getCell(jo_columns.getIntValue("ac_cost_in"))
//							.toString().trim()));
//					item.setAc_cost(0.0f);
//				}
//
//				item.setAc_handler(sheet.getRow(i)
//						.getCell(jo_columns.getIntValue("ac_handler"))
//						.toString().trim());
//				item.setAc_comment(sheet.getRow(i)
//						.getCell(jo_columns.getIntValue("ac_comment"))
//						.toString().trim());

				// 添加到链表中
				arr.add(item);

			} catch (Exception e) {
				logger.warn(i + " -- " + e.getMessage());
			}
		}
		return arr;
	}

}
