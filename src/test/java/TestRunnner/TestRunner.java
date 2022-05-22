package TestRunnner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\FeatureFiles",
        glue= {"StepDefinition"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json","html:target/cucumber-report/cucumber.html"}
        )

public class TestRunner {
}
