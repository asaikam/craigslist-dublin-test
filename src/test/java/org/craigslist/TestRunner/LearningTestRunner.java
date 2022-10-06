package org.craigslist.TestRunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\org\\craigslist\\FeatureFiles\\",
        tags = "@Regression",
        plugin = {"pretty", "html:target/site/cucumber-html-report.html", "json:target/cucumber-json-report.json"},
        monochrome = true,
        glue = "org.craigslist.StepDefination")

public class LearningTestRunner {
    @BeforeClass
    public static void startTest() {
		System.out.println("Craigslist Dublin Test Started: ");
    }
}

