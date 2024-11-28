import Pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AbstractReusable;
import utils.BaseTest;

import java.util.Objects;

public class MainTest extends BaseTest {

    //requires input of sign up details
    //@Test(dataProvider = "DataForTestCase1", groups = "testCase1")
    public void RegisterUser(String gender, String password, String dobDay, String dobMonth, String dobYear,
                             String firstName, String lastName, String companyName, String companyAddress,
                             String countryName, String state, String city, String zipCode, String mobileNumber, String email) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "The title is not as expected!");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickOnSignupLoginButton();
        String newUserH2 = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        Assert.assertTrue(newUserH2.contains("New User Signup!"), "The h2 message is not as expected!");
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.enterNameEmailAndClickSignup(firstName + " " + lastName, email);
        Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]")).isDisplayed(), "Enter Account Info text is not present!");
        SignupPage signupPage = new SignupPage(driver);
        signupPage.enterSignupInfo(gender, password, dobDay, dobMonth, dobYear, firstName, lastName, companyName, companyAddress, countryName, state, city, zipCode, mobileNumber);
        String accountCreatedText = driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).getText();
        Assert.assertTrue(accountCreatedText.contains("ACCOUNT CREATED!"), "The h2 is not as expected!");
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickContinueButton();
        abstractReusable.clickDeleteAccount();
        String accountDeletedText = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).getText();
        Assert.assertTrue(accountDeletedText.contains("ACCOUNT DELETED!"), "The h2 message is not as expected!");
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        accountDeletedPage.clickOnContinueButton();

    }


    //test below needs input of valid emails with passwords to work
    //@Test(dataProvider = "DataForTestCase2")
    public void loginUserWithCorrectCredentials(String signInEmail, String signInPassword) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickOnSignupLoginButton();
        String loginText = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText();
        Assert.assertEquals(loginText, "Login to your account");
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.enterEmailPasswordClickSignIn(signInEmail, signInPassword);
        String userNameOnWebsite = driver.findElement(By.tagName("b")).getText();
        Assert.assertEquals(userNameOnWebsite, "var");
        abstractReusable.clickDeleteAccount();
        String accountDeletedText = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).getText();
        Assert.assertTrue(accountDeletedText.contains("ACCOUNT DELETED!"), "The h2 message is not as expected!");
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        accountDeletedPage.clickOnContinueButton();


    }

    //data input has to be invalid password or username or both
    //@Test(dataProvider = "DataForTestCase3")
    public void loginUserWithWrongCredentials(String signInEmail, String signInPassword) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickOnSignupLoginButton();
        String loginText = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText();
        Assert.assertEquals(loginText, "Login to your account");
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.enterEmailPasswordClickSignIn(signInEmail, signInPassword);

        String errorMessage = driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
        Assert.assertEquals(errorMessage, "Your email or password is incorrect!");


    }

    //data input has to be valid username and password
    //@Test(dataProvider = "DataForTestCase4")
    public void logoutUser(String signInEmail, String signInPassword){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickOnSignupLoginButton();
        String loginText = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText();
        Assert.assertEquals(loginText, "Login to your account");
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.enterEmailPasswordClickSignIn(signInEmail, signInPassword);
        String loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).getText();
        Assert.assertTrue(loggedInText.contains("Logged in as"));
        abstractReusable.clickLogOutButton();
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("login"));

    }


    //data input provided should be of an existing email id we can reuse the test case 4 data
    //@Test(dataProvider = "DataForTestCase5")
    public void registerUserWithExistingEmail(String email, String name){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "The title is not as expected!");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickOnSignupLoginButton();
        String newUserH2 = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        Assert.assertTrue(newUserH2.contains("New User Signup!"), "The h2 message is not as expected!");
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.enterNameEmailAndClickSignup(name, email);
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed());


    }



    //@Test(dataProvider = "DataForTestCase6")
    public void contactUsForm(String name, String email, String subject, String message,String uploadFilePath){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openURL("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "The title is not as expected!");
        AbstractReusable abstractReusable = new AbstractReusable(driver);
        abstractReusable.clickContactUsButton();
        String getInTouchText = driver.findElement(By.xpath("//h2[contains(text(),'Get In Touch')]")).getText();
        Assert.assertEquals(getInTouchText,"GET IN TOUCH");
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.enterInfoAndSend(name,email,subject,message,uploadFilePath);
        driver.switchTo().alert().accept();
        String successText = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals(successText,"Success! Your details have been submitted successfully.");
        contactUsPage.goBackHome();
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "The title is not as expected!");



    }


    @DataProvider(name = "DataForTestCase1")
    public Object[][] accountCreationData() {
        return new Object[][]{
                {"male", "password123", "8", "April", "2000", "Rama", "Krishna",
                        "Sri Rama Krishna", "opposite TCS", "United States", "Andhra Pradesh",
                        "Bhimavaram", "534201", "6696969696", "ramaKrishna5@gmail.com"},

                {"female", "password456", "15", "May", "1995", "Sita", "Devi",
                        "Sita Corporation", "near Infosys", "India", "Karnataka",
                        "Bangalore", "560001", "9876543210", "sitadevi@yahoo.com"},

                {"male", "password789", "12", "June", "1988", "Lakshman", "Prasad",
                        "Lakshman Solutions", "beside Wipro", "India", "Tamil Nadu",
                        "Chennai", "600001", "8765432109", "lakshmiprasad@working.com"},

                {"female", "password321", "22", "July", "1993", "Radha", "Krishna",
                        "Radha Industries", "opposite Cognizant", "United States", "California",
                        "San Francisco", "94105", "7654321098", "radhakrishna@hotmail.com"}
        };
    }

    @DataProvider(name = "DataForTestCase2")
    public Object[][] accountLoginDataCorrectCredentials() {
        return new Object[][]{
                {"var@var.com", "ramu"},
                {"var@var.com", "ramu"}

        };


    }


    @DataProvider(name = "DataForTestCase3")
    public Object[][] accountLoginDataWrongCredentials() {

        return new Object[][]{
                {"sad@var.com", "????"},
                {"rast@ymail.com", "#@!!"},
                {"tara@hotmail.com", "456874"},
                {"ramakirshna@yaol.com", "#@!!"},
                {"tra@mail.com", "sa"}


        };
    }

    @DataProvider(name = "DataForTestCase4")
    public Object[][] logoutAccountCredentials(){
        return new Object[][]{

                {"var@var.com","sana"},{"dar@dar","sana"}
        };
    }

    @DataProvider(name="DataForTestCase5")
    public Object[][] registerUserExistingEmail(){
        return new Object[][]{

                {"var@var.com","sana"},{"dar@dar","sana"}
        };
    }

    @DataProvider(name="DataForTestCase6")
    public Object[][] contactUsFormData() {
        return new Object[][]{
                {"John Doe", "johndoe@example.com", "Inquiry about product", "I would like to know more about your product features.","C:\\asr\\SendingThisFile.txt"},
                {"Jane Smith", "janesmith@example.com", "Feedback", "The service was excellent, but I have a suggestion for improvement.","C:\\asr\\SendingThisFile.txt"},
                {"Michael Johnson", "michaelj@example.com", "Support Needed", "I am facing an issue with logging into my account.","C:\\asr\\SendingThisFile.txt"},
                {"Emily Davis", "emilyd@example.com", "Collaboration Proposal", "I am interested in collaborating with your team for a new project.","C:\\asr\\SendingThisFile.txt"}
        };
    }



}
