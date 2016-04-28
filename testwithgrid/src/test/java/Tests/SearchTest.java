package Tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Utilities.TakeScreenshot;
import Utilities.GmailManager;
import Utilities.DataProviders;
import Utilities.TestSuiteBase;

public class SearchTest extends TestSuiteBase {

	private String OsBrowser = "";

	@Test(priority = 1)
	public void blankresultPage() {
		OsBrowser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		homepage.clickwikiSearchButton();
		Assert.assertEquals(driver.getTitle(), "Search - Wikipedia, the free encyclopedia");
	}

	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "searchKeyAndHeading")
	public void firstSearchTest(String searchKey, String heading) throws InterruptedException {
		OsBrowser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		searchresultpage.fillUpSearchBox(searchKey);
		searchresultpage.clickSearchButton();
		Assert.assertEquals(searchresultpage.firstHeading(), heading);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {
				String error = "Reason of Failure :\n" + result.getThrowable();
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