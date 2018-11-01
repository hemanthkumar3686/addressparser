package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "steps" }, monochrome = true, plugin = { "pretty",
		"html:target/cucumber"})
public class RunCuke extends AbstractTestNGCucumberTests {

}
