package org.yiva.cqt.core.impl;

import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IExcel;
import org.yiva.cqt.utils.ExcelCqt;
import org.yiva.cqt.utils.ExcelUtil;


@Service("excelService")
public class ExcelImportImpl implements IExcel{

	@Override
	public int importExcelTest(InputStream in, String filename) {
		Workbook wb = null;
		try {
			wb = ExcelUtil.getWorkbook(in, filename);
			if(null == wb){  
	            throw new Exception("创建Excel工作薄为空！");  
	        } 
			/*
			 * Excel解析 
			 */
			boolean res = false;
			res = ExcelCqt.importExcelGongyi(wb);
			if (false == res) {
				return -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return 0;
	}

}
