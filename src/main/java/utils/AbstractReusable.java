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

    @FindBy(css = "a[href*='logout']")
    WebElement logOutButton;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    WebElement contactUsButton;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement testCasesButton;

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

    public void clickLogOutButton(){
        logOutButton.click();
    }

    public void clickContactUsButton(){
        contactUsButton.click();
    }

    public void clickTestCasesButton(){
        testCasesButton.click();
    }

}
