package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import pages.BasePage;

import java.util.Locale;

@CucumberOptions(features = "src/test/resources",
        glue = "steps",
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber/reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)


public class TestRunner extends AbstractTestNGCucumberTests {
@AfterClass
    public static void cleanDriver(){
    BasePage.closeBrowser();
}

}
