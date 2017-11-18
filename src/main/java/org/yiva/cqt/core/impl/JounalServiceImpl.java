package org.yiva.cqt.core.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IAccountService;
import org.yiva.cqt.core.IJounalService;
import org.yiva.cqt.dao.IAccountDao;
import org.yiva.cqt.dao.IJounalDao;
import org.yiva.cqt.model.Account;
import org.yiva.cqt.model.Jounal;

@Service("jounalService")
public class JounalServiceImpl implements IJounalService{

	@Autowired
	@Qualifier("jounalDao")
	private IJounalDao jounalDao;
	
	@Override
	public ArrayList<Jounal> findAllJounals() {
		return jounalDao.queryJounals();
	}

}
