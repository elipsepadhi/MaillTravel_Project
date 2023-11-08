package resource.mailTravelResources;

import org.junit.Assert;
import resource.globalResources.GLOBAL_GENERIC;

public class ConformationPageResources {
    /**
     ->verify the conformation details + Book page
     ->validate book button
     **/
    static String xpathOfActualHeader = "//h1[@class='nbf_fancyimg_payment_pageheader']" ;
    static String xpathOfBookButton="//div[text()='Book Now']";
    static String xpathOfPopUpMessage="//ul[@class='errorbox']/li[text()='Terms and Conditions checkbox must be selected']";
    static String xpathOfCheckBox="//input[@tabindex='1']";
    static String xpathOfActualText="//h1[text()='Payment']";
    static String ExpectedText="Payment";

    public static void ConformationHeader() {
        String  ActualHeader  = GLOBAL_GENERIC.LocateAndGetElement(xpathOfActualHeader).getText();
        String ExpectedHeader="Confirm Details + Book";
        Assert.assertEquals(ActualHeader,ExpectedHeader);
    }

    public static void validateBookButton(){
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfBookButton).click();
       boolean popupMessage= GLOBAL_GENERIC.LocateAndGetElement(xpathOfPopUpMessage).isDisplayed();
        if(popupMessage==true){
            GLOBAL_GENERIC.LocateAndGetElement(xpathOfCheckBox).click();
            GLOBAL_GENERIC.LocateAndGetElement(xpathOfBookButton).click();
            String ActualText = GLOBAL_GENERIC.LocateAndGetElement(xpathOfActualText).getText();
            Assert.assertEquals(ActualText,ExpectedText);

        }
    }
}