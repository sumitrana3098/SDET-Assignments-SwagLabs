package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "C://Users//sumit.rana//IdeaProjects//SDET_Assignments//src//Features//Assignment_2.feature",
        glue = "stepDefinitions",
        tags = "@Assignment2ByExcel",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

)

public class RunTest_2 extends AbstractTestNGCucumberTests {

}
