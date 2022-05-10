package Utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	public String date = new java.util.Date().toString();
	
	// use your desired path where do you want to save screenshots in the jenkins server
	public String path = "C:\\selenium_logs\\Screenshots\\";	
															
	WebDriver driver = null;

	public String getScreenShot(WebDriver d, String fileName) {
		File screenshot = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String filePath = "";
		try {
			date = date.replace(':', '.');
			String tmp = d.toString();
			tmp = tmp.substring(0, tmp.indexOf(':'));
			FileUtils.copyFile(screenshot, new File(path + tmp + " " + fileName + date + ".png"));
			filePath = new File(path + tmp + " " + fileName + date + ".png").toString();
			
		} catch (IOException e) {
			System.out.println("Unable to take screenshot #1 TakeScreenshot.java");
			e.printStackTrace();
		}
		return filePath;
	}

}
