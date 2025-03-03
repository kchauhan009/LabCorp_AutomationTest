package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import utils.CommonUtils;

public class PageObjectManager {

	public HomePage homePage;
	public CareersPage careersPage;
	public WebDriver driver;
	public CommonUtils commonUtils;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		homePage = new HomePage(driver);
		return homePage;
	}

	public CareersPage getCareersPage() throws IOException {
		careersPage = new CareersPage(driver);
		return careersPage;
	}
	
	public CommonUtils getCommonUtilsMethods() throws IOException {
		commonUtils = new CommonUtils(driver);
		return commonUtils;
	}
}