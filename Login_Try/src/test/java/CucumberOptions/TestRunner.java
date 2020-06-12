package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features/search.feature",
		glue= "StepDefinitions",tags= "@SeleniumTest", plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"})
//u can stop with features(package level). but if u want to specify a file under features package then mention
//glue is parameter to define the step defition file
//cucumber options paresrc/test/java/features/ is src/test/java 
//test runner package,which is cucumber options  and step definitions both are packages and should have same parent
//same parent is src/test/java
public class TestRunner {
	



}
