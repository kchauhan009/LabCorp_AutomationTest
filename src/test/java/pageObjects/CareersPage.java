package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public CareersPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	By searchTextBox   = By.id("typehead");
	By jobLists        = By.xpath("//*[@id='typehead-listbox']/div/div/ul/li");
	By jobTitle        = By.cssSelector("h1.job-title");
	By jobLocation     = By.xpath("//*[@class='au-target job-location']");
	By jobID           = By.xpath("//*[@class='au-target jobId']");
	By skills          = By.xpath("//*[@class='jd-info au-target']//ul[1]/li[2]/p");
	By experience      = By.xpath("//*[@class='jd-info au-target']//b[contains(text(),'Experience:')]//following::p[1]");
	By tools           = By.xpath("//*[@class='jd-info au-target']");
	By applyJobBtn     = By.xpath("//*//a[@ph-tevent='apply_click']");
	By closeChatbotBtn = By.xpath("//*[@aria-label='Close Chatbot Window']");
	
	public void searchAndSelectJobs(String searchText) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(closeChatbotBtn));
		driver.findElement(closeChatbotBtn).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));
		driver.findElement(searchTextBox).sendKeys(searchText);
		Thread.sleep(2000);
		List<WebElement> openingsLists = driver.findElements((By) jobLists);
		
		if(openingsLists.size() > 0) {
			for(int i=1;i<=openingsLists.size();i++){
				
				String jobText = driver.findElement(By.xpath("//*[@id='typehead-listbox']/div/div/ul/li["+i+"]")).getText();

				if(jobText.contains(searchText)) {
					driver.findElement(By.xpath("//*[@id='typehead-listbox']/div/div/ul/li["+i+"]")).click();
					break;
				}
			}
		}
		else {
			System.out.println("No results for "+searchText+" ");
			System.out.println("There are no jobs for your search criteria.");
		}
	}

	public String getJobTitle() {
		String jobTitleText = driver.findElement(jobTitle).getText();
		return jobTitleText;
	}

	public String getJobLocation() {
		String jobLocationText = driver.findElement(jobLocation).getText();
		return jobLocationText;
	}

	public String getJobID() {
		String jobIDText = driver.findElement(jobID).getText();
		return jobIDText;
	}

	public String getSecondBulletText() {
		String secondBulletText = driver.findElement(skills).getText();
		return secondBulletText;
	}

	public String getExperienceText() {
		String experienceText = driver.findElement(experience).getText();
		return experienceText;
	}

	public String getToolsText() {
		String toolsText = driver.findElement(tools).getText();
		return toolsText;
	}

	public void clickOnApplyBtn() {
		driver.findElement(applyJobBtn).click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}