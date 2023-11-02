package frameWorkOfMailTravel.base;

import frameWorkOfMailTravel.resource.globalResources.GLOBAL_STATIC;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
/**
 ->launching Browser
 ->navigate to URL
 ->load data from properties
 **/
    public void launchBrowser(String Browser)  {
      loadProperties();
     if(Browser==null){
      String BrowserDetails = GLOBAL_STATIC.prop.getProperty("Browser");
      specificBrowser(BrowserDetails);}
      else {
         specificBrowser(Browser);
      }
      GLOBAL_STATIC.driver.get(GLOBAL_STATIC.prop.getProperty("ApplicationURl"));
      GLOBAL_STATIC.driver.manage().window().maximize();
     GLOBAL_STATIC.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    public void specificBrowser(String browserName){
        if (browserName.equals("Chrome")|| browserName.equals("chrome"))
        {
           GLOBAL_STATIC.driver = new ChromeDriver();
        }
        if(browserName.equals("Firefox")|| browserName.equals("firefox")){
           GLOBAL_STATIC.driver=new FirefoxDriver();
        }
        if (browserName.equals("Edge") || browserName.equals("edge")){
          GLOBAL_STATIC.driver=new EdgeDriver();
        }
    }
    public void loadProperties()  {
        try {
            FileInputStream file = new FileInputStream("src/main/java/frameWorkOfMailTravel/config/config.properties");
            GLOBAL_STATIC.prop = new Properties();
            GLOBAL_STATIC.prop.load(file);
        }
        catch (IOException e){}

    }

}
