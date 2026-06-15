package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ConfigurationPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC_EditAllOptionalFields
        extends BaseClass {

    @Test
    public void editAllOptionalFieldsTest()
    {
        // Login

        LoginPage lp =
                new LoginPage(driver);

        lp.login("Admin", "admin123");

        // PIM

        PIMPage pim =
                new PIMPage(driver);

        pim.clickPim();

        // Open Configuration

        pim.clickConfiguration();

        // Configuration Page

        ConfigurationPage config =
                new ConfigurationPage(driver);

        // Print Dropdown Options

        config.printAllDropdownOptions();

        // Open Optional Fields

        config.clickDropdownOption(
                "Optional Fields");

        // Click Toggles

        boolean status =
                config.toggleAllFields();

        // Validation

        Assert.assertTrue(
                status,
                "Toggle click failed");

        // Save

        config.clickSave();

        System.out.println(
                "All Toggles Clicked Successfully");
    }
}