package frameWorkOfMailTravel.resource.mailTravelResources;

import frameWorkOfMailTravel.resource.globalResources.GLOBAL_GENERIC;
import frameWorkOfMailTravel.resource.globalResources.GLOBAL_STATIC;
import org.openqa.selenium.By;

public class PassengerDetailsPageResources {
    /**
     -> Fill the passenger details
     ->click on continue button
     **/
    String xpathOfContactField = "//input[@name='contact-mobile']";
    String xpathOfEmailField = "//input[@name='contact-email']";
    String xpathOfAddressField = "//input[@name='contact-address1']";
    String xpathOfSecondAddress = "//input[@name='contact-address2']";
    String xpathOfCityField = "//input[@name='contact-city']";
    String xpathOfPostCodeField = "//input[@name='contact-postcode']";
    String xpathOfDetailsOfHearDropDown = "//select[@id='contact-hearabout']";
    String xpathOfSelectFromDropDown = "//option[text()='Email']";
    String xpathOfContinue = "//div[text()='Continue']";

    public void PassengerDetailsFillUp(int Number, String title, String FirstNAme,
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

    public void loadContactDetails(String num, String email, String Add, String Add2, String City, String postcode) {
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfContactField).sendKeys(num);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfEmailField).sendKeys(email);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfAddressField).sendKeys(Add);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSecondAddress).sendKeys(Add2);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfCityField).sendKeys(City);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfPostCodeField).sendKeys(postcode);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfDetailsOfHearDropDown).click();
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectFromDropDown).click();
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfContinue).click();
    }
}

