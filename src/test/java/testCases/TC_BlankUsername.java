package testCases;

import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_BlankUsername extends BaseClass

{

	@Test
	
	public void verifyBlankUsername() 
	{
		
		LoginPage lp = new LoginPage(driver) ;
		lp.login("", "admin123");
		
		Assert.assertTrue(lp.isRequiredMessageDisplayed());
		
		
	}
	
	
	
}
