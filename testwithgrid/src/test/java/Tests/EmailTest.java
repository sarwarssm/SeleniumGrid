package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.EmailBody;
import PageObjects.HomePage;
import PageObjects.Inbox;
import Utilities.DataProviders;

public class EmailTest {

	/*
	 * Test Case:
	 * 1. Log into any email account and check if there is an email.
	 * 2. Verify that subject and body of the e-mail contains a pre-defined string.
	 * 3. Parameterize (data-drive) the script to handle multiple email accounts.
	 */
	
	private WebDriver driver;
	private String baseUrl;
	HomePage homepage;
	Inbox inbox;
	EmailBody emailBody;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.gmail.com";
		homepage = new HomePage(driver);
		inbox = new Inbox(driver);
		emailBody = new EmailBody(driver);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	// @Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="emailLogin")
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "EmailLoginFromCsv")
	public void TestLogin(String email, String password, String subject,String body) {
		homepage.fillUpEmail(email);
		homepage.clickNext();
		homepage.fillUpPassword(password);
		homepage.clickSignIn();
		inbox.clickEmail(0);
		emailBody.checksubject(subject);
		emailBody.checkbody(body);
		inbox.signOut();
		
		
	}

	@AfterTest
	public void tearDownOnFalilure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			driver.quit();
			
		}else {driver.quit();
			};
	
	}

}
