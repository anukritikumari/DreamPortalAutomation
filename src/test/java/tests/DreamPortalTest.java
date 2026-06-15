package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DreamsDiaryPage;
import pages.DreamsTotalPage;
import pages.HomePage;
import utils.ScreenshotUtil;
public class DreamPortalTest extends BaseClass {

	@Test
	public void verifyDreamPortal() throws InterruptedException {

		System.out.println("Title : " + driver.getTitle());
		System.out.println("URL : " + driver.getCurrentUrl());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'My Dreams')]")));

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isMyDreamButtonVisible(), "My Dreams button not visible");

		System.out.println("PASS - My Dreams button visible");

		home.clickMyDreams();

		Thread.sleep(3000);

		Set<String> windows = driver.getWindowHandles();

		List<String> tabs = new ArrayList<>(windows);

		System.out.println("Total Tabs = " + tabs.size());

		Assert.assertEquals(tabs.size(), 3, "Expected 3 tabs");

		// Dream Diary Validation
		for (String tab : tabs) {

			driver.switchTo().window(tab);

			if (driver.getCurrentUrl().contains("dreams-diary")) {

				DreamsDiaryPage diary = new DreamsDiaryPage(driver);

				Assert.assertEquals(diary.getDreamCount(), 10, "Dream count mismatch");

				Assert.assertTrue(diary.validateDreamTypes(), "Invalid Dream Type Found");

				Assert.assertTrue(diary.validateColumnsFilled(), "Some columns are empty");

				System.out.println("PASS - Dream Diary Validation");

				break;
			}
		}

		// Summary Page Validation
		for (String tab : tabs) {

			driver.switchTo().window(tab);

			if (driver.getCurrentUrl().contains("dreams-total")) {

				DreamsTotalPage total = new DreamsTotalPage(driver);

				System.out.println("Good Dreams = " + total.getGoodDreams());

				System.out.println("Bad Dreams = " + total.getBadDreams());

				System.out.println("Total Dreams = " + total.getTotalDreams());

				System.out.println("Recurring Dreams = " + total.getRecurringDreams());

				Assert.assertEquals(total.getGoodDreams(), "6");

				Assert.assertEquals(total.getBadDreams(), "4");

				Assert.assertEquals(total.getTotalDreams(), "10");

				Assert.assertEquals(total.getRecurringDreams(), "2");

				System.out.println("PASS - Summary Page Validation");

				break;
			}
		}

		ScreenshotUtil.takeScreenshot(driver, "DreamPortal_Pass");
		System.out.println("PASS - Dream Portal Assignment Completed");
	}
}