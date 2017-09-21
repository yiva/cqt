package org.yiva.cqt.core.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IAccountService;
import org.yiva.cqt.dao.IAccountDao;
import org.yiva.cqt.model.Account;

@Service("accountService")
public class AccountServiceImpl implements IAccountService{

	@Autowired
	@Qualifier("accountDao")
	private IAccountDao accountDao;
	
	@Override
	public ArrayList<Account> findAllAccount() {
		return accountDao.queryAccounts();
	}

}
