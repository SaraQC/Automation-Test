package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.FileUploaderPage;
import pages.TheInternetListPage;

public class FileUploaderTest extends TestBase {

	TheInternetListPage InternetListObj;
	FileUploaderPage UploaderObj;
	FileUploaderPage FileUploaderObj;

	@DataProvider(name = "FileProvider")
	public static Object[][] invalidAdminLoginData() throws IOException {

		ExcelReader ER = new ExcelReader();
		return ER.getExcelData(2, 1);
	}

	@Test()
	public void verifyOpeningFileUploaderPage() {

		InternetListObj = new TheInternetListPage(driver);
		UploaderObj = new FileUploaderPage(driver);

		wait = new WebDriverWait(driver, 60, 10);

		driver.navigate().to("https://the-internet.herokuapp.com/");
		wait.until(ExpectedConditions.visibilityOf(InternetListObj.PageHeader));

		scrollToFindElement(InternetListObj.UploadFileLink);
		InternetListObj.openUploadFile();

		wait.until(ExpectedConditions.urlContains("upload"));

		boolean HeaderText = UploaderObj.UploaderHeader.getText().contains("File Uploader");
		assertTrue(HeaderText, "Can't navigate to File Upload page. ");

	}

	@Test(dataProvider = "FileProvider")
	public void verifyUploadingFile(String Image) throws InterruptedException {

		UploaderObj = new FileUploaderPage(driver);
		FileUploaderObj = new FileUploaderPage(driver);

		UploaderObj.uploadFileBySendkeys(Image);

		boolean HeaderText = FileUploaderObj.UploaderHeader.getText().contains("File Uploaded!");
		assertTrue(HeaderText, "Failed to upload the file. ");

	}

}
