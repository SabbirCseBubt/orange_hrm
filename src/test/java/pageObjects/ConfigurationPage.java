package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigurationPage extends BasePage {

    public ConfigurationPage(WebDriver driver)
    {
        super(driver);
    }

    // Dropdown Options

    By menuItems =
            By.xpath("//ul[@class='oxd-dropdown-menu']/li");

    // Toggle Switches

    By allToggles =
            By.xpath("//span[contains(@class,'oxd-switch-input')]");

    // Save Button

    @FindBy(xpath="//button[@type='submit']")
    WebElement btnSave;

    // Click Dropdown Option

    public void clickDropdownOption(String optionName)
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        menuItems));

        List<WebElement> allOptions =
                driver.findElements(menuItems);

        for(WebElement option : allOptions)
        {
            String text =
                    option.getText();

            System.out.println(text);

            if(text.equals(optionName))
            {
                option.click();

                break;
            }
        }
    }

    // Print Dropdown Options

    public void printAllDropdownOptions()
    {
        List<WebElement> allOptions =
                driver.findElements(menuItems);

        System.out.println(
                "Total Dropdown Options: "
                + allOptions.size());

        for(WebElement option : allOptions)
        {
            System.out.println(option.getText());
        }
    }

    // Toggle All Fields

    public boolean toggleAllFields()
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        allToggles));

        List<WebElement> toggles =
                driver.findElements(allToggles);

        System.out.println(
                "Total Toggles Found: "
                + toggles.size());

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        boolean status = false;

        try
        {
            for(WebElement toggle : toggles)
            {
                js.executeScript(
                        "arguments[0].click();",
                        toggle);

                Thread.sleep(1000);

                status = true;

                System.out.println(
                        "Toggle Clicked Successfully");
            }

            return status;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    // Click Save

    public void clickSave()
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        btnSave));

        btnSave.click();

        System.out.println(
                "Save button clicked");
    }
}