package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage
{

  
  
  //constructor
   public LoginPage(WebDriver driver) 
   {
	 super(driver);
	   
   }
   
   
   //locators
   
   @FindBy(name="username")
   WebElement txtUsername;
   
   @FindBy(name="password")
   WebElement txtPassword;
   

   @FindBy(xpath = "//button[@type='submit']")
   WebElement btnLogin;
   
   @FindBy(css = "p.oxd-alert-content-text")
   WebElement errorMessage;

   @FindBy(xpath = "//span[text()='Required']")
   WebElement requiredMessage;

   
   
   //Action methods
   public void login(String username, String password) 
   {
	   
	   txtUsername.clear();
	    txtPassword.clear();

	    txtUsername.sendKeys(username);
	    txtPassword.sendKeys(password);

	    btnLogin.click();
	   
	   
   }
   
   
   // Error Message
   
   public String getErrorMessageDisplayed() 
   {
	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(errorMessage));
	   
	   return errorMessage.getText();
   }
   
   
   //required validation
   public boolean isRequiredMessageDisplayed() 
   {
	   
	   return requiredMessage.isDisplayed();
   }

}
