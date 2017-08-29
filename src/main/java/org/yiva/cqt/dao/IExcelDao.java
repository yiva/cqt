package org.yiva.cqt.dao;

import java.util.ArrayList;

import org.yiva.cqt.model.Account;

public interface IExcelDao {

	int saveAccountFromExecl(final ArrayList<Account> arr);
}
