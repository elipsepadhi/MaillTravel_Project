package stepDefinition.hooks;
import io.cucumber.java.*;
import resource.globalResources.GLOBAL_STATIC;

public class Hook {
       @AfterAll
    public static void TearDown(){
        GLOBAL_STATIC.driver.close();
    }

}

