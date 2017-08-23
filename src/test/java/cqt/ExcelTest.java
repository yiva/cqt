package cqt;

import java.io.IOException;

import org.yiva.cqt.utils.ExcelCqt;



public class ExcelTest {

	public static void main(String[] args) {
		try {
			ExcelCqt.importExcelGongyi(null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
