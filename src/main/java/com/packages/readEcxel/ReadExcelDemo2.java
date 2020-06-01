package com.packages.readEcxel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo2 {
	
	
public static void main(String[] args) throws Exception{
	
	File f = new File("C:\\Users\\vreddy239\\Downloads\\AmazonAssignment-master\\testdata.xlsx");
	
	FileInputStream fis = new FileInputStream(f);
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet =workbook.getSheet("data");
	String s=sheet.getRow(0).getCell(0).getStringCellValue();
	
	System.out.println("first row value will be "+s);
	
	String secondValue = sheet.getRow(0).getCell(1).getStringCellValue();
	
	System.out.println("second cell  row value will be "+secondValue);
	
	}
}
