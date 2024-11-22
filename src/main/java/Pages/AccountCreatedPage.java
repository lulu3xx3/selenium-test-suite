package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

public class AccountCreatedPage extends BaseTest {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continueButton;

    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}
