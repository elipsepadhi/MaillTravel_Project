package frameWorkOfMailTravel.resource.mailTravelResources;

import frameWorkOfMailTravel.resource.globalResources.GLOBAL_GENERIC;
import frameWorkOfMailTravel.resource.globalResources.GLOBAL_STATIC;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BookingOverviewPageResources {
    /**
     ->click on Book online
     ->Validate popUp message after click book button
     ->select 2 adults
     ->get note of departure airport
     ->validating price for 2 adults
     ->get count of adult,details of airport and date
     ->click on Book button
     **/

    String xpathOfBookOnline="//button[@name='enterbookingflow']/div/div[text()='Book Online']";
    String xpathOfNumberOfAdult="//select[@name='numAdults']";
    String xpathOfSelectDate="//span[@data-amt='1999.00']";
    String xpathOfSelectNumAdultFromDropDown="//select[@name='numAdults']/option[@value='2']";
    String xpathFinalBookButton="//div[@id='book-button']/div/button/div/div";
    String xpathOfDetailsOfAirport="//div[@class='nbf_tpl_pms_departure_select_title']/following-sibling::span";
    String xpathOfPopupMessage="//div[text()='Please select your departure date']";
    boolean AfterSelectDate;

    public void clickOnBookButton()  {
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfBookOnline).click();
    }

    public void PopupMessageValidation()  {
       boolean BeforeSelectDate =GLOBAL_GENERIC.LocateAndGetElement(xpathOfPopupMessage).isDisplayed();
        if(BeforeSelectDate==true){
       try{
            GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectDate).click();
          AfterSelectDate= GLOBAL_GENERIC.LocateAndGetElement(xpathOfPopupMessage).isDisplayed();
        }
        catch (NoSuchElementException e) {
            Assert.assertFalse(AfterSelectDate);
          System.out.println("After select Departure date user not able to see popup message ");
        }}
    }

  public void DepartureDetails() {
      GLOBAL_GENERIC.LocateAndGetElement(xpathOfNumberOfAdult).click();
      GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectNumAdultFromDropDown).click();
      String AirportName= GLOBAL_GENERIC.LocateAndGetElement(xpathOfDetailsOfAirport).getText();
      System.out.println(" Departure Airport :" + AirportName );
  }

   public String getCountOfAdults()  {
        String   CountOfAdult = GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectNumAdultFromDropDown).getText();
   return CountOfAdult;
    }

    public String getDetailsOfAirport()  {
       String  NameOfAirport =  GLOBAL_GENERIC.LocateAndGetElement(xpathOfDetailsOfAirport).getText();
        return NameOfAirport;
    }

  public  LocalDate getDetailsOfDate()  {
      String GetDate= GLOBAL_GENERIC.LocateAndGetElement
              ("//div[@class='nbf_tpl_pms_calendar_day_available nbf_tpl_pms_calendar_box nbf_pms_tpl_calendar_selecteddate']" +
               "/div[@class='nbf_tpl_pms_calendar_box_dom']").getText();
      String  GetMonth=GLOBAL_GENERIC.LocateAndGetElement("//div[@class='nbf_tpl_pms_calendar_month']").getText();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
      LocalDate dateTime = LocalDate.parse(GetDate + " "+ GetMonth, formatter);
      return dateTime;
  }
  public void priceValidation(int CountOfAdult) {
     for(int i=CountOfAdult;i<3;i++) {
         GLOBAL_STATIC.driver.findElement(By.xpath("//select[@name='numAdults']/option[@value='"+i+"']")).click();
         int CalculatePrice= 1999 * i;
         try{
         Thread.sleep(3000);
         GLOBAL_STATIC.driver.findElement(By.xpath("//span[@data-amt='"+CalculatePrice+"']")).isDisplayed();
     }catch (InterruptedException e){}
     }

  }

  public void ValidateBookButton(){
      GLOBAL_GENERIC.LocateAndGetElement(xpathFinalBookButton).click();
  }

}

