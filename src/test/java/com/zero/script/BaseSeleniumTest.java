package com.zero.script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zero.datasheet.ExcelData;

public class BaseSeleniumTest {
	ExcelData excelobj= new ExcelData("C:\\TrainingJAN19\\JAVAPGMS\\ZeroAutomation\\DataSheet.xlsx");
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest Logger;
	
	/* Name : Initialize Description - Initialize the driver and extent report
	 * Arguments reportfilename -filename to be created for the report
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void initialize(String browser) throws Exception {
		if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","Driver\\geckodriver.exe");		
			driver=new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");		
			driver=new ChromeDriver();
		}
		//else if (browser.equalsIgnoreCase("IE"))
		//{
			//System.setProperty("webdriver.ie.driver", "Driver\\IEDriverServer.exe");		
			//driver=new InternetExplorerDriver();
		//}

		else
		{
			throw new Exception ("Browser is not correct");
		}
		
		
	}
	/* Name : Launch Description - Launching the driver
	 * Arguments url-URL to be launched,text-text for starting the report
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void launch(String url) {
		
		driver.get(url);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void startreport(String text,String reportfilename)
	{

		String path = "user.dir" +"/test-output/"+ reportfilename;
		report = new ExtentReports(path);
		Logger = report.startTest(text);
	}

	/* Name : EnterText Description - Enter the text value in the object field
	 * Arguments Object-Name of the object value-value of the object ,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void entertext(WebElement element, String textvalue,String objname) {
		if (element == null)
			return;
		if (element.isDisplayed()) {
			element.sendKeys(textvalue);
			Logger.log(LogStatus.PASS,textvalue+" entered in "+objname);
		} else {
			Logger.log(LogStatus.FAIL,textvalue+" not entered in "+objname);
		}

	}
	/* Name : clickobj Description - Click the object
	 * Arguments element-Element to be clicked,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void clickobj(WebElement element,String objname) {
		if(element.isDisplayed()){
			if (element.isEnabled()) {
				element.click();
			
				Logger.log(LogStatus.PASS,objname +" button is clicked");
			}
		}
		 else {
			 Logger.log(LogStatus.FAIL,objname +" button is not clicked");
		}
		
	}

	/* Name : selectcheckbox Description - Select the checkbox
	 * Arguments element-element to be checked,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */ 
	public static void selectcheckbox(WebElement element,String objname) {
		if (element == null)
			return;
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				element.click();
			}

			Logger.log(LogStatus.PASS,objname +" is selected");
		}

		else {
			Logger.log(LogStatus.FAIL,objname +" is not selected");
		}
	}
     
	/* Name : findElement Description - Finding the element 
	 * Arguments Location-Location where the element to be checked,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static WebElement findElement(By location, String objname) {
		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			Logger.log(LogStatus.PASS,objname +" element is found");
		} catch (NoSuchElementException ex) {
			Logger.log(LogStatus.FAIL,objname +" element is not found");
		}
		return obj;
	}
     
	/* Name : MouseOverAction Description - Perform mouseover action on the element 
	 * Arguments element -Element where the action to be performed,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void mouseover(WebElement element,String objname) {
		Actions actionobj = new Actions(driver);
		if (element.isDisplayed()) {
			actionobj.moveToElement(element).build().perform();
			Logger.log(LogStatus.PASS," Mouseover Action performed on "+objname);
		} else {
			Logger.log(LogStatus.FAIL," Mouseover Action not  performed on "+objname);
		}

	}
    
	/* Name : DropdownSelectByvalue Description -Select the option from the dropdownmenu by value
	 * Arguments element -element where the action to perform,selvaue-value to be selected,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void dropdownSelectByValue(WebElement element, String selvalue,String objname) {
		if (element.isDisplayed()) {
			if(!(element.isSelected())){
			Select selobj = new Select(element);
			selobj.selectByValue(selvalue);
			Logger.log(LogStatus.PASS,objname+" is selected by value");
			}
		} else {
			Logger.log(LogStatus.FAIL,objname+" is not selected by value");
		}

	}
    
	/* Name : DropdownSelectByIndex Description -Select the option from the dropdownmenu by index
	 * Arguments element -element where the action to perform,selvalue-index to be selected,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void dropdownSelectByIndex(WebElement element, Integer selvalue,String objname) {
		if (element.isDisplayed()) {
			Select selobj = new Select(element);
			selobj.selectByIndex(selvalue);
			Logger.log(LogStatus.PASS,objname+" is selected by index");
		} else {
			Logger.log(LogStatus.FAIL,objname+"is not selected by index");
		}

	}
	
	/* Name : DropdownSelectByVisibleTextDescription -Select the option from the dropdownmenu by visibletext
	 * Arguments element -element where the action to perform,selvalue-visibletext to be selected,objname-Name of the object
	 * Created by : Rajalakshmi
	 * Created Date :21-03-3019 
	 * Last modified date :21-03-2019
	 */
	public static void dropdownSelectByVisibleText(WebElement element, String selvalue,String objname) {
		if (element.isDisplayed()) {
			Select selobj = new Select(element);
			selobj.selectByVisibleText(selvalue);
			Logger.log(LogStatus.PASS,objname+" is selected by visibletext");
		} else {
			Logger.log(LogStatus.FAIL,objname+"is not selected by visibletext");
		}

	}
	
	public String getCellData(int sheetno,int row,int column)
	{
		String data = excelobj.getdata(sheetno,row,column);
		return data;
	}
	public void quitdriver() throws InterruptedException
	{	
	Thread.sleep(5000);
	driver.quit();
	}
  public void  reportclose()
  {
	  report.endTest(Logger);
		report.flush();
  }
}
