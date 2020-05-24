package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheInternetListPage extends PageBase {

	public TheInternetListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className="heading")
	public WebElement PageHeader;

	@FindBy(css = "a[href='/upload']")
	public WebElement UploadFileLink;
	
	@FindBy(css = "a[href='/dynamic_loading']")
	public WebElement DynamicLoadingLink;

	public void openUploadFile() {
		ClickButton(UploadFileLink);
	}
	
	public void openDynamicLoading() {
		ClickButton(DynamicLoadingLink);
	}

}
