package pageObjects;

import baseClass.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    LoginPage loginPage;
    @FindBy(id="input-email") WebElement emailInput;
    @FindBy(id="input-password") WebElement passwordInput;
    @FindBy(xpath="//input[@value='Login']") WebElement loginButton;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    public void enterUsername(String uname)
    {
        emailInput.sendKeys(uname);
    }
    public void enterPassword(String password)
    {
        passwordInput.sendKeys(password);
    }
    public void clickLogin()
    {
        loginButton.click();
    }
}
