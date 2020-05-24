package tests;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultsPage;

public class GoogleSearchTest extends TestBase {

	GoogleSearchPage SearchObj;
	GoogleSearchResultsPage SearchResObj;

	@DataProvider(name = "SearchData")
	public static Object[][] invalidAdminLoginData() throws IOException {

		// Get data from excel reader class
		ExcelReader ER = new ExcelReader();

		/*
		 * get excel data method takes two parameters (sheet's no start from 0, total
		 * number of columns start from 1)
		 */
		return ER.getExcelData(0, 1);
	}

	@Test(dataProvider = "SearchData")
	public void verifySearchResults(String SearchInput) {

		//test = report.startTest("GoogleSearchTest");
		
		SearchObj = new GoogleSearchPage(driver);
		SearchResObj = new GoogleSearchResultsPage(driver);

		wait = new WebDriverWait(driver, 60, 10);

		SearchObj.doSearch(SearchInput);
		//test.log(LogStatus.PASS, "Searching for "+SearchInput+" . ");

		wait.until(ExpectedConditions.visibilityOf(SearchResObj.ResultStats));

	}

}
