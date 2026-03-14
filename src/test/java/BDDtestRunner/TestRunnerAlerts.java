package BDDtestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/resources/BDDfeatures/Alerts.feature",
	glue= {"BDDAlerts"},
	tags = "@Regression",
	plugin= {
			"pretty",
			"html:target/cucumber-reports.html",
			"rerun:target/rerun.txt"
			},
	//dryRun=true,
	monochrome=true
		)
public class TestRunnerAlerts {
}
