package cucumbers.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//https://cucumber.io/docs/cucumber/api/?sbsearch=tags%20to%20ignore#tags

@CucumberOptions(
        features={"src/test/java/cucumbers/features"},//the path of the feature files
        glue={"cucumbers.stepDef"},//the path of the step definition files
        tags="not @ignore1 and not @ignore2 and not @ignore3 and @run",
        plugin= {"pretty","html:target/cucumberReport.html"}, //to generate different types of reporting
        monochrome = true, //display the console output in a proper readable format
        dryRun = false //to check the mapping is proper between feature file and step def file

        // https://cucumber.io/docs/cucumber/api/
//mvn test -Dcucumber.options="src/test/java/cucumbers/features" -Dcucumber.options="–tags @run"

        //another 3rd party - https://github.com/cucumber/cucumber-java-skeleton
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    //@DataProvider(parallel = true)
    @DataProvider
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
