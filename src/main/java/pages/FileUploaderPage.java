package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploaderPage extends PageBase {

	public FileUploaderPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".example h3")
	public WebElement UploaderHeader;
	
	@FindBy(id="file-upload")
	WebElement ChooseFileBtn;
	
	@FindBy(id="file-submit")
	WebElement UploadFileBtn;
	
	
	public void uploadFileBySendkeys(String image) {
		
		FillText(ChooseFileBtn, image);
		ClickButton(UploadFileBtn);
		
	}

}


