package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import testBase.BaseClass;

public class TestListener
        extends BaseClass
        implements ITestListener
{

    @Override
    public void onTestFailure(
            ITestResult result)
    {

        String testName =
                result.getName();

        System.out.println(
                "FAILED : "
                + testName);

        captureScreen(testName);
    }
}