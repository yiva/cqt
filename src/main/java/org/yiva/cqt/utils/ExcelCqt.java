package org.yiva.cqt.utils;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.yiva.cqt.model.Account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ExcelCqt {

	/**
	 * 
	 * @param sheet
	 * @return
	 * @throws Exception 
	 */
	public static ArrayList<Account> importExcelGongyi(Workbook wb)
			throws Exception {

		// Json文件解析
		String json = JsonUtil.readJsonFile("gongyi.json");
		JSONObject jo = JSON.parseObject(json);
		String sheet_name = jo.getString("sheet");// 获取工作表名
		int row = jo.getIntValue("row");// 起始行
		JSONObject jo_columns = jo.getJSONObject("columns");

		Sheet sheet = wb.getSheet(sheet_name);// 获取工作表

		// Class cl_account = Class.forName("org.yiva.cqt.model.Account");

		ArrayList<Account> arr_gongyi = new ArrayList<Account>();
		for (int i = row; i < sheet.getLastRowNum(); i++) {
			try {
				Account gongyi = new Account();
				gongyi.setAc_category(jo.getIntValue("category"));
				gongyi.setAc_date(sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_date")).toString()
						.trim());
				gongyi.setAc_content(sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_content")).toString()
						.trim());

				// 类型
				String str_type = sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_type")).toString()
						.trim();
				int ac_type = 0;
				switch (str_type) {
				case "转入":
					ac_type = 1;
					break;
				case "转出":
					ac_type = 2;
					break;
				case "收入":
					ac_type = 3;
					break;
				case "开支":
					ac_type = 4;
					break;
				default:
					break;
				}
				// 金额
				gongyi.setAc_type(ac_type);
				if (0 != ac_type && 0 == ac_type % 2) {
					gongyi.setAc_cost(Float.valueOf(sheet.getRow(i)
							.getCell(jo_columns.getIntValue("ac_cost_out"))
							.toString().trim()));
				} else if (1 == ac_type % 2) {
					gongyi.setAc_cost(Float.valueOf(sheet.getRow(i)
							.getCell(jo_columns.getIntValue("ac_cost_in"))
							.toString().trim()));
				} else {
					gongyi.setAc_cost(0.0f);
				}

				gongyi.setAc_handler(sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_handler")).toString()
						.trim());
				gongyi.setAc_comment(sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_comment")).toString()
						.trim());

				// 添加到链表中
				arr_gongyi.add(gongyi);
			} catch (Exception e) {
				System.err.println(i+"--"+e.getMessage());
//				throw new Exception(i+"--"+e.getMessage());
			}
		}
		return arr_gongyi;
	}
}