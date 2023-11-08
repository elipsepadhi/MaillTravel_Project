package resource.mailTravelResources;

import org.junit.Assert;
import resource.globalResources.GLOBAL_GENERIC;
import resource.globalResources.GLOBAL_STATIC;


public class HomePageResources {
    /**
     ->Accept all cookies
     ->Validate Title
     ->search for specific country
     **/
    static   String xpathOfAcceptCookies="//button[text()='Accept All Cookies']";
    static   String xpathOfSearchbar="//div[@id='freetext_search_form']/form/input[@class='nbf_tpl_quicksearch_searchtext']";
    static String xpathOfSelectFromCountryList="//div[@id='as_searchtext_freetext_search_form']/ul/li/a[@name='1']";
    static String TitleDetailsExpected ="Home Page | Mail Travel";
    public static void AcceptCookies()  {
        try{
      Thread.sleep(3000);
      GLOBAL_GENERIC.LocateAndGetElement(xpathOfAcceptCookies).click();}
        catch (InterruptedException e){}
    }

    public static void ValidateTitle() {
        String TitleDetailsActual = GLOBAL_STATIC.driver.getTitle();
        Assert.assertEquals(TitleDetailsActual,TitleDetailsExpected);
    }
    public static void SearchbarInHomePage(String countryName)  {
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSearchbar).click();
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSearchbar).sendKeys(countryName);
        GLOBAL_GENERIC.LocateAndGetElement(xpathOfSelectFromCountryList).click();
    }
}
