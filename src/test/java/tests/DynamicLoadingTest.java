package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.DynamicLoadingPage;
import pages.FileUploaderPage;
import pages.TheInternetListPage;

public class DynamicLoadingTest extends TestBase {

	TheInternetListPage InternetListObj;
	FileUploaderPage UploaderObj;
	DynamicLoadingPage DynamicObj;
	String Hello = "Hello World!";

	@Test
	public void verifyOpeningDynamicLoadingPage() {

		InternetListObj = new TheInternetListPage(driver);
		DynamicObj = new DynamicLoadingPage(driver);
		wait = new WebDriverWait(driver, 60, 10);

		driver.navigate().to("https://the-internet.herokuapp.com/");
		wait.until(ExpectedConditions.visibilityOf(InternetListObj.PageHeader));

		scrollToFindElement(InternetListObj.DynamicLoadingLink);
		InternetListObj.openDynamicLoading();

		wait.until(ExpectedConditions.urlContains("dynamic_loading"));

		boolean HeaderText = DynamicObj.DynamicLoadHeader.getText().contains("Dynamically Loaded Page Elements");
		assertTrue(HeaderText, "Can't navigate to Dynamic Loading page. ");

	}

	@Test
	public void verifyNavigatingToDynamicLoagingExample2() throws InterruptedException {

		DynamicObj = new DynamicLoadingPage(driver);
		wait = new WebDriverWait(driver, 60, 10);

		DynamicObj.openExample2();

		wait.until(ExpectedConditions.visibilityOf(DynamicObj.StartloadBtn));

	}

	@Test
	public void verifyStartingTheDynamicLoadging() throws InterruptedException {

		DynamicObj = new DynamicLoadingPage(driver);
		wait = new WebDriverWait(driver, 60, 10);

		DynamicObj.startloading();

		wait.until(ExpectedConditions.invisibilityOf(DynamicObj.LoadingIcon));

		boolean FinishLoading = DynamicObj.HelloTxt.getText().contains(Hello);
		assertTrue(FinishLoading, "Failed to finish the dynamic loading. ");

	}

}
