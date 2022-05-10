package Utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import PageObjects.HomePage;

import PageObjects.SearchResultPage;
import Utilities.ScreenShotRemoteWebDriver;

public class TestSuiteBase {

	public WebDriver driver;
	protected PageObjects.HomePage homepage;

	protected PageObjects.SearchResultPage searchresultpage;

	@Parameters({ "platform", "browser", "version", "url" })
	@BeforeClass(alwaysRun = true)
	public void setup(String platform, String browser, String version, String url) throws MalformedURLException {
		driver = getDriverInstance(platform, browser, version, url);
		homepage = PageFactory.initElements(driver, HomePage.class);
		searchresultpage = PageFactory.initElements(driver, SearchResultPage.class);
	}

	public static WebDriver getDriverInstance(String platform, String browser, String version, String url)
			throws MalformedURLException {

//Provide your hub ip or sauce lab credentials
		
//		String hubURL ="http://ec2-54-145-153-64.compute-1.amazonaws.com:4444/wd/hub";
		
//		Shah's local machine
//		String hubURL = "http://PF14H0VV.healthpn.com:4444/wd/hub";	
		
//		local selenium server
		String hubURL = "http://hp-5m8r3p4.healthpn.com:4444/wd/hub";
		

		WebDriver driver = new RemoteWebDriver(new URL(hubURL),  new ChromeOptions());
	
		// Maximize the browser's window
		driver.manage().window().maximize();
		
		// Open the Application
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
