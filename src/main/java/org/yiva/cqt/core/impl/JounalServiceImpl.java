package org.yiva.cqt.core.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IJounalService;
import org.yiva.cqt.dao.IJounalDao;
import org.yiva.cqt.model.Jounal;

@Service("jounalService")
public class JounalServiceImpl implements IJounalService {

	@Autowired
	@Qualifier("jounalDao")
	private IJounalDao jounalDao;

	@Override
	public ArrayList<Jounal> findAllJounals() {
		return jounalDao.queryJounals();
	}

	@Override
	public ArrayList<Jounal> findAllJounalsTmp() {
		// TODO Auto-generated method stub
		return jounalDao.queryJounalsTmp();
	}

	@Override
	public int changeJounalStatus(int status_index, int status_res) {
		return jounalDao.updateJounalStatus(status_index, status_res);
	}

	@Override
	public int setTmpIntoJounal() {
		return jounalDao.putTmpIntoJounal();
	}

}
