package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
                 glue="stepDefinations",
                 monochrome=true,  // 
                 //dryRun = true,   // if any of the steps in the Feature file is not implemented in the Step Definition file. A dry run parameter is a part of the @CucumberOptions which is used to configure the test settings.
                 tags="@SearchJobOpenings",
                 plugin = {"pretty",
                		   "html:target/cucumber.html",
                		   "json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
}

/* dryRun = true
*  Cucumber will verify individual steps in the Feature file and the implementation code of steps in Feature file within the Step Definition file.
*  A message is thrown, if any of the steps in the Feature file is not implemented in the Step Definition file. 
*  A dry run parameter is a part of the @CucumberOptions which is used to configure the test settings.
*/
//@SearchJobOpenings
//@getBeeceptorData or @postCustomerInformation