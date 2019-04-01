package com.zero.script;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.zero.modules.LoginModule;
import com.zero.modules.SignUpModule;

public class AutomationScript extends BaseSeleniumTest{
	LoginModule loginobj=new LoginModule();
	SignUpModule signobj= new SignUpModule();
	SoftAssert softassert = new SoftAssert();
	@BeforeTest
	@Parameters("browser")
	public void initializedriver(String browser) throws Exception
	{
		initialize(browser);
	}
	
	/*TC01-Navigate to SFDC
	 *Launch App
     *Enter User Name
	 *Enter Password
	 *Click on Log in button
	 */
	@Test(enabled=true)
	public void TC01_NavigatetozeroValidCredientials() throws InterruptedException	
	{
		loginobj.launchurl();
		startreport("Test case 1 started","Report1.html");
		String Un=excelobj.getdata(0,1,1);
		String pwd=excelobj.getdata(0, 1, 2);
		loginobj.login(Un,pwd);
		WebElement act = findElement(By.xpath("//button[@title='Rajalakshmi Velmurugan']"),"Title");
		String actual = act.getText();
		String expected = excelobj.getdata(0,1,3);
		softassert.assertEquals(actual,expected);
		quitdriver();	
		reportclose();
	}
	
	/*TC01B
	 * Launch App
       Enter User Name
       Enter wrong Password
       Click on Log in button

	 */
	@Test(enabled=false)
	public void TC01A_NavigatetoZeroInvalidPwd() throws InterruptedException
	{
		loginobj.launchurl();
		startreport("Test case 1B started","Report2.html");
		String Un=excelobj.getdata(0,2,1);
		String pwd=excelobj.getdata(0, 2, 2);
		loginobj.login(Un,pwd);
		WebElement act = findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"),"ErrorMessage");
		String actual = act.getText();
		String expected = excelobj.getdata(0,2,3);
		softassert.assertEquals(actual,expected);
		quitdriver();	
		reportclose();
	}
	/*TC01C
	 * Launch App
	   Enter User Name
       Enter Password
       Click on Log in button
	 */
	@Test(enabled=false)
	public void TC01C_NavigatetoZeroInvalidEmailId() throws InterruptedException
	{
		loginobj.launchurl();
		startreport("Test case 1C started","Report3.html");
		String Un=excelobj.getdata(0,3,1);
		String pwd=excelobj.getdata(0,3,2);
		loginobj.login(Un,pwd);
		WebElement act = findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"),"ErrorMessage");
		String actual = act.getText();
		String expected = excelobj.getdata(0,3,3);
		softassert.assertEquals(actual,expected);
		quitdriver();	
		reportclose();
		
	}
	
	/*TCO1D Launch App
	Click on Forgot password
	Test Forgot password*/
	@Test(enabled=false)
	public void TC01D_NavigatetoZeroForgotPassword() throws InterruptedException
	{
		loginobj.launchurl();
		startreport("Test case 1D started","Report4.html");
		WebElement link = findElement(By.xpath("//a[@class='forgot-password-advert']"),"Forgot Password");
		clickobj(link,"Forgot Password ");
		WebElement email = findElement(By.xpath("//input[@name='UserName']"),"Email Id");
		String id = excelobj.getdata(0,4,1);
		entertext(email,id,"Email Id ");
		WebElement sendlink=findElement(By.xpath("//span[@class='text']"),"Send LInk");
		clickobj(sendlink,"Send Link");
		WebElement message= findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/p[1]"),"Message");
		String actual= message.getText();
		String expected = excelobj.getdata(0,4,3);
		softassert.assertEquals(actual,expected);
		quitdriver();	
		reportclose();
		
	}
	
