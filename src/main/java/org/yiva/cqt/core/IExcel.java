package org.yiva.cqt.core;

import java.io.InputStream;

public interface IExcel {
	
	int importExcelAccount(InputStream in, String filename, String account_category);

}
