package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DreamsDiaryPage {

    WebDriver driver;

    public DreamsDiaryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Table Rows Locator
    By rows = By.xpath("//table/tbody/tr");

    // Get all rows
    public List<WebElement> getRows() {
        return driver.findElements(rows);
    }

    // Verify total dreams count
    public int getDreamCount() {
        return driver.findElements(rows).size();
    }

    // Verify Dream Type contains only Good or Bad
    public boolean validateDreamTypes() {

        List<WebElement> rowList = driver.findElements(rows);

        for (WebElement row : rowList) {

            List<WebElement> cols =
                    row.findElements(By.tagName("td"));

            String dreamType =
                    cols.get(2).getText().trim();

            if (!(dreamType.equals("Good")
                    || dreamType.equals("Bad"))) {

                return false;
            }
        }
        return true;
    }

    // Verify no empty columns
    public boolean validateColumnsFilled() {

        List<WebElement> rowList = driver.findElements(rows);

        for (WebElement row : rowList) {

            List<WebElement> cols =
                    row.findElements(By.tagName("td"));

            for (WebElement col : cols) {

                if (col.getText().trim().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}