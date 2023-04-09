package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C://Users//sumit.rana//IdeaProjects//SDET_Assignments//src//Features//Assignments_All.feature"},
        glue = {"stepDefinitions"},
        tags = "@Assignments_All",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")

public class RunTest_All {
}