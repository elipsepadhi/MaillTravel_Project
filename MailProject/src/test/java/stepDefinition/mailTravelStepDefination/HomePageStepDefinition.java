package stepDefinition.mailTravelStepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resource.mailTravelResources.HomePageResources;

public class HomePageStepDefinition {

    @Given("user is on Homepage")
    public void user_is_on_homepage() {
       HomePageResources.ValidateTitle();
    }

    @When("user click on accept all the cookies")
    public void user_click_on_accept_all_the_cookies() {
        HomePageResources.AcceptCookies();
    }
    
    @Then("user should search for <{string}> in search bar")
    public void user_should_search_for_in_search_bar(String countryName) {
       HomePageResources.SearchbarInHomePage(countryName);
    }
}
