package org.yiva.cqt.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.yiva.cqt.model.Account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExcelCqt {

	/**
	 * 导入台账
	 * 
	 * @param sheet
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Account> importExcelAccount(Workbook wb,
			String sourceName) {

		// Json文件解析
		String json = "";
		try {
			json = JsonUtil.readJsonFile(sourceName + ".json");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("filename: "+sourceName+" -- "+e1.getMessage());
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

		ArrayList<Account> arr_zan = new ArrayList<Account>();
		for (int i = row; i < sheet.getLastRowNum(); i++) {

			Account account = new Account();

			try {
				if (-1 != jo_columns.getIntValue("ac_title")) {
					account.setAc_title(sheet.getRow(i)
							.getCell(jo_columns.getIntValue("ac_title"))
							.toString().trim());
				}

				account.setAc_num((-1 == jo_columns.getIntValue("ac_num")) ? -1
						: Integer.parseInt(sheet.getRow(i)
								.getCell(jo_columns.getIntValue("ac_num"))
								.toString().trim()));
				account.setAc_category(category);
				
				Date date = sheet.getRow(i).getCell(jo_columns.getIntValue("ac_date")).getDateCellValue();
				String df = DateFormatUtils.format(date, "yyyy-MM-dd");
				account.setAc_date(df);
				
				account.setAc_content(sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_content"))
						.toString().trim());

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
				case "转发":
					ac_type = 6;
					break;
				default:
					break;
				}
				// 金额
				account.setAc_type(ac_type);
				if (0 != ac_type && 0 == ac_type % 2) {
					account.setAc_cost(Float.valueOf(sheet.getRow(i)
							.getCell(jo_columns.getIntValue("ac_cost_out"))
							.toString().trim()));
				} else if (1 == ac_type % 2) {
					account.setAc_cost(Float.valueOf(sheet.getRow(i)
							.getCell(jo_columns.getIntValue("ac_cost_in"))
							.toString().trim()));
				} else {
					account.setAc_cost(0.0f);
				}

				account.setAc_handler(sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_handler"))
						.toString().trim());
				account.setAc_comment(sheet.getRow(i)
						.getCell(jo_columns.getIntValue("ac_comment"))
						.toString().trim());

				// 添加到链表中
				arr_zan.add(account);

			} catch (Exception e) {
				System.err.println(i + " -- " + e.getMessage());
			}
		}
		return arr_zan;
	}

	public static ArrayList<Account> importExcelAccountAll(Workbook wb){

		String json;
		try {
			json = JsonUtil.readJsonFile("accounts.json");
		} catch (IOException e) {
			System.err.println("accounts.json -- "+e.getMessage());
			return null;
		}

		JSONArray js_arr = JSON.parseArray(json);

		ArrayList<Account> arr_accounts = new ArrayList<Account>();

		for (int i = 0; i < js_arr.size(); i++) {
			ArrayList<Account> arr_account = new ArrayList<Account>();
			arr_account = importExcelAccount(wb, js_arr.getJSONObject(i)
					.getString("account"));
			if (arr_account.size() != 0) {
				arr_accounts.addAll(arr_account);
			}
		}

		return arr_accounts;
	}
}
