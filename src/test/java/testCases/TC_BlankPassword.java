package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_BlankPassword extends BaseClass
{
	
	@Test
	
	public void verifyBlankPassword() 
	{
		LoginPage lp= new LoginPage(driver);
		lp.login("Admin", "");
		Assert.assertTrue(lp.isRequiredMessageDisplayed());
		
		
		
	}

}
