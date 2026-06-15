package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC_DeleteEmployee extends BaseClass {

    @Test
    public void deleteEmployeeTest()
    {
        // Login

        LoginPage lp =
                new LoginPage(driver);

        lp.login("Admin", "admin123");

        // Navigate to PIM

        PIMPage pim =new PIMPage(driver);

        pim.clickPim();

        // Employee List

        EmployeeListPage empList =
                new EmployeeListPage(driver);

        empList.clickEmployeeList();

        // Employee Page Object

        EmployeeListPage emp =
                new EmployeeListPage(driver);

        // Print Employees From Current Page

        emp.printCurrentPageEmployees();

        // Delete Employee

        boolean status =
                emp.deleteEmployeeById("0468");

        // Verify Employee Found

        Assert.assertTrue(status,
                "Employee not found");


        driver.navigate().refresh();

        // Verify Employee Removed

        Assert.assertFalse(
                emp.employeeExists("0468"),
                "Employee still exists after delete");
    }
}