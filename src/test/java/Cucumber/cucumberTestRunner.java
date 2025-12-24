package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Resources",glue="Cucumber",
monochrome=true,tags="@Regression",plugin= {"html:target/cucumber.html"})

public class cucumberTestRunner extends AbstractTestNGCucumberTests{

}
