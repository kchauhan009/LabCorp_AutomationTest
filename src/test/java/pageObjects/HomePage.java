package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By careerLink = By.xpath("//*[@id='text-a63751913f']");
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnCareerLink() {
		driver.findElement(careerLink).click();
	}
}
