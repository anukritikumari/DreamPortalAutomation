package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ScreenshotUtil;

public class BaseClass {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://arjitnigam.github.io/myDreams/");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtil.takeScreenshot(driver, result.getName() + "_FAILED");

			System.out.println("Screenshot captured for failed test: " + result.getName());
		}

		if (driver != null) {
			driver.quit();
		}
	}
}