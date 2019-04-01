package com.zero.datasheet;

public class ReadExcel {

	public static void main(String[] args) {
		ExcelData obj=new ExcelData("C:\\TrainingJAN19\\JAVAPGMS\\ZeroAutomation\\DataSheet.xlsx");
		String data = obj.getdata(0, 1, 1);
		System.out.println(data);
		
		

	}

}
