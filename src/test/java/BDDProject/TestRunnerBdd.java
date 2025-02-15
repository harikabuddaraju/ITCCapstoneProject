package BDDProject;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
 
@CucumberOptions(
        features = "src/test/java/BDDProject/",
        glue = "BDDProject",
        plugin = { "pretty", "html:target/BDD_Test_Reports.html" },
        monochrome = true
)
 
public class TestRunnerBdd {
 
}