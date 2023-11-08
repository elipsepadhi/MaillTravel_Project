package stepDefinition.mailTravelStepDefination;


import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import resource.globalResources.GLOBAL_STATIC;

public class BrowserConfigStepDefinition {

    @Given("Step from {string} in  feature file")
    public void step_from_in_feature_file(String string) {
        Base.launchBrowser(string);
    }

}
