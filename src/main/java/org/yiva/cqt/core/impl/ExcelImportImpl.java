package org.yiva.cqt.core.impl;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IExcel;
import org.yiva.cqt.dao.IExcelDao;
import org.yiva.cqt.model.Account;
import org.yiva.cqt.model.Article;
import org.yiva.cqt.model.Jounal;
import org.yiva.cqt.utils.ExcelCqt;
import org.yiva.cqt.utils.ExcelCqtJounal;
import org.yiva.cqt.utils.ExcelUtil;

@Service("excelService")
public class ExcelImportImpl implements IExcel {

	@Autowired
	@Qualifier("excelDao")
	private IExcelDao excelDao;

	@Override
	public int importExcelAccount(InputStream in, String filename, String account_category) {
		int flag = -1;
		Workbook wb = null;
		try {
			wb = ExcelUtil.getWorkbook(in, filename);
			if (null == wb) {
				throw new Exception("创建Excel工作薄为空！");
			}
			/*
			 * Excel解析
			 */
			ArrayList<Account> arr_account = new ArrayList<Account>();
			if ("all".equals(account_category)) {
				arr_account = ExcelCqt.importExcelAccountAll(wb);
			}else if("jounal".equals(account_category)) {
				ExcelCqtJounal.importExcelJounal(wb, "jounal");
			}
			else{
				arr_account = ExcelCqt.importExcelAccount(wb,account_category);
			}
			int res = excelDao.saveAccountFromExecl(arr_account);
			if (1 <= res) {
				flag = 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = -1;
			e.printStackTrace();
		} 
		return flag;
	}

	@Override
	public int importExcelArticle(InputStream in, String filename) {
		int flag = -1;
		Workbook wb = null;
		try {
			wb = ExcelUtil.getWorkbook(in, filename);
			if (null == wb) {
				throw new Exception("创建Excel工作薄为空！");
			}
			/*
			 * Excel解析
			 */
			ArrayList<Article> arr_article = new ArrayList<Article>();
			arr_article = ExcelCqt.importExcelArticle(wb);
			int res = excelDao.saveArctileFromExecl(arr_article);
			if (1 <= res) {
				flag = 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = -1;
			e.printStackTrace();
		} 
		return flag;
	}

	public int importExcelJounal(InputStream in, String filename) {
		int flag = -1;
		Workbook wb = null;
		try {
			wb = ExcelUtil.getWorkbook(in, filename);
			if (null == wb) {
				throw new Exception("创建Excel工作薄为空！");
			}
			/*
			 * Excel解析
			 */
			ArrayList<Jounal> arr = new ArrayList<Jounal>();
			arr = ExcelCqtJounal.importExcelJounal(wb, "jounal");
			int res = excelDao.saveJounalFromExecl(arr);
			if (1 <= res) {
				flag = 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = -1;
			e.printStackTrace();
		} 
		return flag;
	}
}
