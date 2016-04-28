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
		String hubURL = "http://192.168.1.2:4444/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();

		// Platforms
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}
		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}

		if (browser.equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		}
		// Version
		caps.setVersion(version);
		driver = new ScreenShotRemoteWebDriver(new URL(hubURL), caps);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Open the Application
		driver.get(url);
		return driver;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}