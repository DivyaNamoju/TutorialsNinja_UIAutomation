package testCases;

import baseClass.WebDriverBase;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

import static org.testng.AssertJUnit.assertEquals;

public class RegisterPageTest extends WebDriverBase {

//    Email : vicente.wisozk@yahoo.com
//    Password : Feg4%5
    RegisterPage registerPage ;
    HomePage homePage;
    @Test
    public void testRegisterUser() throws InterruptedException {
        log.info("Test to validate the user registration");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.clickOnMyAccountLink();
        homePage.clickOnRegister();
        log.info("User navigated to Register page");
        registerPage.enterFirstname();
        registerPage.enterLastname();
        registerPage.enterEmail();
        registerPage.enterTelephone();
        registerPage.enterPassword();
        registerPage.enterConfirmPassword();
        registerPage.tickYesCheckbox();
        registerPage.tickPrivacyPolicy();
        registerPage.clickContinue();
        log.info("User clicked on Continue button");
        Thread.sleep(2000);
        assertEquals("User is not successfully registered", "https://tutorialsninja.com/demo/index.php?route=account/success",
                driver.getCurrentUrl());
    }

}
