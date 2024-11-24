package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

public class SignupLoginPage extends BaseTest {
    WebDriver driver;

    @FindBy(css = "input[name='name']")
    WebElement signupNameField;

    @FindBy(xpath = "//form[@action='/signup']//input[@type='email']")
    WebElement signupEmailField;

    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    WebElement signupSubmitButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement signInEmailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement signInPasswordField;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement signInButton;



    public SignupLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterNameEmailAndClickSignup(String signupName, String signupEmail){
        signupNameField.sendKeys(signupName);
        signupEmailField.sendKeys(signupEmail);
        signupSubmitButton.click();
    }

    public void enterEmailPasswordClickSignIn(String signInEmail, String signInPassword ){
       signInEmailField.sendKeys(signInEmail);
       signInPasswordField.sendKeys(signInPassword);
       signInButton.click();
    }




}
