package testRunntags;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//features/",
                 glue = "stepDefinitions",
                 dryRun=false,
                 monochrome=true,
                 plugin = {"pretty","html:./test-output/index.html"},
                 tags="@Regression or @Smoke"
                 )

public class testRunner {

}


