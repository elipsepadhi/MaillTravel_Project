package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/mailTravel.feature"},
        glue = {"stepDefinition"},
        plugin = {"html:test-output/MailTravelReport.html","pretty","utilities.ListenerPlugin"}

)

public class TestRunner {
}
