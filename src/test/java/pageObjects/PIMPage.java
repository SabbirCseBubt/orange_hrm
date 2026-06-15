package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage extends BasePage
{

	//constructor
	 public PIMPage (WebDriver driver)
	 {
		 
		 super(driver);
		 
	 }
	 
	 
	 
	 //locators
	 
	 @FindBy(xpath = "//span[normalize-space()='PIM']")
	 WebElement pimMenu;
	 
	 //add employee button
	 
      @FindBy(xpath = "//a[text()='Add Employee']")
	  WebElement addEmployeeBtn;
      
      @FindBy(xpath="//li[contains(.,'Configuration')]")
      WebElement configDropdown;
      
      public void clickPim()
      {
          WebDriverWait wait =
                  new WebDriverWait(driver,
                          Duration.ofSeconds(10));

          wait.until(
                  ExpectedConditions.visibilityOf(pimMenu));

          pimMenu.click();
      }
  
      public void clickAddEmployee() 
      {
    	  
    	  
    	  addEmployeeBtn.click();
    	  
      }
      
      //click configuration
      public void clickConfiguration() 
      {
    	  
    	  configDropdown.click();
    	  
      }
	 
	
}
