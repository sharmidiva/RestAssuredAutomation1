package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features=".//Features/loginddt.feature",
		features="/Users/diva/eclipse-workspace/CucumberDDT/Features/loginddt.feature",
		
		glue="StepDefinitions",
		dryRun=false,
		
		plugin= {"pretty",
				 "html:target/cucumber-reports1"},
		monochrome=true
		)

public class TestRun {

}
