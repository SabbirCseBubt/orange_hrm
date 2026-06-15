package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_InvalidPassword  extends BaseClass
{
	

    @Test
    public void verifyInvalidPassword() {

        LoginPage lp = new LoginPage(driver);

        lp.login("Admin", "wrong123");

        String actualMessage = lp.getErrorMessageDisplayed();

        System.out.println("Actual Message is: " + actualMessage);

        Assert.assertEquals(actualMessage,
                            "Invalid credentials");
    }
}	
	


