package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC_SearchEmployee extends BaseClass {

    @Test
    public void verifySearchEmployee() {

        // Login

        LoginPage lp = new LoginPage(driver);

        lp.login("Admin", "admin123");

        // Navigate to PIM

        PIMPage pim = new PIMPage(driver);

        pim.clickPim();;

        // Employee List Page

        EmployeeListPage empList =
                new EmployeeListPage(driver);

        empList.clickEmployeeList();

        // Search Employee

        empList.searchEmployee("John");

        // Validation

        Assert.assertTrue(
                empList.isEmployeeFound(),

                "Employee not found");
    }
}