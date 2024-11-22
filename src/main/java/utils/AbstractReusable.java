package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AbstractReusable extends BaseTest{
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/login']")
    WebElement signupLoginButton;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    WebElement deleteAccountButton;

    public AbstractReusable(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnSignupLoginButton(){
        signupLoginButton.click();
    }

    public void clickDeleteAccount(){
        deleteAccountButton.click();
    }


}
