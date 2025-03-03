package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public String testData;

	public WebDriver getDriverSetup() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(fis);

		String url     = prop.getProperty("baseURL");
		String browser = prop.getProperty("browser");

		if(driver == null)
		{
			if(browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		return driver;
	}

	public Properties getPropertiesFileData() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(fis);

		return prop;
	}

	public String getTestData() throws IOException {
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\customerTestData.txt");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		testData = br.readLine();

		return testData;
	}
}
