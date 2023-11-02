package testsOfMailTravel;

import frameWorkOfMailTravel.base.Base;
import frameWorkOfMailTravel.resource.globalResources.GLOBAL_STATIC;
import frameWorkOfMailTravel.resource.mailTravelResources.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;

public class mailTravelTestsWithCrossBrowserTesting extends Base {
    HomePageResources Hpr;
    BookingOverviewPageResources Bop;
    BookingDetailsPageResources Bdp;
    PassengerDetailsPageResources Pdp;
    ConformationPageResources Cpr;

    String NumberOfAdultsOnOverviewPage;
    String NumberOfAdultsOnDetailsPage;
    String AirportNameOnOverviewPage;
    String AirportNameOnDetailsPage;
    LocalDate DateOnOverviewPage;
    LocalDate DateOnDetailsPage;
    @Parameters({"Browser"})
    @BeforeTest
    public void setup(String Browser) {
        launchBrowser(Browser);
        Hpr=new HomePageResources();
        Bop=new BookingOverviewPageResources();
        Bdp=new BookingDetailsPageResources();
        Pdp=new PassengerDetailsPageResources();
        Cpr=new ConformationPageResources();

    }

    @Test( priority = 0)
    public void validateTitleOnHomePage()  {
        Hpr.AcceptCookies();
        Hpr.ValidateTitle();

    }

    @Test(priority = 1)
    public void validateSearchbarOnHomePage()  {
        Hpr.SearchbarInHomePage("Ind");
    }

    @Test(priority = 2)
    public void validateBookingPageOnBookingOverViewPage()  {
        Bop.clickOnBookButton();
        Bop.PopupMessageValidation();
        Bop.DepartureDetails();
        Bop.priceValidation(2);
        NumberOfAdultsOnOverviewPage = Bop.getCountOfAdults();
        AirportNameOnOverviewPage = Bop.getDetailsOfAirport();
        DateOnOverviewPage= Bop.getDetailsOfDate();
        Bop.ValidateBookButton();

    }
    @Test(priority = 3)
    public void validateDateDeparturePassengerListOnBookingDetailsPage()  {
        NumberOfAdultsOnDetailsPage = Bdp.getCountOfAdult();
        AirportNameOnDetailsPage = Bdp.getDepartureAirportDetails();
        DateOnDetailsPage=Bdp.getsDetailsOfDate();
        Assert.assertEquals(NumberOfAdultsOnOverviewPage,NumberOfAdultsOnDetailsPage);
        Assert.assertEquals(AirportNameOnOverviewPage,AirportNameOnDetailsPage);
        Assert.assertEquals(DateOnOverviewPage.getDayOfMonth(),DateOnDetailsPage.getDayOfMonth());
        Assert.assertEquals(DateOnOverviewPage.getMonth(),DateOnDetailsPage.getMonth());
        Assert.assertEquals(DateOnOverviewPage.getYear(),DateOnDetailsPage.getYear());
        Bdp.AccommodationDetails();
    }
    @Test(priority = 4)
    public void ValidatePassengerDetailsPage()  {
        Pdp.PassengerDetailsFillUp(1,"Mrs","mail","Travel",24,3,1997);
        Pdp.PassengerDetailsFillUp(2,"Mr","online","Book",12,5,1996);
        Pdp.loadContactDetails("123456778","mail@gmail.com","Add","Add2","city","00000");
    }
    @Test(priority = 5)
    public void validateConformationPage(){
        Cpr.ConformationHeader();
        Cpr.validateBookButton();

    }

    @AfterTest
    public void Teardown()  {
        GLOBAL_STATIC.driver.close();
    }
}