package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DreamsTotalPage {

	WebDriver driver;

	public DreamsTotalPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getGoodDreams() {
		return driver.findElement(By.xpath("//td[normalize-space()='Good Dreams']/following-sibling::td")).getText();
	}

	public String getBadDreams() {
		return driver.findElement(By.xpath("//td[normalize-space()='Bad Dreams']/following-sibling::td")).getText();
	}

	public String getTotalDreams() {
		return driver.findElement(By.xpath("//td[normalize-space()='Total Dreams']/following-sibling::td")).getText();
	}

	public String getRecurringDreams() {
		return driver.findElement(By.xpath("//td[normalize-space()='Recurring Dreams']/following-sibling::td"))
				.getText();
	}
}