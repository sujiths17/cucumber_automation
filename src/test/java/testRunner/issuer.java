package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "E://ideaproject//cucumber_withSelenium//src//test//Features//CMS_Issuer.feature",
        glue="stepDefinitions",
        dryRun = false,//false ,true
        monochrome = true,
        plugin = {"pretty", "html:Issuer-test-output2.html"}
)
public class issuer {
}
