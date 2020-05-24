package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.GoogleSearchResultsPage;

public class GoogleSearchResultsTest extends TestBase {

	GoogleSearchResultsPage SearchResObj;

	@DataProvider(name = "SearchResult")
	public static Object[][] invalidAdminLoginData() throws IOException {

		ExcelReader ER = new ExcelReader();
		return ER.getExcelData(1, 1);
	}

	@Test(dataProvider = "SearchResult")
	public void verifyIfThirdResultContainsSpecificText(String content) {

		SearchResObj = new GoogleSearchResultsPage(driver);

		scrollToFindElement(SearchResObj.ThirdResult);

		boolean actualContent = SearchResObj.ThirdResult.getText().contains(content);
		assertTrue(actualContent, "Cant't find (" + content + ") at the third result's text");

	}

}
