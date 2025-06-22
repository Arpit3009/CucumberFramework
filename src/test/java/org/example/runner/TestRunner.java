package org.example.runner;


//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/taggedhooks.feature",
        glue = {"org.example.stepDefinnitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
//        format = {"pretty", "html:target/cucumber-report"},
        monochrome = true,
        publish = true,
        dryRun = false
//        tags = "not @gh or not @jk"
//        tags = "@gh and @jk"
//        tags = "not @gh and not @jk"
//        tags = "@First"

)
//public class TestRunner extends AbstractTestNGCucumberTests {
//
//    @Override
//    @DataProvider
//    public Object[][] scenarios(){
//        return super.scenarios();
//    }
//}

public class TestRunner {
}
