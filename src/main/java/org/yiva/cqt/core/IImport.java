package org.yiva.cqt.core;

import java.io.InputStream;

import org.yiva.cqt.model.Jounal;

public interface IImport {
	
	int importExcelAccount(InputStream in, String filename, String account_category);
	
	int importExcelArticle(InputStream in, String filename);
	
	int importExcelJounal(InputStream in, String filename);

	int inportSingleJounal(Jounal jounal);
}
