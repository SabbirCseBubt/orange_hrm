package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class DashboardPage2  extends BaseClass
{

	  By txtSearch=By.xpath("//input[@placeholder='Search']");
	  By menuresults=By.xpath("//ul//li");
	  
	  public DashboardPage2(WebDriver driver) {
		// TODO Auto-generated constructor stub
		  this.driver = driver;
		  
	}


	public void enterSearchText(String value) 
	  {
		  
		  driver.findElement(txtSearch).clear();
		  driver.findElement(txtSearch).sendKeys(value);
		  
		  
	  }
	  
	  
	  public List<String> getSearchResults()
	  {
		  
	    List<WebElement> elements= driver.findElements(menuresults); 
	    return elements.stream().map(WebElement::getText)
	    		.collect(Collectors.toList());
		  
	  }
	  
	
	
	
}
