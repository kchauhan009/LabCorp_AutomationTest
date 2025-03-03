package stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import pageObjects.HomePage;
import utils.TestSetup;

public class HomePageStepDefination {

	public HomePage homePage;
	TestSetup testSetup;

	public HomePageStepDefination(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
		this.homePage = testSetup.pageObjectManager.getHomePage();
	}

	@Given("User is on home page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(homePage.getPageTitle()
				.contains("Lab Diagnostics & Drug Development, Global Life Sciences Leader | Labcorp"));
	}

	@Given("User clicked on career link")
	public void clickOnCareer() {
		homePage.clickOnCareerLink();
	}
}