package org.yiva.cqt.dao;

import java.util.ArrayList;

import org.yiva.cqt.model.Account;

public interface IExcelDao {

	//导入公益金
	int saveAccountGongYiFromExecl(final ArrayList<Account> arr);
	
	//导入赞赏款
	int saveAccountZanXhangFromExecl(final ArrayList<Account> arr);
}
