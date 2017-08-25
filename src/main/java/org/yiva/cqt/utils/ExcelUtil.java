package org.yiva.cqt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel数据读取
 * @author yiva
 *
 */
public class ExcelUtil {
	
	private final static String excel2003L =".xls";    //2003- 版本的excel  
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
	
	public static void main(String[] args) {
		ExcelUtil.readXml("C:/tmp/7.xls");
		System.out.println("End....");
		System.exit(0);
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public static void readXml(String fileName){  
        boolean isE2007 = false;    //判断是否是excel2007格式  
        if(fileName.endsWith("xlsx"))  
            isE2007 = true;  
        try {  
            InputStream input = new FileInputStream(fileName);  //建立输入流  
            Workbook wb  = null;  
            //根据文件格式(2003或者2007)来初始化  
            if(isE2007){
            	wb = new XSSFWorkbook(input);  
            }
            else{
            	wb = new HSSFWorkbook(input);
            }
            Sheet sheet = wb.getSheetAt(0);     //获得第一个表单  
            Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器  
            while (rows.hasNext()) {  
                Row row = rows.next();  //获得行数据  
                System.out.println("Row #" + row.getRowNum());  //获得行号从0开始  
                Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器  
                while (cells.hasNext()) {  
                    Cell cell = cells.next();  
                    System.out.println("Cell #" + cell.getColumnIndex());  
                    switch (cell.getCellType()) {   //根据cell中的类型来输出数据  
                    case HSSFCell.CELL_TYPE_NUMERIC:  
                        System.out.println(cell.getNumericCellValue());  
                        break;  
                    case HSSFCell.CELL_TYPE_STRING:  
                        System.out.println(cell.getStringCellValue());  
                        break;  
                    case HSSFCell.CELL_TYPE_BOOLEAN:  
                        System.out.println(cell.getBooleanCellValue());  
                        break;  
                    case HSSFCell.CELL_TYPE_FORMULA:  
                        System.out.println(cell.getCellFormula());  
                        break;  
                    default:  
                        System.out.println("unsuported sell type");  
                    break;  
                    }  
                }  
            }  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }  
	
	@SuppressWarnings({ "resource" })
	public static Sheet readSheet(String fileName,String sheetName){
		boolean isE2007 = false;    //判断是否是excel2007格式  
        if(fileName.endsWith("xlsx"))  
            isE2007 = true;  
        try {  
            InputStream input = new FileInputStream(fileName);  //建立输入流  
            Workbook wb  = null;  
            //根据文件格式(2003或者2007)来初始化  
            if(isE2007){
            	wb = new XSSFWorkbook(input);  
            }
            else{
            	wb = new HSSFWorkbook(input);
            }
            Sheet sheet = wb.getSheet(sheetName);
            return sheet;
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return null;
	}
	
	public static Workbook readSheet(String fileName){
		boolean isE2007 = false;    //判断是否是excel2007格式  
        if(fileName.endsWith("xlsx"))  
            isE2007 = true;  
        try {  
            InputStream input = new FileInputStream(fileName);  //建立输入流  
            Workbook wb  = null;  
            //根据文件格式(2003或者2007)来初始化  
            if(isE2007){
            	wb = new XSSFWorkbook(input);  
            }
            else{
            	wb = new HSSFWorkbook(input);
            }
            return wb;
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return null;
	}
	
	/**
	 * 导出报表
	 * 通过服务器中的模板写入数据后导出
	 * @param filename
	 * @return
	 */
	@SuppressWarnings("resource")
	public static <T> boolean writeSheet(String filename ,ArrayList<T> list){
		try {
			//传入的文件  
	        FileInputStream fileInput = new FileInputStream(filename);  
	        //poi包下的类读取excel文件  
	        POIFSFileSystem ts = new POIFSFileSystem(fileInput);  
	        // 创建一个webbook，对应一个Excel文件            
	        HSSFWorkbook workbook = new HSSFWorkbook(ts);  
	        //对应Excel文件中的sheet，0代表第一个             
	        HSSFSheet sh = workbook.getSheetAt(0);  
	        //修改excle表的第5行数据              
	        for(int i=2;i<19;i++){  
	            //对第五行的数据修改  
	            sh.getRow(4).getCell((short)i).setCellValue(100210+i);  
	        }  
	        //将修改后的文件写出到D:\\excel目录下  
	        FileOutputStream os = new FileOutputStream("D:\\excel\\辅机1.xls");
			os.flush();  
	        //将Excel写出        
	        workbook.write(os);  
	        //关闭流  
	        fileInput.close();  
	        os.close();
	        return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return false;
	}
	/** 
     * 描述：对表格中数值进行格式化 
     * @param cell 
     * @return 
     */  
    public  Object getCellValue(Cell cell){  
        Object value = null;  
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符  
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化  
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字  
          
        switch (cell.getCellType()) {  
        case Cell.CELL_TYPE_STRING:  
            value = cell.getRichStringCellValue().getString();  
            break;  
        case Cell.CELL_TYPE_NUMERIC:  
            if("General".equals(cell.getCellStyle().getDataFormatString())){  
                value = df.format(cell.getNumericCellValue());  
            }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){  
                value = sdf.format(cell.getDateCellValue());  
            }else{  
                value = df2.format(cell.getNumericCellValue());  
            }  
            break;  
        case Cell.CELL_TYPE_BOOLEAN:  
            value = cell.getBooleanCellValue();  
            break;  
        case Cell.CELL_TYPE_BLANK:  
            value = "";  
            break;  
        default:  
            break;  
        }  
        return value;  
    }  
    
    public static  Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{  
        Workbook wb = null;  
        String fileType = fileName.substring(fileName.lastIndexOf("."));  
        if(excel2003L.equals(fileType)){  
            wb = new HSSFWorkbook(inStr);  //2003-  
        }else if(excel2007U.equals(fileType)){  
            wb = new XSSFWorkbook(inStr);  //2007+  
        }else{  
            throw new Exception("解析的文件格式有误！");  
        }  
        return wb;  
    } 
    
    public static Sheet getSheet(Workbook wb,String sheetName) throws Exception{
    	Sheet sheet = null;
    	try {
    		sheet = wb.getSheet(sheetName);
		} catch (Exception e) {
			throw new Exception("读取工作表失败！");
		}
    	return sheet;
    }
}
