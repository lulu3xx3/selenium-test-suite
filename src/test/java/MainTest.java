import Pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AbstractReusable;
import utils.BaseTest;

public class MainTest extends BaseTest {

    @Test(dataProvider = "DataForTestCase1",groups = "testCase1")
    public void RegisterUser(String gender, String password, String dobDay, String dobMonth, String dobYear,
                             String firstName, String lastName, String companyName, String companyAddress,
                             String countryName, String state, String city, String zipCode, String mobileNumber,String email){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(),"Automation Exercise","The title is not as expected!");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickOnSignupLoginButton();
        String newUserH2 = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        Assert.assertTrue(newUserH2.contains("New User Signup!"),"The h2 message is not as expected!");
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.enterNameEmailAndSubmit(firstName+" "+lastName,email);
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]")).isDisplayed(),"Enter Account Info text is not present!");
        SignupPage signupPage = new SignupPage(driver);
        signupPage.enterSignupInfo(gender,password,dobDay,dobMonth,dobYear,firstName,lastName,companyName,companyAddress,countryName,state,city,zipCode,mobileNumber);
        String accountCreatedText = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).getText();
        Assert.assertTrue(accountCreatedText.contains("ACCOUNT CREATED!"),"The h2 is not as expected!");
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickContinueButton();
        abstractReusable.clickDeleteAccount();
        String accountDeletedText = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).getText();
        Assert.assertTrue(accountDeletedText.contains("ACCOUNT DELETED!"),"The h2 message is not as expected!");
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        accountDeletedPage.clickOnContinueButton();

    }




    @DataProvider(name = "DataForTestCase1")
    public Object[][] accountCreationData() {
        return new Object[][] {
                {"male", "password123", "8", "April", "2000", "Rama", "Krishna",
                        "Sri Rama Krishna", "opposite TCS", "United States", "Andhra Pradesh",
                        "Bhimavaram", "534201", "6696969696","ramaKrishna5@gmail.com"},

                {"female", "password456", "15", "May", "1995", "Sita", "Devi",
                        "Sita Corporation", "near Infosys", "India", "Karnataka",
                        "Bangalore", "560001", "9876543210","sitadevi@yahoo.com"},

                {"male", "password789", "12", "June", "1988", "Lakshman", "Prasad",
                        "Lakshman Solutions", "beside Wipro", "India", "Tamil Nadu",
                        "Chennai", "600001", "8765432109","lakshmiprasad@working.com"},

                {"female", "password321", "22", "July", "1993", "Radha", "Krishna",
                        "Radha Industries", "opposite Cognizant", "United States", "California",
                        "San Francisco", "94105", "7654321098","radhakrishna@hotmail.com"}
        };
    }






}
