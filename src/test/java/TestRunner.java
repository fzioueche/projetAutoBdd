import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/spec/feature"},
		plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = ("@authentificationValide"),
		snippets = SnippetType.CAMELCASE,
		monochrome = true
		

		)

















public class TestRunner {

}
