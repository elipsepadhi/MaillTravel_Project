package frameWorkOfMailTravel.resource.mailTravelResources;

import frameWorkOfMailTravel.resource.globalResources.GLOBAL_GENERIC;
import frameWorkOfMailTravel.resource.globalResources.GLOBAL_STATIC;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePageResources {
    /**
     ->Accept all cookies
     ->Validate Title
     ->search for specific country
     **/
    String xpathOfAcceptCookies="//button[text()='Accept All Cookies']";
    String xpathOfSearchbar="//div[@id='freetext_search_form']/form/input[@class='nbf_tpl_quicksearch_searchtext']";
    String xpathOfSelectFromCountryList="//div[@id='as_searchtext_freetext_search_form']/ul/li/a[@name='1']";
    String TitleDetailsExpected ="Home Page | Mail Travel";
    public void AcceptCookies()  {
        try{
      Thread.sleep(3000);
      GLOBAL_GENERIC.LocateAndGetElement(xpathOfAcceptCookies).click();}
        catch (InterruptedException e){}
    }

    public void ValidateTitle(){
        String TitleDetailsActual = GLOBAL_STATIC.driver.getTitle();
        Assert.assertEquals(TitleDetailsActual,TitleDetailsExpected);
    }
    public void SearchbarInHomePage(String CountryName)  {
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSearchbar).click();
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSearchbar).sendKeys(CountryName);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectFromCountryList).click();
    }
}
