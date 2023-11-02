package frameWorkOfMailTravel.resource.mailTravelResources;

import frameWorkOfMailTravel.resource.globalResources.GLOBAL_GENERIC;
import frameWorkOfMailTravel.resource.globalResources.GLOBAL_STATIC;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BookingDetailsPageResources {
    /**
     ->Expand date,departure,passenger section
     ->get count of adult,airport details and date
     ->In accommodation section select double room
     ->select room and continue
     **/

    String xpathOfViewButton="//h2[text()='1. Date, Departure & Passengers']";
    String xpathOfCountOfAdult="//div[@class='nbf_tpl_pms_bf_passenger_number unit size1of2 lastUnit']";
    String xpathOfAirportDetails="//div[@class='nbf_tpl_pms_bf_departure_value unit size1of2 lastUnit']/span";
    String xpathOfDoubleRoomSelection="//select[@id='room-1843060-numselect']";
    String xpathOfSelectionDoubleRoomFromDropDown="//select[@id='room-1843060-numselect']/option[@value='1']";
    String xpathOfSubmit="//div[@class='nbf_fancy_nbf_tpl_pms_book_room nbf_fg_pms_button_text ']";
    String xpathOfSubmitOfExtras="//div[text()='Continue without extras']";
    public String getCountOfAdult() {
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfViewButton).click();
        String CountOfAdult=GLOBAL_GENERIC.LocateAndGetElement(xpathOfCountOfAdult).getText();
       return CountOfAdult ;
    }

    public String getDepartureAirportDetails()  {
     String NameOfAirport =GLOBAL_GENERIC.LocateAndGetElement(xpathOfAirportDetails).getText();
    return NameOfAirport;
    }

    public LocalDate getsDetailsOfDate(){
        String GetDate =GLOBAL_GENERIC.LocateAndGetElement
                ("//div[@class='nbf_tpl_pms_bf_departuredate']").getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(GetDate, formatter);
        return dateTime;
    }

    public void AccommodationDetails()  {
       WebDriverWait wait=new WebDriverWait(GLOBAL_STATIC.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf
                (GLOBAL_GENERIC.LocateAndGetElement(xpathOfDoubleRoomSelection))).click();
        wait.until(ExpectedConditions.visibilityOf
                (GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectionDoubleRoomFromDropDown))).click();
        wait.until(ExpectedConditions.visibilityOf
                (GLOBAL_GENERIC.LocateAndGetElement(xpathOfSubmit))).click();
        wait.until(ExpectedConditions.visibilityOf
                (GLOBAL_GENERIC.LocateAndGetElement(xpathOfSubmitOfExtras))).click();


    }
}
