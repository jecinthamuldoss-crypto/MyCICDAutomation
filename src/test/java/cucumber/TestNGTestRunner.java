package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features="src/test/java/cucumber",
	    glue={"JesssfinalCompany.stepdef"},
	    monochrome=true,
	    plugin = {"pretty", "html:target/cucumber.html"}
	)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
