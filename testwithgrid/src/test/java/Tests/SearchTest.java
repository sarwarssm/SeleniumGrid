package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.TakeScreenshot;
import Utilities.GmailManager;
import Utilities.DataProviders;
import Utilities.TestSuiteBase;

public class SearchTest extends TestSuiteBase {

	/*
	 * Test Case: 1. Log into any email account and check if there is an email.
	 * 2. Verify that subject and body of the e-mail contains a pre-defined
	 * string. 3. Parameterize (data-drive) the script to handle multiple email
	 * accounts.
	 */
	private String OsBrowser = "";

	// @Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="emailLogin")
	@Test(priority = 1)
	public void searchTest() throws InterruptedException {

		OsBrowser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		homepage.fillUpSearchBox("milk");
		homepage.clickwikiSearchButton();
		Assert.assertEquals("Milk - Wikipedia, the free encyclopedia", driver.getTitle());
		Assert.assertEquals(searchresultpage.firstHeading(), "water");
		searchresultpage.fillUpSearchBox("water");
		searchresultpage.clickSearchButton();
		Assert.assertEquals("Water - Wikipedia, the free encyclopedia", driver.getTitle());

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {

				String s = result.getName() + "method has failed";
				TakeScreenshot screenShot = new TakeScreenshot();
				String attachment = screenShot.getScreenShot(this.driver, "emaillogin");
				GmailManager email = new GmailManager();
				email.sendEmailAtachment("SearchTest has failed :" + OsBrowser, s, attachment);

			} catch (Exception e) {
				String exep = e.toString();
				GmailManager email = new GmailManager();
				email.sendEmail("emailLogin has falied", exep);

			}
		}

	}
}