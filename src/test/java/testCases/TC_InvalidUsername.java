package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_InvalidUsername extends BaseClass
{
    @Test
    public void verifyInvalidUsername() {

        LoginPage lp = new LoginPage(driver);

        lp.login("WrongUser", "admin123");

        String actualMessage = lp.getErrorMessageDisplayed();

        System.out.println("Actual Message is: " + actualMessage);

        Assert.assertEquals(actualMessage,
                            "Invalid credentials");
    }
}

