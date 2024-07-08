package com.ilcarro;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com/ilcarro/stepDefinitions",
        tags = "@letTheCarWorkSuccessAdd",
//        tags = "@navigate or @invalidPassword", когда надо запустить 2 теста.
//        tags = "not @invalidPassword", если не надо запускать тест.
        plugin = {"pretty","json:Build/cucumber-report/cucumber.json"})

public class TestRunner {
}
