package pageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class RegisterPage extends BasePage{

    Faker faker = new Faker();
    @FindBy(name="firstname")  WebElement firstnameInput;
    @FindBy(name="lastname")  WebElement lastnameInput;
    @FindBy(name="email")  WebElement emailInput;
    @FindBy(name="telephone")  WebElement telephoneInput;
    @FindBy(name="password")  WebElement passwordInput;
    @FindBy(name="confirm")  WebElement confirmPasswordInput;
    @FindBy(xpath="//input[@name='newsletter' and @value=1]")  WebElement newsletterYesCheckbox;
    @FindBy(name="agree")  WebElement agreeProvacyPolicyCheckbox;
    @FindBy(xpath="//input[@value='Continue']")  WebElement continueButton;

    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }
    public String password;
    public String email;
    public void enterFirstname(){
        firstnameInput.sendKeys(faker.name().firstName());
    }
    public void enterLastname(){
        lastnameInput.sendKeys(faker.name().lastName());
    }
    public void enterEmail(){
        email = faker.internet().emailAddress();
        emailInput.sendKeys(email);
        System.out.println(email);
    }
    public void enterTelephone(){
        telephoneInput.sendKeys(faker.phoneNumber().cellPhone());
    }
    public void enterPassword(){
        password = faker.internet().password(6,10,true,true, true);
        passwordInput.sendKeys(password);
        System.out.println("Password : " + password);
    }
    public void enterConfirmPassword(){
        confirmPasswordInput.sendKeys(password);
    }
    public void tickYesCheckbox(){
        newsletterYesCheckbox.click();
    }
    public void tickPrivacyPolicy()
    {
        agreeProvacyPolicyCheckbox.click();
    }
    public void clickContinue()
    {
        continueButton.click();
    }
}
