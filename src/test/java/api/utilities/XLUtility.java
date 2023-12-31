package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path;
	public XLUtility(String path) {
		this.path=path;
	}
	public int getRowCount(String sheetName) throws IOException {
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;	
	}
	public int getCellCount(String sheetName,int rownum) throws IOException  {
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;	
	}
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException   {
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter=new DataFormatter();
		String data;
		
		try {
			data=formatter.formatCellValue(cell);
			
		} catch (Exception e) {
			
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		
	}
	

}
