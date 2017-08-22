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

import com.google.common.io.Resources;

public class ExcelCqt {

	/**
	 * 
	 * @param sheet
	 * @return
	 * @throws IOException
	 */
	public static boolean importExcelGongyi(Sheet sheet) throws IOException {
		
		String json = JsonUtil.readJsonFile("gongyi.json");
		Cell cell = sheet.getRow(1).getCell(3);
		StringBuffer sb = new StringBuffer();
		try {
			cell.setCellType(CellType.STRING);
			String str = cell.getStringCellValue();
			int count = 0;
			for (int j = 0; j < sheet.getLastRowNum(); j++) {
				// 收支类别(1:转入，2：转出，3：收入，4：开支)
				String type = sheet.getRow(j).getCell(2).toString();
				switch (type) {
				case "转入":
					System.out.println(++count + " -- "
							+ sheet.getRow(j).getCell(4).toString());
					sb.append(sheet.getRow(j).getCell(1) + "|" + "1" + "|"
							+ sheet.getRow(j).getCell(3) + "|"
							+ sheet.getRow(j).getCell(4) + "|"
							+ sheet.getRow(j).getCell(7) + "\r\n");
					break;
				case "转出":
					System.out.println(++count + " -- "
							+ sheet.getRow(j).getCell(5).toString());
					sb.append(sheet.getRow(j).getCell(1) + "|" + "2" + "|"
							+ sheet.getRow(j).getCell(3) + "|"
							+ sheet.getRow(j).getCell(5) + "|"
							+ sheet.getRow(j).getCell(7) + "\r\n");
					break;
				case "收入":
					System.out.println(++count + " -- "
							+ sheet.getRow(j).getCell(4).toString());
					sb.append(sheet.getRow(j).getCell(1) + "|" + "3" + "|"
							+ sheet.getRow(j).getCell(3) + "|"
							+ sheet.getRow(j).getCell(4) + "|"
							+ sheet.getRow(j).getCell(7) + "\r\n");
					break;
				case "开支":
					System.out.println(++count + " -- "
							+ sheet.getRow(j).getCell(5).toString());
					sb.append(sheet.getRow(j).getCell(1) + "|" + "4" + "|"
							+ sheet.getRow(j).getCell(3) + "|"
							+ sheet.getRow(j).getCell(5) + "|"
							+ sheet.getRow(j).getCell(7) + "\r\n");
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// }
		System.out.println("finish");
		return false;
	}
}
