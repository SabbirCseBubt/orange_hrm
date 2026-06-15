package testCases;

import java.util.List;

import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.DashboardPage2;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_SearchMenuValidation extends BaseClass
{
	
	@Test
	
	public void verifySearchOptions () 
	{
		
		LoginPage lp = new LoginPage(driver);
		
		lp.login("Admin", "admin123");
		
		
		DashboardPage2 dp2= new DashboardPage2(driver);
		
		dp2.enterSearchText("Admin");
		
		List <String> actualResults = dp2.getSearchResults();
        
		boolean found = actualResults.stream().anyMatch(x -> x.contains("Admin"));
		
		Assert.assertTrue(found,"Admin option not found in search Results");
		
		
	}
	
	
}
