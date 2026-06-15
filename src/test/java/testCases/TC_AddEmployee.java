package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddEmployeePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC_AddEmployee  extends BaseClass
{
	
	@Test
	
	public void verifyAddEmployee() 
	{
		//login
		
		LoginPage lp= new LoginPage(driver);
		lp.login("Admin", "admin123");
		
		
		//navigate to Pim
		
		PIMPage pim = new PIMPage(driver);
		pim.clickPim();
		pim.clickAddEmployee();
		
		
		//add employee 
		
		AddEmployeePage addEmp = new AddEmployeePage(driver);
		
		addEmp.addEmployee("Syed", "Sanaul", "Haque", "12345");
		
		
		//validation
		Assert.assertTrue(addEmp.isPersonalDetailsDisplayed(),"Employee not added");
		
	}

}
