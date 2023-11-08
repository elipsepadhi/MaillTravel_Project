package resource.mailTravelResources;

import resource.globalResources.GLOBAL_GENERIC;
import resource.globalResources.GLOBAL_STATIC;
import org.openqa.selenium.By;

public class PassengerDetailsPageResources {
    /**
     -> Fill the passenger details
     ->click on continue button
     **/
   static String xpathOfContactField = "//input[@name='contact-mobile']";
   static   String xpathOfEmailField = "//input[@name='contact-email']";
   static String xpathOfAddressField = "//input[@name='contact-address1']";
   static String xpathOfSecondAddress = "//input[@name='contact-address2']";
   static String xpathOfCityField = "//input[@name='contact-city']";
   static String xpathOfPostCodeField = "//input[@name='contact-postcode']";
   static String xpathOfDetailsOfHearDropDown = "//select[@id='contact-hearabout']";
   static   String xpathOfSelectFromDropDown = "//option[text()='Email']";
   static   String xpathOfContinue = "//div[text()='Continue']";
   static String xpathOfAdult="//h4";

  public static void validateAdult(){
      GLOBAL_GENERIC.LocateAndGetElement(xpathOfAdult).isDisplayed();
  }

    public static void PassengerDetailsFillUp(int Number, String title, String FirstNAme,
                                       String LastNAme, int Date, int Month, int Year)  {
        GLOBAL_STATIC.driver.findElement(By.xpath("//select[@id='pax-a-title-" + Number + "']")).click();
        try{
        Thread.sleep(3000);
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//select[@id='pax-a-title-" + Number + "']/option[text()='" + title + "']")).click();
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//input[@name='pax-a-first-" + Number + "']")).sendKeys(FirstNAme);
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//input[@name='pax-a-last-" + Number + "']")).sendKeys(LastNAme);
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//select[@name='pax-a-dobd-" + Number + "']")).click();
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//select[@name='pax-a-dobd-" + Number + "']/option[@value='" + Date + "']")).click();
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//select[@name='pax-a-dobm-" + Number + "']")).click();
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//select[@id='pax-a-dobm-" + Number + "']/option[@value='" + Month + "']")).click();
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//select[@name='pax-a-doby-" + Number + "']")).click();
        GLOBAL_STATIC.driver.findElement
                (By.xpath("//select[@id='pax-a-doby-" + Number + "']/option[@value='" + Year + "']")).click();}
        catch(InterruptedException e){}

    }

    public static void loadContactDetails(String num, String email, String Add, String Add2, String City, String postcode) {
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfContactField).sendKeys(num);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfEmailField).sendKeys(email);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfAddressField).sendKeys(Add);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSecondAddress).sendKeys(Add2);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfCityField).sendKeys(City);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfPostCodeField).sendKeys(postcode);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfDetailsOfHearDropDown).click();
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectFromDropDown).click();
       // GLOBAL_GENERIC.LocateAndGetElement(xpathOfContinue).click();
    }
    public static void clickButton(){
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfContinue).click();
    }
}

