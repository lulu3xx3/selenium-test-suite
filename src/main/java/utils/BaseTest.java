package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;


    @BeforeMethod
    public void  startDriver(){
        if(driver==null){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
    }

    @AfterMethod
    public void closeDriver(){
        if(driver!=null){
            driver.close();
            driver=null;
        }
    }
}
