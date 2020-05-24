package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public WebDriverWait wait;

	@BeforeSuite
	public void startDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver81.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/ncr");

	}

	public void scrollToFindElement(WebElement scrollElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", scrollElement);
	}

	@AfterMethod
	public void afterEachTest(ITestResult result, Method method) {

		// Capture screenshot in case of test failure with test name
		if (ITestResult.FAILURE == result.getStatus()) {

			System.out.println("Test Failed! Taking Screenshot....");
			try {

				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots", result.getName() + ".png"));

				System.out.println("Screenshot captured successfully .. ");

			} catch (IOException e) {
				System.out.println("Excpetion while taking screenshot" + e.getMessage());
			}

		}

	}

	@AfterSuite
	public void stopDriver() {

		driver.quit();

	}

}
