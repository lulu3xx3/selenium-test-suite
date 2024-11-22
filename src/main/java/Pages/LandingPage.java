package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;

public class LandingPage extends BaseTest {
    WebDriver driver;



    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openURL(String url){
        driver.get(url);
    }



}
