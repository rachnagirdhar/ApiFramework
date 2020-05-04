package TestCaseExecution;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(strict = true,
		
		features="src/test/java/Features/AddPlaceFeature.feature",
		
		plugin= "json:target/jsonReports/cucumber-report.json",
		glue= "StepDefinitions"
		//tags= {"@DeletePlace"}
		)

	 	

public class TestRunner {
	
	

}
