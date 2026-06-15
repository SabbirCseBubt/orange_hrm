package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPage extends BasePage
{

    // constructor

    public EmployeeListPage(WebDriver driver)
    {
        super(driver);
    }

    // Employee List Menu

    @FindBy(xpath="//a[text()='Employee List']")
    WebElement employeeListMenu;

    // Employee Name Search Box

    @FindBy(xpath ="(//input[@placeholder='Type for hints...'])[1]")
    WebElement txtEmployeeName;

    // Search Button

    @FindBy(xpath="//button[normalize-space()='Search']")
    WebElement btnSearch;

    // Record Found

    @FindBy(xpath ="//div[@class='oxd-table-card']")
    WebElement searchResult;

    // Table Rows

    By rows =
            By.xpath("//div[@class='oxd-table-body']/div");

    // Click Employee List

    public void clickEmployeeList()
    {
        employeeListMenu.click();
    }

    // Search Employee

    public void searchEmployee(String empName)
    {
        txtEmployeeName.sendKeys(empName);

        btnSearch.click();
    }

    // Validation

    public boolean isEmployeeFound()
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOf(searchResult));

        return searchResult.isDisplayed();
    }

    // Print Employees

    public void printCurrentPageEmployees()
    {
        List<WebElement> allRows =
                driver.findElements(rows);

        System.out.println(
                "Total Rows in Current Page: "
                + allRows.size());

        for(int i = 1; i <= allRows.size(); i++)
        {
            String empId = driver.findElement(
                    By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//div[2]"))
                    .getText();

            String firstName = driver.findElement(
                    By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//div[3]"))
                    .getText();

            String lastName = driver.findElement(
                    By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//div[4]"))
                    .getText();

            System.out.println(
                    empId + " | "
                    + firstName + " | "
                    + lastName);
        }
    }

    // Check Employee Exists

    public boolean employeeExists(String targetId)
    {
        while(true)
        {
            List<WebElement> allRows =
                    driver.findElements(rows);

            for(int i = 1; i <= allRows.size(); i++)
            {
                String empId = driver.findElement(
                        By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//div[2]"))
                        .getText();

                System.out.println(
                        "Checking Employee ID: "
                        + empId);

                if(empId.equals(targetId))
                {
                    return true;
                }
            }

            // Next Page Button

            List<WebElement> nextButtons =
                    driver.findElements(
                    By.xpath("//button[contains(@class,'oxd-pagination-page-item--previous-next')]"));

            if(nextButtons.size() > 1 &&
                    nextButtons.get(1).isEnabled())
            {
                nextButtons.get(1).click();

                try
                {
                    Thread.sleep(2000);
                }
                catch(Exception e)
                {

                }
            }
            else
            {
                break;
            }
        }

        return false;
    }

    // Delete Employee By ID

    public boolean deleteEmployeeById(String targetId)
    {
        while(true)
        {
            List<WebElement> allRows =
                    driver.findElements(rows);

            for(int i = 1; i <= allRows.size(); i++)
            {
                String empId = driver.findElement(
                        By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//div[2]"))
                        .getText();

                String firstName = driver.findElement(
                        By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//div[3]"))
                        .getText();

                String lastName = driver.findElement(
                        By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//div[4]"))
                        .getText();

                System.out.println(
                        "Checking: "
                        + empId + " | "
                        + firstName + " | "
                        + lastName);

                // Match Found

                if(empId.equals(targetId))
                {
                    System.out.println("Employee Found");

                    // Click Delete Icon

                    driver.findElement(
                            By.xpath("(//div[@class='oxd-table-body']/div)[" + i + "]//button[2]"))
                            .click();

                    // Confirm Delete

                    driver.findElement(
                            By.xpath("//button[normalize-space()='Yes, Delete']"))
                            .click();

                    return true;
                }
            }

            // Next Page Button

            List<WebElement> nextButtons =
                    driver.findElements(
                    By.xpath("//button[contains(@class,'oxd-pagination-page-item--previous-next')]"));

            if(nextButtons.size() > 1 &&
                    nextButtons.get(1).isEnabled())
            {
                System.out.println("Moving To Next Page");

                nextButtons.get(1).click();

                try
                {
                    Thread.sleep(2000);
                }
                catch(Exception e)
                {

                }
            }
            else
            {
                break;
            }
        }

        return false;
    }
}