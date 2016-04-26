package Tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.TakeScreenshot;
import Utilities.GmailManager;
import Utilities.DataProviders;
import Utilities.TestSuiteBase;

public class EmailTestwithgrid extends TestSuiteBase {

	/*
	 * Test Case: 1. Log into any email account and check if there is an email.
	 * 2. Verify that subject and body of the e-mail contains a pre-defined
	 * string. 3. Parameterize (data-drive) the script to handle multiple email
	 * accounts.
	 */

	@BeforeClass
	public void beforeClass() {

	}
	private String OsBrowser = "";
	// @Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="emailLogin")
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "EmailLoginFromCsv")
	public void TestLogin(String email, String password, String subject, String body) {
		
		OsBrowser = (String) ((JavascriptExecutor) driver)
				.executeScript("return navigator.userAgent;");
		homepage.fillUpEmail(email);
		homepage.clickNext();
		homepage.fillUpPassword(password);
		homepage.clickSignIn();
		inbox.clickEmail(0);
		emailbody.checksubject(subject);
		emailbody.checkbody(body);
		inbox.signOut();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {

				String s = result.getName() + "method has failed";
				TakeScreenshot screenShot = new TakeScreenshot();
				String attachment = screenShot.getScreenShot(this.driver, "emaillogin");
				GmailManager email = new GmailManager();
				email.sendEmailAtachment("emailLogin has failed :" + OsBrowser, s, attachment);

			} catch (Exception e) {
				String exep = e.toString();
				GmailManager email = new GmailManager();
				email.sendEmail("emailLogin has falied", exep);

			}
		}

	}
}