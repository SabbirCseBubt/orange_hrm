package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_DDT_Login extends BaseClass
{
    @BeforeMethod
    public void openLoginPage()
    {
        driver.get(
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );
    }

    @Test(
            dataProvider = "LoginData",
            dataProviderClass = DataProviders.class
    )
    public void verifyLogin(
            String username,
            String password,
            String expected)
    {

        LoginPage lp =
                new LoginPage(driver);

        lp.login(username,password);

        DashboardPage dp =
                new DashboardPage(driver);

        boolean status;

        try
        {
            status =
                    dp.isDasboardDisplayed();
        }
        catch(Exception e)
        {
            status = false;
        }

        if(expected.equalsIgnoreCase("Valid"))
        {
            Assert.assertTrue(
                    status,
                    "Valid Login Failed");

            dp.logout();
        }
        else
        {
            Assert.assertFalse(
                    status,
                    "Invalid Login Passed");
        }
    }
}