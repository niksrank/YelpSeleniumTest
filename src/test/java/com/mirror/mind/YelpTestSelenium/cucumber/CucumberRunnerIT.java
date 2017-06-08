package com.mirror.mind.YelpTestSelenium.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/yelp.feature",
        format = {"html:target/cucumber-report-html", "json:target/cucumber-report.json"})
public class CucumberRunnerIT {

}

