package stepDefinition.mailTravelStepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resource.mailTravelResources.BookingOverViewPageResources;

import java.time.LocalDate;

public class BookingOverviewStepDefinition {
    static String countOfAdults;
    static String detailsOfAirport;
    static LocalDate detailsOfDate;

    @Given("user is on booking overview page")
    public void user_is_on_booking_overview_page() {
        BookingOverViewPageResources.validateCountry();
    }

    @When("user click on book online button")
    public void user_click_on_book_online_button() {
        BookingOverViewPageResources.clickOnBookButton();
    }

    @Then("user should see a popup message")
    public void user_should_see_a_popup_message() {
        BookingOverViewPageResources.PopupMessage();
    }

    @When("user selects departure date")
    public void user_selects_departure_date() {
        BookingOverViewPageResources.selectFromDate();
    }

    @Then("user should not be able to see the popup message")
    public void user_should_not_be_able_to_see_the_popup_message() {
        BookingOverViewPageResources.PopupMessageValidation();
    }
    @When("select the num of person and takes a note of the airport")
    public void select_the_num_of_person_and_takes_a_note_of_the_airport() {
        BookingOverViewPageResources.DepartureDetails();
    }

    @Then("calculated price for <{int}> adults is displayed")
    public void calculated_price_for_adults_is_displayed(Integer NumOfPerson) {
        BookingOverViewPageResources.priceValidation(2);
    }

    @And("user should able to see all details and click book button")
    public void user_should_able_to_see_all_details_and_click_book_button()  {
        countOfAdults = BookingOverViewPageResources.getCountOfAdults();
        detailsOfAirport = BookingOverViewPageResources.getDetailsOfAirport();
        detailsOfDate = BookingOverViewPageResources.getDetailsOfDate();
        BookingOverViewPageResources.ValidateBookButton();


    }


}
