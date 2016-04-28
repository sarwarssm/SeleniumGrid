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

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(css = "#search-form > fieldset > button > i")
	private WebElement wikiSearchButton;

	public void clickwikiSearchButton() {
		this.wikiSearchButton.click();
	}

	public void fillUpSearchBox(String searchString) {
		this.searchBox.clear();
		this.searchBox.sendKeys(searchString);
	}

}
