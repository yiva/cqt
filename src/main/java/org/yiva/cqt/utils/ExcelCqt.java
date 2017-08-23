package org.yiva.cqt.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.yiva.cqt.model.Account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Resources;

public class ExcelCqt {

	/**
	 * 
	 * @param sheet
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static boolean importExcelGongyi(Workbook wb) throws IOException,
			ClassNotFoundException {

		// Json文件解析
		String json = JsonUtil.readJsonFile("gongyi.json");
		JSONObject jo = JSON.parseObject(json);
		String sheet_name = jo.getString("sheet");// 获取工作表名
		int row = jo.getIntValue("row");// 起始行
		int col = jo.getIntValue("col");// 起始列
		JSONObject jo_columns = jo.getJSONObject("columns");

		Sheet sheet = wb.getSheet(sheet_name);// 获取工作表

		// Class cl_account = Class.forName("org.yiva.cqt.model.Account");

		for (int i = row; i < sheet.getLastRowNum(); i++) {
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
		}

		// Class clazz =
		// Class.forName("org.yiva.cqt.model."+jo.getString("class"));
		// System.out.println(jo.get("class"));
		// Cell cell = sheet.getRow(1).getCell(3);
		// StringBuffer sb = new StringBuffer();
		// try {
		// cell.setCellType(CellType.STRING);
		// String str = cell.getStringCellValue();
		// int count = 0;
		// for (int j = 0; j < sheet.getLastRowNum(); j++) {
		// // 收支类别(1:转入，2：转出，3：收入，4：开支)
		// String type = sheet.getRow(j).getCell(2).toString();
		// switch (type) {
		// case "转入":
		// System.out.println(++count + " -- "
		// + sheet.getRow(j).getCell(4).toString());
		// sb.append(sheet.getRow(j).getCell(1) + "|" + "1" + "|"
		// + sheet.getRow(j).getCell(3) + "|"
		// + sheet.getRow(j).getCell(4) + "|"
		// + sheet.getRow(j).getCell(7) + "\r\n");
		// break;
		// case "转出":
		// System.out.println(++count + " -- "
		// + sheet.getRow(j).getCell(5).toString());
		// sb.append(sheet.getRow(j).getCell(1) + "|" + "2" + "|"
		// + sheet.getRow(j).getCell(3) + "|"
		// + sheet.getRow(j).getCell(5) + "|"
		// + sheet.getRow(j).getCell(7) + "\r\n");
		// break;
		// case "收入":
		// System.out.println(++count + " -- "
		// + sheet.getRow(j).getCell(4).toString());
		// sb.append(sheet.getRow(j).getCell(1) + "|" + "3" + "|"
		// + sheet.getRow(j).getCell(3) + "|"
		// + sheet.getRow(j).getCell(4) + "|"
		// + sheet.getRow(j).getCell(7) + "\r\n");
		// break;
		// case "开支":
		// System.out.println(++count + " -- "
		// + sheet.getRow(j).getCell(5).toString());
		// sb.append(sheet.getRow(j).getCell(1) + "|" + "4" + "|"
		// + sheet.getRow(j).getCell(3) + "|"
		// + sheet.getRow(j).getCell(5) + "|"
		// + sheet.getRow(j).getCell(7) + "\r\n");
		// break;
		// }
		// }
		// } catch (Exception e) {
		// System.err.println(e.getMessage());
		// }
		//
		// // }
		// System.out.println("finish");
		return false;
	}
}
