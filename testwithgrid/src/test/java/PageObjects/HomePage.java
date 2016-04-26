package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "next")
	private WebElement next;

	@FindBy(id = "Passwd")
	private WebElement password;

	@FindBy(id = "signIn")
	private WebElement signIn;

	public void fillUpEmail(String emailAddress) {
		this.email.clear();
		this.email.sendKeys(emailAddress);
	}

	public void clickNext() {
		this.next.click();
	}

	public void fillUpPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickSignIn() {
		this.signIn.click();

	}
}
