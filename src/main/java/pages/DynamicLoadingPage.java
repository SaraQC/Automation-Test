package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends PageBase {

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".example h3")
	public WebElement DynamicLoadHeader;

	@FindBy(css = "a[href='/dynamic_loading/2']")
	public WebElement Example2Link;

	@FindBy(css = "div#start button")
	public WebElement StartloadBtn;
	
	@FindBy(id="loading")
	public WebElement LoadingIcon;
	
	@FindBy(id="finish")
	public WebElement HelloTxt;

	public void openExample2() {

		ClickButton(Example2Link);

	}

	public void startloading() {

		ClickButton(StartloadBtn);

	}

}
