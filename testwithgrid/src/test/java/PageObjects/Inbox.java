package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inbox {
	public WebDriver driver;

	public Inbox(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='y6'] span[id] b")
	private List<WebElement> emails;

	@FindBy(css = "span.gb_2a")
	private WebElement personLogo;

	@FindBy(id = "gb_71")
	private WebElement signout;

	public void clickEmail(int n) {
		this.emails.get(n).click();
	}

	public void signOut() {
		this.personLogo.click();
		this.signout.click();

	}
}
