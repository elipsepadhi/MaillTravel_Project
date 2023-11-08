package stepDefinition.mailTravelStepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resource.mailTravelResources.ConformationPageResources;

public class ConformationPageStepDefinition {
    @When("user is on conformation page")
    public void user_is_on_conformation_page() {
        ConformationPageResources.ConformationHeader();
    }
    @Then("user should click on Book Now button")
    public void user_should_click_on_book_now_button() {
        ConformationPageResources.validateBookButton();
    }
}
