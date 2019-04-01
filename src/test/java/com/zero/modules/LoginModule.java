package com.zero.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zero.datasheet.ExcelData;
import com.zero.script.BaseSeleniumTest;

public class LoginModule extends BaseSeleniumTest{
	
public void launchurl()
{
	launch("https://login.xero.com/");
}
		public void login(String userName,String password)
	{		
		
		WebElement emailid=findElement(By.id("email"),"Email Id");
		entertext(emailid,userName,"Email Id");
		WebElement pwd= findElement(By.id("password"),"Password");
		entertext(pwd,password,"Password");
		WebElement login = findElement(By.id("submitButton"),"Login");
		clickobj(login,"Login");	
		
	}

}
