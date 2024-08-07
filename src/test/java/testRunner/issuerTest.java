package testRunner;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "E://ideaproject//cucumber_withSelenium//src//test//Features//CMS_Issuer.feature",
        glue="stepDefinitions",
        dryRun = false,//false ,true
        monochrome = true,
        plugin = {"pretty", "html:Issuer-test-output2.html"}
)

public class issuerTest {

}
//public class issuer extends AbstractTestNGCucumberTests {
//    // The class body can be empty
//}


