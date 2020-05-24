package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;
	public JavascriptExecutor js;

	public PageBase(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public static void ClickButton(WebElement Button) {
		Button.click();

	}

	public static void FillText(WebElement TextBox, String Value) {
		TextBox.sendKeys(Value);

	}

	public void ScrollToTheEnd() {

		js.executeScript("scrollBy(0,2500)");
	}

}
