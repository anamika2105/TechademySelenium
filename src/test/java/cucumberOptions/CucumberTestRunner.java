package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\Administrator\\E2EProject\\src\\test\\java\\features", // Specify the path to your feature files
    glue = "stepDefinations")

public class CucumberTestRunner {
}
