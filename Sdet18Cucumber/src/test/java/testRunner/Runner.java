package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {".\\src\\test\\java\\features"},
		glue= {"stepDefinitions","hook","stepDefinitionOrg"},
		dryRun = false,
		monochrome = true,
		tags = "not @SmokeTest",
		plugin= {"pretty",
				"html:target/cucumber.html",
				"json:target/cucumberjson.json"}
		)

public class Runner extends AbstractTestNGCucumberTests{

}
