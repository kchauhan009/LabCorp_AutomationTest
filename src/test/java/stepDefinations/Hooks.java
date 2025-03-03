package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import utils.TestSetup;

public class Hooks {
	
	TestSetup testSetup;
	
	public Hooks(TestSetup testSetup) throws IOException{
		this.testSetup = testSetup;
	}
	
	@After // tearDown method
	public void runAfterScenario() throws IOException {
		if(testSetup.basePage.getPropertiesFileData().get("exeMode").equals("UI")) {
			testSetup.basePage.getDriverSetup().quit();
		}
	}
	
	@AfterStep
	public void runAfterStep() throws IOException { 
		//We can add method to capture failed TC screenshot
		//WebDriver driver = testSetup.basePage.getDriverSetup();
	}
	
	/* Execution Sequence
	   @Before
	   
	   Background 
	   Scenario
	   
	   @After 
	*/
}