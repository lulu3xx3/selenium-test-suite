package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

public class SignupPage extends BaseTest {
    WebDriver driver;

    @FindBy(id = "id_gender1")
    WebElement genderMr;

    @FindBy(id = "id_gender2")
    WebElement genderMrs;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(id = "days")
    WebElement DOBDay;

    @FindBy(id = "months")
    WebElement DOBMonth;

    @FindBy(id = "years")
    WebElement DOBYear;

    //newsletter

    @FindBy(id = "newsletter")
    WebElement newsletterBox;

    @FindBy(id = "optin")
    WebElement specialOffersBox;

    @FindBy(id = "first_name")
    WebElement firstNameField;

    @FindBy(id = "last_name")
    WebElement lastNameField;

    @FindBy(id = "country")
    WebElement countyDropbox;

    @FindBy(id = "company")
    WebElement companyField;

    @FindBy(id = "address1")
    WebElement companyAddressField;

    @FindBy(id = "state")
    WebElement stateField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "zipcode")
    WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    WebElement mobileNumberField;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement createAccountButton;





    public SignupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void enterSignupInfo(String gender, String password, String dobDay, String dobMonth, String dobYear, String firstName, String lastName,String companyName,String companyAddress,String countryName,String state, String city, String zipCode, String mobileNumber ){
        if(gender.equalsIgnoreCase("male")){
            genderMr.click();
        }
        else {
            genderMrs.click();
        }
        passwordTextBox.sendKeys(password);
        Select selectDay = new Select(DOBDay);
        selectDay.selectByVisibleText(dobDay);

        Select selectMonth = new Select(DOBMonth);
        selectMonth.selectByVisibleText(dobMonth);

        Select selectYear = new Select(DOBYear);
        selectYear.selectByVisibleText(dobYear);

        newsletterBox.click();
        specialOffersBox.click();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        companyField.sendKeys(companyName);
        companyAddressField.sendKeys(companyAddress);

        WebElement countrySelect = driver.findElement(By.id("country"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", countrySelect);
        countrySelect.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(countyDropbox));
        Select selectCountry = new Select(countyDropbox);
        selectCountry.selectByVisibleText(countryName);


        stateField.sendKeys(state);
        cityField.sendKeys(city);
        zipcodeField.sendKeys(zipCode);
        mobileNumberField.sendKeys(mobileNumber);
        createAccountButton.click();



    }
}
