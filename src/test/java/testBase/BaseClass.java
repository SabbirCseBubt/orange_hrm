package testBase;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public WebDriver driver;
	
	@BeforeClass
	 public void setup() 
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@AfterClass
	 public void tearDown() 
	{
	    driver.quit();
		
	}
	
	
	public String captureScreen(String testName)
	{

	    String path =
	            System.getProperty("user.dir")
	            + "\\screenshots\\"
	            + testName + "_"
	            + System.currentTimeMillis()
	            + ".png";

	    try
	    {
	        TakesScreenshot ts =
	                (TakesScreenshot) driver;

	        File source =
	                ts.getScreenshotAs(OutputType.FILE);

	        File target =
	                new File(path);

	        FileUtils.copyFile(source, target);

	        System.out.println(
	                "Screenshot Saved : "
	                + path);

	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }

	    return path;
	}

}
