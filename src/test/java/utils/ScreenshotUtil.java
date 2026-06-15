//package utils;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import com.google.common.io.Files;
//
//public class ScreenshotUtil {
//	public static void captureScreenshot(
//			WebDriver driver, 
//			String fileName) throws IOException {
//
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File src= ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("Screenshots/" + fileName + ".png");
//		Files.copy(src,dest);
//	}
//
//}

package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void takeScreenshot(WebDriver driver, String fileName) {

		try {

			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destinationFile = new File("Screenshots/" + fileName + ".png");

			destinationFile.getParentFile().mkdirs();

			Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}