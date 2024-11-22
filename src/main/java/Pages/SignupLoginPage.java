package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

public class SignupLoginPage extends BaseTest {
    WebDriver driver;

    @FindBy(css = "input[name='name']")
    WebElement nameField;

    @FindBy(xpath = "//form[@action='/signup']//input[@type='email']")
    WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    WebElement submitButton;

    public SignupLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterNameEmailAndSubmit(String name, String email){
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        submitButton.click();

    }
}
