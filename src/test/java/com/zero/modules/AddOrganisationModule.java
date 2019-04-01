package com.zero.modules;

import com.zero.datasheet.ExcelData;
import com.zero.script.BaseSeleniumTest;

public class AddOrganisationModule extends BaseSeleniumTest{
	LoginModule loginobj = new LoginModule();		
	ExcelData excelobj= new ExcelData("C:\\TrainingJAN19\\JAVAPGMS\\ZeroAutomation\\DataSheet.xlsx");
	public void launchurl()
	{
		launch("https://login.xero.com/");
	}
	public void addOrganisation()
	{
	       
	        String Un=excelobj.getdata(0,1,1);
	    	String pwd=excelobj.getdata(0, 1, 2);
	    	loginobj.login(Un,pwd);
	    	 
	}

}
