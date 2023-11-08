package stepDefinition.mailTravelStepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import resource.mailTravelResources.BookingDetailsPageResources;

import java.time.LocalDate;

public class BookingDetailsStepDefinition {
    String detailsOfAirport;
    LocalDate detailsOfDate;
    String countOfAdult;

    @Given("user is on booking details page")
    public void user_is_on_booking_details_page()  {
        BookingDetailsPageResources.ValidateDateDeparturePassenger();
    }

    @When("user views date,departure & passenger section")
    public void user_views_date_departure_passenger_section() {
        BookingDetailsPageResources.expandDateDeparturePassenger();
    }

    @Then("user should able to see all details")
    public void user_should_able_to_see_all_details() {
      detailsOfDate = BookingDetailsPageResources.getsDetailsOfDate();
      detailsOfAirport = BookingDetailsPageResources.getAirportDetails();
      countOfAdult= BookingDetailsPageResources.getCountOfAdult();
    }

    @And("details should match with booking details page and booking overview page")
    public void details_should_match_with_booking_details_page_and_booking_overview_page() {
       Assert.assertEquals(BookingOverviewStepDefinition.countOfAdults, countOfAdult);
       Assert.assertEquals(BookingOverviewStepDefinition.detailsOfAirport, detailsOfAirport);
       Assert.assertEquals(BookingOverviewStepDefinition.detailsOfDate, detailsOfDate);
    }

    @When("user select accommodation details")
    public void user_select_accommodation_details() {
        BookingDetailsPageResources.AccommodationDetails();
    }

    @Then("user should able click on continue button")
    public void user_should_able_click_on_continue_button()  {
        BookingDetailsPageResources.submitButton();
    }

}
