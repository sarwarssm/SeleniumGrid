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

	private String OsBrowser = "";

	// @Test(priority=1,dataProviderClass=DataProviders.class,dataProvider="emailLogin")
	@Test(priority = 1)
	public void firstSearchTest() throws InterruptedException {
		OsBrowser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		homepage.fillUpSearchBox("Albor");
		homepage.clickwikiSearchButton();
		Assert.assertEquals("Albor - Wikipedia, the free encyclopedia", driver.getTitle());
		Assert.assertEquals(searchresultpage.firstHeading(), "Albor");
	}

	@Test(priority = 2)
	public void secondSearchTest() throws InterruptedException {
		OsBrowser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		searchresultpage.fillUpSearchBox("Sonie");
		searchresultpage.clickSearchButton();
		Assert.assertEquals("Sonie - Wikipedia, the free encyclopedia", driver.getTitle());
		Assert.assertEquals(searchresultpage.firstHeading(), "Sonia");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {
				String error = "Reason of Failure :\n" +result.getThrowable();
				TakeScreenshot screenShot = new TakeScreenshot();
				String attachment = screenShot.getScreenShot(this.driver, "emaillogin");
				GmailManager email = new GmailManager();
				email.sendEmailAtachment("SearchTest has failed :" + OsBrowser, error, attachment);

			} catch (Exception e) {
				String exep = e.toString();
				GmailManager email = new GmailManager();
				email.sendEmail("SearchTest has falied", exep);

			}
		}

	}
}