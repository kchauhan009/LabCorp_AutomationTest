package utils;

import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	public WebDriver driver;
	public Properties prop;
	
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToBeVisible(By el) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(el));
	}

	public void switchToChildWindow() {
		String currentHandle = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();
		for(String actual : handles) {
			if(!(actual.equalsIgnoreCase(currentHandle))) {
				driver.switchTo().window(actual);
			}
		}
	}

	public void switchToWindow(String currentWindow) {
		driver.switchTo().window(currentWindow);
	}
}