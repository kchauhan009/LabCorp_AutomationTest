package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CareersPage;
import utils.TestSetup;

public class CareersPageStepDefination {

	public WebDriver driver;
	public CareersPage careerPage;
	TestSetup testSetup;

	public CareersPageStepDefination(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
		this.careerPage = testSetup.pageObjectManager.getCareersPage();
	}

	@Then("^User searched and selected job (.+)$")
	public void user_searched_and_selected_job_position(String position) throws InterruptedException {
		careerPage.searchAndSelectJobs(position);
	}

	@Then("^User validates (.+) and (.+) and (.+)$")
	public void user_validates_job_details(String jobTitle,String jobLocation,String jobID) {

		// Verify Job Title
		Assert.assertEquals(careerPage.getJobTitle(), jobTitle);

		// Verify Job Location
		Assert.assertTrue(careerPage.getJobLocation().contains(jobLocation));

		// Verify Job ID
		Assert.assertTrue(careerPage.getJobID().contains(jobID));
	}

	@Then("^User Confirm second bullet point under Skills - Must Have as (.+)$")
	public void verifySecondBulletPoint(String skills) {
		Assert.assertEquals(careerPage.getSecondBulletText(), skills);
	}

	@Then("^User Confirm third requirement as (.+)$")
	public void verifyThirdRequirement(String experience) {
		Assert.assertEquals(careerPage.getExperienceText(), experience);
	}

	@Then("^User Confirm first suggested automation tool to be familiar with (.+)$")
	public void verifyAutomationTool(String tools) {
		Assert.assertTrue(careerPage.getToolsText().contains(tools), tools);
	}

	@And("User click on apply button")
	public void clickOnApplyButton() throws IOException
	{
		careerPage.clickOnApplyBtn();
		testSetup.pageObjectManager.getCommonUtilsMethods().switchToChildWindow();
	}

	@Then("^User checks (.+) and (.+) and (.+) and (.+) on job application page and returned to job search page$")
	public void User_validates_Job_Application_Details(String newPageTitle,String jobTitle,String jobLocation,String jobID) throws IOException {

		Assert.assertTrue(careerPage.getPageTitle().contains(newPageTitle));
		
		// Switch to main window
		testSetup.pageObjectManager.getCommonUtilsMethods().switchToWindow(testSetup.parentWindow);

		// Verify Job Title
		Assert.assertEquals(careerPage.getJobTitle(), jobTitle);

		// Verify Job Location
		Assert.assertTrue(careerPage.getJobLocation().contains(jobLocation));

		// Verify Job ID
		Assert.assertTrue(careerPage.getJobID().contains(jobID));
	}
}
