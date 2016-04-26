package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EmailBody {
	public WebDriver driver;

	public EmailBody(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h2[class='hP']")
	private WebElement subject;

	@FindBy(css = "div[class='nH aHU'] div[dir='ltr']")
	private WebElement body;

	public void checksubject(String expectedsubject) {
		String actualSubject = this.subject.getText();
		Assert.assertEquals(actualSubject, expectedsubject);
	}

	public void checkbody(String expectedbody) {
		String actualbody = this.body.getText();
		Assert.assertEquals(actualbody, expectedbody);
	}

}
