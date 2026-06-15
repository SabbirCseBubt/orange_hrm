package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage extends BasePage
{

	
      //constructor	


	    public DashboardPage(WebDriver driver) {

	        super(driver);

	     
	    }
	    
	    
	    //locator
	    
	    @FindBy(xpath="//h6[text()='Dashboard']")
	    WebElement dashboardText;
	    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	    WebElement userMenu;
	    
	    @FindBy(xpath="//a[text()='Logout']")
	    WebElement logoutLink;
	    
	    //action method
	    public boolean isDasboardDisplayed() 
	    {
	    	
	    	return dashboardText.isDisplayed();
	    }
	    
	    
	    public void logout()
	    {
	        userMenu.click();

	        WebDriverWait wait =
	                new WebDriverWait(driver,
	                        Duration.ofSeconds(10));

	        wait.until(
	                ExpectedConditions
	                        .elementToBeClickable(logoutLink)
	        );

	        logoutLink.click();

}
	    
}
