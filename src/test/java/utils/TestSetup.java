package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageObjects.CareersPage;
import pageObjects.PageObjectManager;

public class TestSetup {

	public WebDriver driver;
	public BasePage basePage;
	public CommonUtils commonUtils;
	public PageObjectManager pageObjectManager;
	public CareersPage careersPage;
	public String parentWindow;
	public Properties prop;
	
	public TestSetup() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(fis);
		String exeMode = prop.getProperty("exeMode");
		
		if(exeMode.equalsIgnoreCase("UI")) {
			this.basePage = new BasePage();
			this.commonUtils = new CommonUtils(basePage.getDriverSetup());
			this.pageObjectManager = new PageObjectManager(basePage.getDriverSetup());
			parentWindow = basePage.getDriverSetup().getWindowHandle();
		}
		else if(exeMode.equalsIgnoreCase("API")){
			this.basePage = new BasePage();
			prop = basePage.getPropertiesFileData();
		}
		else {
			System.out.println("Please check exeMode input from properties file");
		}
	}
}