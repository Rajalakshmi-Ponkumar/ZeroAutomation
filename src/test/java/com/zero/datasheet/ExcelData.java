package com.zero.datasheet;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelData(String Filepath)
	{
		try {
			File src=new File(Filepath);
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);			
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		}
	}
	
		public String getdata(int sheetno,int row,int column)
		{
			 sheet=wb.getSheetAt(sheetno);
			 String data = sheet.getRow(row).getCell(column).getStringCellValue();
			 return data;
		}
		
		
	}


