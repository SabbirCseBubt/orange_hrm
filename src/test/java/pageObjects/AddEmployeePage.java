package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends BasePage
{
	
	//constructor
	
	public AddEmployeePage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	//locators
	
	@FindBy(name="firstName")
	WebElement txtFristName;
	
	@FindBy(name="middleName")
	WebElement txtMiddleName;
	
	
	@FindBy(name="lastName")
	WebElement txtLastName;
	
	@FindBy(xpath = "(//label[text()='Employee Id']/following::input[1])")
	WebElement txtEmployeeId;

	// Save Button

	 @FindBy(xpath = "//button[@type='submit']")
	 WebElement btnSave;
	 
	 //personal details 
	 @FindBy(xpath = "//a[text()='Personal Details']")
	 WebElement personalDetailsHeader;
	 
	 
	 //add employee method
	 
	 public void addEmployee(String fname, String mname, String lname, String empid) 
	 {
		 
		 txtFristName.sendKeys(fname);
		 txtMiddleName.sendKeys(mname);
		 txtLastName.sendKeys(lname);
		 txtEmployeeId.clear();
		 txtEmployeeId.sendKeys(empid);
		 btnSave.click();
		 
	 }
	 
	 
	 //validation 
	 
	 public boolean isPersonalDetailsDisplayed() 
	 {
		 
		 return personalDetailsHeader.isDisplayed();
		 
	 }
	    
	    
	    
	    

}
