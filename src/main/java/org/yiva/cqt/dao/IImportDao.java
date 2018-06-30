package org.yiva.cqt.dao;

import org.yiva.cqt.model.Jounal;

/**
 * 提交台账
 * @author yeahwang
 *
 */
public interface IImportDao {
	
	public int saveSingleJounal(Jounal jounal);
}
