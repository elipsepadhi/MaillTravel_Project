package resource.mailTravelResources;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import resource.globalResources.GLOBAL_GENERIC;
import resource.globalResources.GLOBAL_STATIC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BookingOverViewPageResources {
    /**
     ->click on Book online
     ->Validate popUp message after click book button
     ->select 2 adults
     ->get note of departure airport
     ->validating price for 2 adults
     ->get count of adult,details of airport and date
     ->click on Book button
     **/

    static String xpathOfBookOnline="//button[@name='enterbookingflow']/div/div[text()='Book Online']";
    static   String xpathOfNumberOfAdult="//select[@name='numAdults']";
    static String xpathOfSelectDate="//input[@data-price='1999.00']";
    static String xpathOfSelectNumAdultFromDropDown="//select[@name='numAdults']/option[@value='2']";
    static String xpathFinalBookButton="//div[@id='book-button']/div/button/div/div";
    static String xpathOfDetailsOfAirport="//div[@class='nbf_tpl_pms_departure_select_title']/following-sibling::span";
    static String xpathOfPopupMessage="//div[text()='Please select your departure date']";
    static boolean AfterSelectDate;
    static boolean BeforeSelectDate;
    static String xpathOfCountry="//h1[text()='India']";
    public static void validateCountry(){
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfCountry).isDisplayed();
    }
    public static void clickOnBookButton()  {
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfBookOnline).click();
    }

    public static void PopupMessage(){
        BeforeSelectDate =GLOBAL_GENERIC.LocateAndGetElement(xpathOfPopupMessage).isDisplayed();
    }
    public static void selectFromDate(){
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectDate).click();
    }
    public static void PopupMessageValidation()  {
        if(BeforeSelectDate==true){
            try{
                AfterSelectDate= GLOBAL_GENERIC.LocateAndGetElement(xpathOfPopupMessage).isDisplayed();
            }
            catch (NoSuchElementException e) {
                Assert.assertFalse(AfterSelectDate);
                System.out.println("After select Departure date user not able to see popup message ");
            }}
    }

    public static void DepartureDetails() {
        try{
            GLOBAL_GENERIC.LocateAndGetElement(xpathOfNumberOfAdult).click();
            Thread.sleep(3000);
            GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectNumAdultFromDropDown).click();
            String AirportName= GLOBAL_GENERIC.LocateAndGetElement(xpathOfDetailsOfAirport).getText();
            System.out.println(" Departure Airport :" + AirportName );}
        catch(InterruptedException e){}
    }

    public static String getCountOfAdults()  {
        String   CountOfAdult = GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectNumAdultFromDropDown).getText();
        return CountOfAdult;
    }

    public static String getDetailsOfAirport()  {
        String  NameOfAirport =  GLOBAL_GENERIC.LocateAndGetElement(xpathOfDetailsOfAirport).getText();
        return NameOfAirport;
    }

    public static LocalDate getDetailsOfDate()  {
        String GetDate= GLOBAL_GENERIC.LocateAndGetElement
                ("//div[@class='nbf_tpl_pms_calendar_day_available nbf_tpl_pms_calendar_box nbf_pms_tpl_calendar_selecteddate']" +
                        "/div[@class='nbf_tpl_pms_calendar_box_dom']").getText();
        String  GetMonth=GLOBAL_GENERIC.LocateAndGetElement("//div[@class='nbf_tpl_pms_calendar_month']").getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(GetDate + " "+ GetMonth, formatter);
        return dateTime;
    }
    public static void priceValidation(int CountOfAdult) {
        for(int i=CountOfAdult;i<3;i++) {
            int CalculatePrice= 1999 * i;
            try{
                Thread.sleep(3000);
                GLOBAL_STATIC.driver.findElement(By.xpath("//span[@data-amt='"+CalculatePrice+"']")).isDisplayed();
            }catch (InterruptedException e){}
        }
    }

    public static void ValidateBookButton() {
        GLOBAL_GENERIC.LocateAndGetElement(xpathFinalBookButton).click();
    }

}
