package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountLink;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginLink;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    public void clickOnMyAccountLink()
    {
        myAccountLink.click();
    }
    public void clickOnRegister()
    {
        registerLink.click();
    }
    public void clickOnLogin()
    {
        loginLink.click();
    }
}
