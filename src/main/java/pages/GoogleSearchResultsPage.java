package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchResultsPage extends PageBase {

	public GoogleSearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "result-stats")
	public WebElement ResultStats;

	@FindBy(css = "div:nth-of-type(4) > .rc .DKV0Md.LC20lb, #rso > div:nth-child(11) > div > div.s")
	public WebElement ThirdResult;

}
