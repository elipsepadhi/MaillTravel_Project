package resource.mailTravelResources;

import resource.globalResources.GLOBAL_GENERIC;
import resource.globalResources.GLOBAL_STATIC;
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

    static String xpathOfViewButton="//h2[text()='1. Date, Departure & Passengers']";
    static String xpathOfCountOfAdult="//div[@class='nbf_tpl_pms_bf_passenger_number unit size1of2 lastUnit']";
    static String xpathOfAirportDetails="//div[@class='nbf_tpl_pms_bf_departure_value unit size1of2 lastUnit']/span";
    static String xpathOfDoubleRoomSelection="//select[@id='room-1843060-numselect']";
    static String xpathOfSelectionDoubleRoomFromDropDown="//select[@id='room-1843060-numselect']/option[@value='1']";
    static String xpathOfSubmit="//div[@class='nbf_fancy_nbf_tpl_pms_book_room nbf_fg_pms_button_text ']";
    static String xpathOfSubmitOfExtras="//div[text()='Continue without extras']";
    static WebDriverWait wait;
    public static void expandDateDeparturePassenger(){
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfViewButton).click();
    }
    public static void ValidateDateDeparturePassenger()  {

        try {
            Thread.sleep(3000);
            GLOBAL_GENERIC.LocateAndGetElement(xpathOfViewButton).isDisplayed();
        }
      catch (InterruptedException e){}


    }
    public static String getCountOfAdult() {
        String CountOfAdult=GLOBAL_GENERIC.LocateAndGetElement(xpathOfCountOfAdult).getText();
       return CountOfAdult ;
    }

    public static String getAirportDetails()  {
     String NameOfAirport =GLOBAL_GENERIC.LocateAndGetElement(xpathOfAirportDetails).getText();
    return NameOfAirport;
    }

    public static LocalDate getsDetailsOfDate(){
        String GetDate =GLOBAL_GENERIC.LocateAndGetElement
                ("//div[@class='nbf_tpl_pms_bf_departuredate']").getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(GetDate, formatter);
        return dateTime;
    }


    public static void AccommodationDetails()  {
        wait=new WebDriverWait(GLOBAL_STATIC.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf
                (GLOBAL_GENERIC.LocateAndGetElement(xpathOfDoubleRoomSelection))).click();
        wait.until(ExpectedConditions.visibilityOf
                (GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectionDoubleRoomFromDropDown))).click();


    }
    public static void submitButton()  {
        try {
            Thread.sleep(3000);
            GLOBAL_GENERIC.LocateAndGetElement(xpathOfSubmit).click();
        }catch (InterruptedException e){}

        wait.until(ExpectedConditions.visibilityOf
                (GLOBAL_GENERIC.LocateAndGetElement(xpathOfSubmitOfExtras))).click();
    }
}
