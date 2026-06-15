package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_ValidLogin extends BaseClass
{
	
	@Test
	
	public void verifyLogin() 
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.login("Admin", "admin123");
		
		  DashboardPage dp = new DashboardPage(driver);
		  //validation
		  Assert.assertTrue(dp.isDasboardDisplayed(),
	              "Login Failed");
		
	}

}
