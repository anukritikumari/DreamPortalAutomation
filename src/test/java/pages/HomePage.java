package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By myDreamBtn = By.xpath("//*[contains(text(),'My Dreams')]");

    public boolean isMyDreamButtonVisible() {
        return driver.findElement(myDreamBtn).isDisplayed();
    }

    public void clickMyDreams() {
        driver.findElement(myDreamBtn).click();
    }
}