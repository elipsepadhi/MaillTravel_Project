package frameWorkOfMailTravel.resource.globalResources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GLOBAL_GENERIC {
    public static WebElement LocateAndGetElement(String xpathOfWebElement){

     WebElement element  = GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfWebElement));

     return element;
    }


}