	/*TC02ALaunch App
Click on FREE TRIAL icon
Enter First Name
Enter Last Name
Enter Email Address
Enter Phone number
Select Country from the List Box
Select Terms and policy in the check box
Click Get started Button
*/
@Test(enabled=false)
public void TC02A_SignupFullDetails() throws InterruptedException
{
	signobj.launchurl();
	startreport("Test case 2A started","Report5.html");
	String FirName=excelobj.getdata(1,1,1);
	String LasName=excelobj.getdata(1,1,2);
	String EmailAdd=excelobj.getdata(1,1,3);
	String PhoneNO=excelobj.getdata(1,1,4);
	String Coun=excelobj.getdata(1,1,5);
	signobj.signUp(FirName,LasName,EmailAdd,PhoneNO,Coun);
	quitdriver();	
	reportclose();		
}
/*Launch App
Click on FREE TRIAL icon
Click Get Started Button without fill any field
Enter the Email address in wrong format
Click the Get Started Button without select the term and policy checkbox
*/
@Test(enabled=false)
public void TC02B_Signup() throws InterruptedException
{
	signobj.launchurl();
	startreport("Test case 2B started","Report6.html");
	WebElement start = findElement(By.xpath("//span[@class='g-recaptcha-submit']")," Get Started");
	clickobj(start,"Get started");	
	String FirName=excelobj.getdata(1,2,1);
	String LasName=excelobj.getdata(1,2,2);
	String EmailAdd=excelobj.getdata(1,2,3);
	String PhoneNO=excelobj.getdata(1,2,4);
	String Coun=excelobj.getdata(1,2,5);
	signobj.signUp(FirName,LasName,EmailAdd,PhoneNO,Coun);
	WebElement message = findElement(By.xpath("//span[@id='signup-form-error-message-1']"),"Error Message");
	String actual=message.getText();
	String expected= excelobj.getdata(1,2,6);
	softassert.assertEquals(actual,expected);
	quitdriver();	
	reportclose();	
}

/*Launch App
Click on FREE TRIAL icon
Click the terms of use link
Click the privacy policy link
 */
@Test(enabled=false)
public void TC02C_SignupDetails() throws InterruptedException
{
	ArrayList<String> windows;
	signobj.launchurl();
	startreport("Test case 2C started","Report7.html");
	WebElement trial= findElement(By.linkText("Free trial"),"Free Trial ");
	clickobj(trial,"Free Trial");
	WebElement termsofuse=findElement(By.linkText("terms of use"),"Terms of Use");
	clickobj(termsofuse,"Terms of use");
	 windows=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(windows.get(1)); 
	String actual=driver.getTitle();
	String expected = "Terms of use | Xero US";
	softassert.assertEquals(actual,expected);
	driver.switchTo().window(windows.get(0));
	WebElement privacy = findElement(By.linkText("privacy notice"),"Privacy Notice");
	clickobj(privacy,"Privacy notice ");	
	 windows=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(windows.get(2)); 
	String actual1=driver.getTitle();
	System.out.println(actual1);
	String expected1 = "Privacy notice | Xero US";
	softassert.assertEquals(actual1, expected1);
	quitdriver();	
	reportclose();	
}
/*Launch App
Click on FREE TRIAL icon
click "See full Offer Details" link
*/
@Test(enabled=false)
public void TC02D_SignupOfferDetails() throws InterruptedException
{
	signobj.launchurl();
	startreport("Test case 2D started","Report8.html");
	WebElement trial= findElement(By.linkText("Free trial"),"Free Trial ");
	clickobj(trial,"Free Trial");	
	WebElement offer = findElement(By.linkText("offer details"),"Offer Details");
	clickobj(offer,"Offer Details");
	Thread.sleep(5000);	
	ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(windows.get(1)); 
	String actual=driver.getTitle();	
	String expected = "Offer details | Xero US";	
	Assert.assertEquals(actual,expected);
	quitdriver();	
	reportclose();
	
}
/*Launch App
Click on FREE TRIAL icon
click "accountant or bookkeeper" link*/
@Test(enabled=false)
public void TC02E_SignupAccountantorBookKeeper() throws InterruptedException
{
	signobj.launchurl();
	startreport("Test case 2E started","Report9.html");
	WebElement trial= findElement(By.linkText("Free trial"),"Free Trial ");
	clickobj(trial,"Free Trial");
	WebElement acc = findElement(By.linkText("accountant or bookkeeper"),"Accountant or Bookkeeper");
	clickobj(acc,"Bookkeeper or Accountant");		
	String actual=driver.getTitle();
	System.out.println(actual);
	String expected = "Sign up for the Xero Partner Program | Xero US";
	softassert.assertEquals(actual,expected);
	quitdriver();	
	reportclose();
	
}
/*launch xero application
Enter User Name
enter Password field
Login to xero
 dash board
accounts
report
contacts
settings
"+"/new
files
notification
search
?/help 
 */
@Test(enabled=false)
public void TC03_CheckAllTabs()
{
	loginobj.launchurl();
	startreport("Test case 3 started","Report10.html");
	String Un=excelobj.getdata(0,1,1);
	String pwd=excelobj.getdata(0, 1, 2);
	loginobj.login(Un,pwd);
	WebElement dashboard = findElement(By.linkText("Dashboard"),"DashBoard");
	clickobj(dashboard,"Dash Board");
	WebElement accounts= findElement(By.xpath("//button[contains(text(),'Accounting')]"),"Accounting");
	clickobj(accounts,"Accounting ");
	WebElement business=findElement(By.xpath("//button[contains(text(),'Business')]"),"Business");
	clickobj(business,"Business");
	WebElement contact = findElement(By.xpath("//button[contains(text(),'Contacts')]"),"Contacts");
	clickobj(contact,"Contacts");
	WebElement setting= findElement(By.linkText("Settings"),"Settings");
	clickobj(setting,"Settings");
	WebElement add= findElement(By.linkText("Add a new organization"),"Add new organisation");
	clickobj(add,"Add new Organisation");
	WebElement file= findElement(By.linkText(""),"Settings");
	clickobj(setting,"Settings");		
}
/*Launch App
Login to xero
Logout from xero
Check for Username field
*/
@Test(enabled=false)
public void TC04_logout() throws InterruptedException
{
	loginobj.launchurl();
	startreport("Test case 4 started","Report11.html");
	String Un=excelobj.getdata(0,1,1);
	String pwd=excelobj.getdata(0, 1, 2);
	loginobj.login(Un,pwd);
	WebElement profile=findElement(By.xpath("//button[@title='Rajalakshmi Velmurugan']//div[@class='xrh-focusable--child xrh-iconwrapper'] "),"Profile");
	clickobj(profile,"Profile");
	WebElement logout =findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]"),"Logout");
	clickobj(logout,"Logout");
	quitdriver();	
	reportclose();	
}

}