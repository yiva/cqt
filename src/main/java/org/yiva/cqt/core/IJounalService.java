package org.yiva.cqt.core;

import java.util.ArrayList;

import org.yiva.cqt.model.Jounal;

public interface IJounalService {

	ArrayList<Jounal> findAllJounals();
	ArrayList<Jounal> findAllJounalsTmp();
	int changeJounalStatus(int status_index,int status_res);
	int setTmpIntoJounal();
}
