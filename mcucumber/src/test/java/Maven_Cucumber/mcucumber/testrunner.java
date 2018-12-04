package Maven_Cucumber.mcucumber;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/test.feature", glue= {"Maven_Cucumber.mcucumber"} , plugin = {
"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/MyReort.html" }, monochrome = true )

public class testrunner {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig("extent-config.xml");
	}
	
}