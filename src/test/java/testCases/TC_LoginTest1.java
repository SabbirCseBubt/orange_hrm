//package testCases;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import pageObjects.DashboardPage;
//import pageObjects.LoginPage;
//import testBase.BaseClass;
//
//public class TC_LoginTest1 extends BaseClass 
//{
//  @Test
//  public void verifyLogin() 
//  {
//	  
//	  //create login page object
//	  LoginPage lp = new LoginPage(driver);
//	  lp.setUserName("Admin");
//	  lp.setpassword("admin123");
//	  lp.clickLogin();
//	  
//	  // Create Dashboard Page Object
//	  DashboardPage dp = new DashboardPage(driver);
//	  
//	  //validation
//	  Assert.assertTrue(dp.isDasboardDisplayed(),
//              "Login Failed");
//	  
//  }
//}
