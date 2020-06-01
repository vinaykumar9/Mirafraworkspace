package com.packages.readEcxel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {
	
	
public static void main(String[] args) throws Exception{
	
	File f = new File("C:\\Users\\vreddy239\\Downloads\\AmazonAssignment-master\\testdata.xlsx");
	
	FileInputStream fis = new FileInputStream(f);
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet =workbook.getSheet("data");
	String s=sheet.getRow(0).getCell(0).toString();
	
	System.out.println("first row value will be "+s);
	
	String secondValue = sheet.getRow(0).getCell(1).toString();
	
	System.out.println("second cell  row value will be "+secondValue);
	
	
	int rowcount =sheet.getLastRowNum();
	
	System.out.println("total number of rows are "+ rowcount);
	
	
	sheet.getRow(0).createCell(2).setCellValue("pass");
	sheet.getRow(1).createCell(2).setCellValue("fail");
	
	FileOutputStream fos = new FileOutputStream(f);

	
	workbook.write(fos);
	
	
	
	
	

	}
}
