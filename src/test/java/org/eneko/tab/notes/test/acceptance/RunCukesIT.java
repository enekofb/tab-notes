package org.eneko.tab.notes.test.acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report" }, features = {
        "src/test/resources/acceptance"})
@RunWith(Cucumber.class)
public class RunCukesIT {

}