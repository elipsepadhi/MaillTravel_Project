package frameWorkOfMailTravel.utilities.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test got failed "+result.getThrowable());
    }



}
