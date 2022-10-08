package org.craigslist.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\org\\craigslist\\FeatureFiles\\",
        tags = "@Regression",
        plugin = {"pretty", "html:target/cucumber-reports-test", "json:target/cucumber-reports/cucumber-json-report.json"},
        monochrome = true,
        glue = "org.craigslist.StepDefination")

public class craigslistTestRunner {


}

