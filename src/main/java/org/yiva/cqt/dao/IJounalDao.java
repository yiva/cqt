package org.yiva.cqt.dao;

import java.util.ArrayList;

import org.yiva.cqt.model.Jounal;
import org.yiva.cqt.model.vo.JounalCategoryCountsVO;


public interface IJounalDao {

	public ArrayList<Jounal> queryJounals();
	
}
