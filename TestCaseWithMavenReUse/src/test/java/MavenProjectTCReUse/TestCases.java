package MavenProjectTCReUse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TestCases extends reUsableFunction
{

	public static void main(String[] args) throws InterruptedException 
	{
		TestCases AllTC = new TestCases();
		String path="C:\\Users\\Nilay\\ExtentReports\\MavenTCReports.html";
		InitializePath(path);

		AllTC.TestCase1();
		AllTC.TestCase2();
		AllTC.TestCase3();
		AllTC.TestCase4a();
		AllTC.TestCase4b();
		AllTC.TestCase5();


		report.flush();
		System.out.println("End");
		//		EndReport();
	}

	public void TestCase1() throws InterruptedException
	{
		System.out.println("TestCase1");
		logger = report.startTest("Navigate to SFDC");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://login.salesforce.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Salesforce";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," Salesforce page is displayed.");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," Salesforce page is not displayed.");
		}

		WebElement un = findElement(By.xpath("//input[@id='username']"), "User Name");
		EnterText(un,"User Name", "nilay92000@yahoo.com");
		if(un.isDisplayed())
		{	
			logger.log(LogStatus.PASS, " UserName is displayed in User name field");
		}
		else
		{
			logger.log(LogStatus.FAIL, " UserName is not displayed in User name field");
		}

		Thread.sleep(2000);
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		EnterText(pass,"Password", "mnshah@09");
		if(pass.isDisplayed())
		{
			ClearText(pass);
			//pass.clear();
			logger.log(LogStatus.PASS, " Password is displayed and got cleared.");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Password is not displayed and did not cleared");
		}

		WebElement Login = findElement(By.xpath("//input[@id='Login']"),"Login");
		click_On_Button(Login, "Login");

		WebElement ErrorMsg = findElement(By.xpath("//div[@id='error']"), "Error Message");
		System.out.println(ErrorMsg.getText());
		if(ErrorMsg.isDisplayed())
		{
			logger.log(LogStatus.PASS, " Error Message: Please enter your password. Displayed.");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Error Message: Please enter your password. is not Displayed.");
		}

		driver.close();
		report.endTest(logger);
		//		EndReport();
	}

	public void TestCase2() throws InterruptedException
	{
		System.out.println("TestCase2");
		logger = report.startTest("Login to SFDC");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://login.salesforce.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Salesforce";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," SFDC login page is opened");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," SFDC login page is not opened");
		}

		WebElement un = findElement(By.xpath("//input[@id='username']"), "User Name");
		EnterText(un,"User Name", "nilay92000@yahoo.com");
		if(un.isDisplayed())
		{	
			logger.log(LogStatus.PASS, " UserName is displayed in User name field");
		}
		else
		{
			logger.log(LogStatus.FAIL, " UserName is not displayed in User name field");
		}

		Thread.sleep(2000);
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		EnterText(pass,"Password", "mnshah@09");
		if(pass.isDisplayed())
		{
			logger.log(LogStatus.PASS, " Password is displayed.");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Password is not displayed.");
		}

		WebElement Login = findElement(By.xpath("//input[@id='Login']"),"Login");
		if(Login.isDisplayed())
		{
			click_On_Button(Login, "Login");
			String actTitle = driver.getTitle();
			String expTitle = "Salesforce - Essentials Edition";
			if(actTitle.equalsIgnoreCase(expTitle))
			{
				System.out.println("Title Matched");
				//				logger.log(LogStatus.PASS," SFDC login page is opened");
				logger.log(LogStatus.PASS, "Welcome to your free trial displayed");
			}

			else
			{
				System.out.println("Title didn't match");
				logger.log(LogStatus.FAIL," Error Message: Please check your username and password. Displayed.");
			}
		}
		else
		{
			logger.log(LogStatus.FAIL, "Welcome to your free trial is not displayed");
		}

		driver.close();
		report.endTest(logger);
		//		EndReport();
	}

	public void TestCase3() throws InterruptedException
	{
		System.out.println("TestCase3");
		logger = report.startTest("Test the remember username check box ");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://login.salesforce.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Salesforce";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," SFDC login page is opened");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," SFDC login page is not opened");
		}

		WebElement un = findElement(By.xpath("//input[@id='username']"), "User Name");
		EnterText(un,"User Name", "nilay92000@yahoo.com");

		Thread.sleep(2000);
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		EnterText(pass,"Password", "mnshah@09");

		WebElement RememberMe = findElement(By.xpath("//input[@id='rememberUn']"), "Remember Me");
		SelectCheckBox(RememberMe, "Remember Me");

		WebElement Login = findElement(By.xpath("//input[@id='Login']"),"Login");
		click_On_Button(Login, "Login");

		String actlogTitle = driver.getTitle();
		String explpgTitle = "Salesforce - Essentials Edition";
		if(actlogTitle.equalsIgnoreCase(explpgTitle))
		{
			System.out.println("Login Title Matched");
			logger.log(LogStatus.PASS," Sales force home page is displayed");
		}
		else
		{
			System.out.println("Login Title didn't match");
			logger.log(LogStatus.FAIL," Sales force home page is not displayed");
		}

		WebElement UserMenu = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		click_On_Button(UserMenu, "User Menu");

		WebElement Logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		click_On_Button(Logout, "Logout");

		Thread.sleep(2000);
		WebElement untext = findElement(By.xpath("//span[@id='idcard-identity']"), "UserName Text");
		String actualun = untext.getText();
		String expectedun = "nilay92000@yahoo.com";
		if(!(actualun.isEmpty()))
		{
			if(actualun.equals(expectedun))
			{
				System.out.println("UserName Matched");
				logger.log(LogStatus.PASS," Login sales force page is displayed with username populated");
			}	
		}
		else
		{
			System.out.println("UserName didn't match");
			logger.log(LogStatus.FAIL," Login sales force page is displayed with username populated");
		}

		WebElement remember = findElement(By.xpath("//input[@id='rememberUn']"), "RememberMe");
		if(remember.isSelected())
		{
			logger.log(LogStatus.PASS, "Login sales force page is checked with remember user name");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Login sales force page is not checked with remember user name");
		}

		driver.close();
		report.endTest(logger);
	}

	public void TestCase4a() throws InterruptedException
	{
		System.out.println("TestCase4a");
		logger = report.startTest("Test forgot password");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://login.salesforce.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Salesforce";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," SFDC login page is opened");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," SFDC login page is not opened");
		}

		WebElement forgotpw = findElement(By.linkText("Forgot Your Password?"), "Forgot Password");
		if(forgotpw.isDisplayed())
		{

			click_On_Link(forgotpw, "Forgot Password");
			logger.log(LogStatus.PASS, "Salesforce forgot password page is displayed.");

		}
		else
		{
			logger.log(LogStatus.FAIL, "Salesforce forgot password page isnot displayed.");
		}

		WebElement forgetUn = findElement(By.xpath("//input[@id='un']"), "Username for forgot");
		EnterText(forgetUn, "Username for forgot", "nilay92000@yahoo.com");

		WebElement continues = findElement(By.xpath("//input[@id='continue']"), "Continue");
		if(continues.isDisplayed())
		{
			click_On_Button(continues, "Continue");
			logger.log(LogStatus.PASS, "Password reset message page is displayed.");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Password reset message page is not displayed.");
		}
		driver.close();
		report.endTest(logger);
	}

	public void TestCase4b() throws InterruptedException
	{
		System.out.println("TestCase4b");
		logger = report.startTest("Validate Login Error Message");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://login.salesforce.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Salesforce";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," SFDC login page is opened");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," SFDC login page is not opened");
		}

		WebElement un = findElement(By.xpath("//input[@id='username']"), "User Name");
		EnterText(un,"User Name", "nilay9200@yahoo.com");
		if(un.isDisplayed())
		{	
			logger.log(LogStatus.PASS, " UserName is displayed in User name field");
		}
		else
		{
			logger.log(LogStatus.FAIL, " UserName is not displayed in User name field");
		}

		Thread.sleep(2000);
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		EnterText(pass,"Password", "mnshh@09");
		if(pass.isDisplayed())
		{
			logger.log(LogStatus.PASS, " Password is displayed.");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Password is not displayed.");
		}

		WebElement Login = findElement(By.xpath("//input[@id='Login']"),"Login");
		click_On_Button(Login, "Login");

		String actlogTitle = driver.getTitle();
		String explpgTitle = "Salesforce - Essentials Edition";
		if(actlogTitle.equalsIgnoreCase(explpgTitle))
		{
			System.out.println("Login Title Matched");
			logger.log(LogStatus.FAIL," Sales force home page is displayed");
		}
		else
		{
			System.out.println("Login Title didn't match");
			logger.log(LogStatus.PASS," Sales force home page is not displayed");
		}

		WebElement ErrorMsg = findElement(By.xpath("//div[@id='error']"), "Error Message");
		System.out.println(ErrorMsg.getText());
		if(ErrorMsg.isDisplayed())
		{
			logger.log(LogStatus.PASS, " Error Message: UserName or Password may be incorrect. Displayed.");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Error Message: UserName or Password may be incorrect. is not Displayed.");
		}

		driver.close();
		report.endTest(logger);
	}

	public void TestCase5() throws InterruptedException
	{
		System.out.println("TestCase5");
		logger = report.startTest("Select user menu for <username> dropdown");
		InitializeDriver();
		logger.log(LogStatus.INFO, "Chrome browser Launched.");
		Launch("https://login.salesforce.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Salesforce";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			logger.log(LogStatus.PASS," SFDC login page is opened");
		}
		else
		{
			System.out.println("Title didn't match");
			logger.log(LogStatus.FAIL," SFDC login page is not opened");
		}

		WebElement un = findElement(By.xpath("//input[@id='username']"), "User Name");
		EnterText(un,"User Name", "nilay92000@yahoo.com");

		Thread.sleep(2000);
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		EnterText(pass,"Password", "mnshah@09");

		WebElement RememberMe = findElement(By.xpath("//input[@id='rememberUn']"), "Remember Me");
		SelectCheckBox(RememberMe, "Remember Me");

		WebElement Login = findElement(By.xpath("//input[@id='Login']"),"Login");
		click_On_Button(Login, "Login");

		String actlogTitle = driver.getTitle();
		String explpgTitle = "Salesforce - Essentials Edition";
		if(actlogTitle.equalsIgnoreCase(explpgTitle))
		{
			System.out.println("Login Title Matched");
			logger.log(LogStatus.PASS," Sales force home page is displayed");
		}
		else
		{
			System.out.println("Login Title didn't match");
			logger.log(LogStatus.FAIL," Sales force home page is not displayed");
		}

		WebElement UserMenu = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		click_On_Button(UserMenu, "User Menu");
		if(UserMenu.isDisplayed())
		{
			logger.log(LogStatus.PASS, "User menu drop down is available");
		}
		else
		{
			logger.log(LogStatus.FAIL, "User menu drop down is not available");
		}

		Thread.sleep(2000);
		WebElement ProfileLbl = findElement(By.xpath("//a[contains(@title,'My Profile')]"), "My Profile");
		if(ProfileLbl.isDisplayed())
		{
			logger.log(LogStatus.PASS, " My Profile Option is displayed in dropdown list");
		}
		else
		{
			logger.log(LogStatus.FAIL, " My Profile Option is not displayed in dropdown list");
		}

		WebElement SettingLbl = findElement(By.xpath("//a[contains(@title,'My Settings')]"), "My Settings");
		if(SettingLbl.isDisplayed())
		{
			logger.log(LogStatus.PASS, " My Settings Option is displayed in dropdown list");
		}
		else
		{
			logger.log(LogStatus.FAIL, " My Settings Option is not displayed in dropdown list");
		}

		WebElement DevConsoleLbl = findElement(By.xpath("//a[contains(@title,'Developer Console (New Window)')]"), "Developer Console");
		if(DevConsoleLbl.isDisplayed())
		{
			logger.log(LogStatus.PASS, " Developer Console Option is displayed in dropdown list");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Developer Console Option is not displayed in dropdown list");
		}
		WebElement LogoutLbl = findElement(By.xpath("//a[contains(@title,'Logout')]"), "Logout");
		if(LogoutLbl.isDisplayed())
		{
			logger.log(LogStatus.PASS, " Logout Option is displayed in dropdown list");
		}
		else
		{
			logger.log(LogStatus.FAIL, " Logout Option is not displayed in dropdown list");
		}

		driver.close();
		report.endTest(logger);
	}

}


