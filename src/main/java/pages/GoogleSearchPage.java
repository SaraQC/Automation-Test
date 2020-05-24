package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends PageBase {

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input.gLFyf.gsfi")
	WebElement searchBoxTxt;

	public void doSearch(String SearchInput) {
		FillText(searchBoxTxt, SearchInput);
		searchBoxTxt.sendKeys(Keys.ENTER);
	}

}
