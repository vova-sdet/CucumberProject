package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/espoCRM/createUserSearch.feature",
        glue = "StepDefinitions",
        monochrome = false,
        dryRun = false
        // tags = "@userDetails"
)

public class EspoCrmRunner {
}
