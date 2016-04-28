package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {
	public WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(name = "go")
	private WebElement searchButton;

	@FindBy(css = "#firstHeading ")
	private WebElement firstHead;

	public void clickSearchButton() {
		this.searchButton.click();
	}

	public void fillUpSearchBox(String searchString) {
		this.searchBox.clear();
		this.searchBox.sendKeys(searchString);
	}

	public String firstHeading() {
		String heading = firstHead.getText().toString();
		System.out.println(heading);
		return heading;
	}

}
