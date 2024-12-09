package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet worksheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		worksheet = workbook.getSheet(sheetName);
		int rowCount = worksheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		worksheet = workbook.getSheet(sheetName);
		row = worksheet.getRow(rowNum);
		workbook.close();
		fi.close();
		return row.getLastCellNum();
	}
	
	public String getCellData(String sheetName, int rowNumber, int cellNumber) throws IOException{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		worksheet = workbook.getSheet(sheetName);
		row = worksheet.getRow(rowNumber);
		cell = row.getCell(cellNumber);		
		DataFormatter formatter = new DataFormatter();		
		workbook.close();
		fi.close();
		return formatter.formatCellValue(cell);
	}
	
	


}
