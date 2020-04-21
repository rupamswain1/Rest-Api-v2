package test.stripe.api.runner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src/test/resources/Scenarios"},glue="test.stripe.steps",
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CustomerRunner extends AbstractTestNGCucumberTests{

}
