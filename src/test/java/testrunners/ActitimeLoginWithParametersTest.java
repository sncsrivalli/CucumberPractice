package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/ActitimeLoginWithParameterization.feature",
					glue = "stepdefinitions")
public class ActitimeLoginWithParametersTest {

}