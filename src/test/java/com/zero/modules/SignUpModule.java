package com.zero.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zero.script.BaseSeleniumTest;

public class SignUpModule extends BaseSeleniumTest {

	public void launchurl() throws InterruptedException
	{
		launch("https://www.xero.com/us/");
		Thread.sleep(5000);
		
	}
	public void signUp(String FN,String LN,String EmailId,String PNO,String Ctry) throws InterruptedException
	{
		WebElement trial= findElement(By.linkText("Free trial"),"Free Trial ");
		clickobj(trial,"Free Trial");
		WebElement firstName=findElement(By.name("FirstName"),"First Name");
		entertext(firstName,FN,"First Name");
		WebElement lastName=findElement(By.name("LastName"),"Last Name");
		entertext(lastName,LN,"Last Name");
		WebElement id=findElement(By.name("EmailAddress"),"Email Address");
		entertext(id,EmailId,"Email Address");
		WebElement phone = findElement(By.name("PhoneNumber"),"Phone Number");
		entertext(phone,PNO,"Phone Number");
		Thread.sleep(5000);
		WebElement country=findElement(By.xpath("//select[@name='LocationCode']"),"Country");
		dropdownSelectByValue(country,Ctry,"Country");
		Thread.sleep(5000);
		//WebElement clickcaptcha=findElement(By.xpath("//body[@class='xero is-live-mode']"),"Captcha click");
		//clickobj(clickcaptcha,"Click captcha");
		Thread.sleep(5000);
		WebElement checkbox = findElement(By.xpath("//input[@value='true']"),"Check box");
		selectcheckbox(checkbox,"Check Box");
		Thread.sleep(5000);
		WebElement start = findElement(By.xpath("//span[@class='g-recaptcha-submit']")," Get Started");
		clickobj(start,"Get started");	
		Thread.sleep(5000);
		
	}
}
