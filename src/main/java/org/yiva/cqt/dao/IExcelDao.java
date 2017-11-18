package org.yiva.cqt.dao;

import java.util.ArrayList;

import org.yiva.cqt.model.Account;
import org.yiva.cqt.model.Article;
import org.yiva.cqt.model.Jounal;

public interface IExcelDao {

	//导入公益金
	int saveAccountFromExecl(final ArrayList<Account> arr);
	
	int saveArctileFromExecl(final ArrayList<Article> arr);

	int saveJounalFromExecl(final ArrayList<Jounal> arr);
}
