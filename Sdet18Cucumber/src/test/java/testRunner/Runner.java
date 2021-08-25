package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {".\\src\\test\\java\\features"},
		glue= {"stepDefinitions"},
		dryRun = true
		)

public class Runner extends AbstractTestNGCucumberTests{

}
