import Pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AbstractReusable;
import utils.BaseTest;

public class MainTest extends BaseTest {

    @Test
    public void mainTest(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(),"Automation Exercise","The title is not as expected!");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickOnSignupLoginButton();
        String newUserH2 = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        Assert.assertTrue(newUserH2.contains("New User Signup!"),"The h2 message is not as expected!");
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.enterNameEmailAndSubmit("rama","ramaKrishna5@gmail.com");
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]")).isDisplayed(),"Enter Account Info text is not present!");
        SignupPage signupPage = new SignupPage(driver);
        signupPage.enterSignupInfo("male","ramaKrishna","8","April","2000","Rama","Krishna","Sri Rama Krishna","opposite TCS","United States","Andhra Pradesh","Bhimavaram","534201","6696969696");
        String accountCreatedText = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).getText();
        Assert.assertTrue(accountCreatedText.contains("ACCOUNT CREATED!"),"The h2 is not as expected!");
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickContinueButton();
        abstractReusable.clickDeleteAccount();
        String accountDeletedText = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).getText();
        Assert.assertTrue(accountDeletedText.contains("ACCOUNT DELETED!"),"The h2 message is not as expected!");
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        accountDeletedPage.clickOnContinueButton();
        System.out.println("um okay");





    }



}
