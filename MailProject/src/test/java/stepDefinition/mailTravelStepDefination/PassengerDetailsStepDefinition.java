package stepDefinition.mailTravelStepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resource.mailTravelResources.PassengerDetailsPageResources;

public class PassengerDetailsStepDefinition {
    @Given("user is on passenger details section")
    public void user_is_on_passenger_details_section() {
     PassengerDetailsPageResources.validateAdult();

    }
    @When("user fills the  passenger details of <{int},{string},{string},{string},{int}, {int}, {int}>")
    public void user_fills_the_passenger_details_of
            (Integer number, String title, String firstName, String lastName, Integer date, Integer month, Integer year) {
    PassengerDetailsPageResources.
            PassengerDetailsFillUp(number,title,firstName,lastName,date,month,year);
    }

    @When("user fills the contact details of <{string},{string},{string},{string},{string},{string}>")
    public void fills_the_contact_details_of
            (String num, String email, String Add, String Add2,String city, String postcode) {
       PassengerDetailsPageResources.
               loadContactDetails(num,email,Add,Add2,city,postcode);
    }

    @Then("user should able to click on continue button")
    public void user_should_able_to_click_on_continue_button() {
    PassengerDetailsPageResources.clickButton();
    }
}
