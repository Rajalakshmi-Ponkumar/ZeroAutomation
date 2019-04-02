package com.zero.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zero.datasheet.ExcelData;
import com.zero.script.BaseSeleniumTest;

public class AddOrganisationModule extends BaseSeleniumTest{
	LoginModule loginobj = new LoginModule();		
	ExcelData excelobj= new ExcelData("C:\\TrainingJAN19\\JAVAPGMS\\ZeroAutomation\\DataSheet.xlsx");
	public void launchurl()
	{
		launch("https://login.xero.com/");
	}
	public void addOrganisationlogin()
	{
	       
	        String Un=excelobj.getdata(0,1,1);
	    	String pwd=excelobj.getdata(0, 1, 2);
	    	loginobj.login(Un,pwd);
	    	 
	}
	public void addorganisation(String orgnm,String ctry,String zone,String orgtype,String opt) throws InterruptedException
	{
		WebElement app=findElement(By.xpath("//div[@class='xrh-appbutton--body']"),"App");
		clickobj(app,"App");
		WebElement add= findElement(By.linkText("Add a new organization"),"Add new organisation");
		clickobj(add,"Add new Organisation");
		Thread.sleep(5000);
		WebElement orgname=findElement(By.xpath("//input[@id='text-1022-inputEl']"),"Organisation name");
		entertext(orgname,orgnm,"Organisation name");
		System.out.println(orgnm);
		WebElement ctryname=findElement(By.xpath("//input[@id='countryCmb-inputEl']"),"Countryname");
		entertext(ctryname, ctry, "Country name");
		System.out.println(ctryname);
		System.out.println(ctry);
		WebElement timezone=findElement(By.xpath("//input[@id='cmbTimeZone-inputEl']"),"Timezone");
		
		entertext(timezone,zone, "Time zone");
		WebElement type=findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"),"Type");
		entertext(type,orgtype,"Type");
		//WebElement typeclick=findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/ul[1]/li[1]"),"Typeclick");
		//clickobj(typeclick,"Typeclick");
		
		
		Thread.sleep(3000);
		WebElement software=findElement(By.xpath("//input[@id='combo-1029-inputEl']"),"Software");
		entertext(software,opt,"Option");				
		
	}
	public void clickstarttrial()
	{
		WebElement button=findElement(By.xpath("//a[@id='simplebutton-1035']"),"Button");
		clickobj(button,"Button");
	}
   public void clickbuynow()
   {
	   WebElement button=findElement(By.xpath("//a[@id='simplebutton-1036']]"),"Button");
		clickobj(button,"Button");
   }
}
