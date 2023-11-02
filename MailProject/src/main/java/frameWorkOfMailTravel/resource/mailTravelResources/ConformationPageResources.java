package frameWorkOfMailTravel.resource.mailTravelResources;

import frameWorkOfMailTravel.resource.globalResources.GLOBAL_GENERIC;
import org.testng.Assert;

public class ConformationPageResources {
    /**
     ->verify the conformation details + Book page
     ->validate book button
     **/
    String xpathOfActualHeader = "//h1[@class='nbf_fancyimg_payment_pageheader']" ;
    String xpathOfBookButton="//div[text()='Book Now']";
    String xpathOfPopUpMessage="//ul[@class='errorbox']/li[text()='Terms and Conditions checkbox must be selected']";
    String xpathOfCheckBox="//input[@tabindex='1']";
    String xpathOfActualText="//h1[text()='Payment']";
    String ExpectedText="Payment";

    public void ConformationHeader() {
        String  ActualHeader  = GLOBAL_GENERIC.LocateAndGetElement(xpathOfActualHeader).getText();
        String ExpectedHeader="Confirm Details + Book";
        Assert.assertEquals(ActualHeader,ExpectedHeader);
    }

    public void validateBookButton(){
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