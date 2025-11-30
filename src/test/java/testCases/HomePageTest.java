package testCases;

import baseClass.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import static org.testng.AssertJUnit.assertEquals;

public class HomePageTest extends WebDriverBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @Test
    public void testMyAccountLink()
    {
        log.info("Test to validate myAccount link");
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountLink();
        System.out.println(driver.getTitle());
    }
    @Test(priority = 1)
    public void testRegisterLink()
    {
        log.info("Test to validate Register link");
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountLink();
        homePage.clickOnRegister();
        assertEquals("User is not on Register URL", "https://tutorialsninja.com/demo/index.php?route=account/register", driver.getCurrentUrl());
    }
    @Test(priority = 2)
    public void testLoginLink()
    {
        log.info("Test to validate Login link");
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountLink();
        homePage.clickOnLogin();
        assertEquals("User is not on Register URL", "https://tutorialsninja.com/demo/index.php?route=account/login", driver.getCurrentUrl());
    }
}
