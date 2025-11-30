package testCases;

import baseClass.WebDriverBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.TestDataProvider;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends WebDriverBase {

   LoginPage loginPage;
   HomePage homePage;

   @Test(groups = "@Regression")
    public void testUserLogin()
   {
       log.info("Validate user login");
       homePage = new HomePage(driver);
       loginPage = new LoginPage(driver);
       homePage.clickOnMyAccountLink();
       homePage.clickOnLogin();
       log.info("User navigated to login page");
       loginPage.enterUsername("vicente.wisozk@yahoo.com");
       loginPage.enterPassword("Feg4%5");
       loginPage.clickLogin();
       log.info("user clicked on Login button");
       assertEquals("User is not successfully logged in",
               "https://tutorialsninja.com/demo/index.php?route=account/account",
               driver.getCurrentUrl());
   }
    // Data driven testing
   @Test(dataProvider = "UserAccounts", dataProviderClass = TestDataProvider.class)
   public void testDataDrivenUserLogin(String uname, String password) throws InterruptedException {
       log.info("Validate data driven user login");
       homePage = new HomePage(driver);
       loginPage = new LoginPage(driver);
       homePage.clickOnMyAccountLink();
       homePage.clickOnLogin();
       log.info("User navigated to login page");
       loginPage.enterUsername(uname);
       loginPage.enterPassword(password);
       loginPage.clickLogin();
       Thread.sleep(200);
       log.info("user clicked on Login button");
       assertEquals("User is not successfully logged in",
               "https://tutorialsninja.com/demo/index.php?route=account/account",
               driver.getCurrentUrl());
   }

}
