package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    WebElement subjectField;

    @FindBy(xpath = "//textarea[@placeholder='Your Message Here']")
    WebElement messageField;

    @FindBy(xpath = "//input[@type='file']")
    WebElement fileUploadButton;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement homeButton;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterInfoAndSend(String name, String email, String subject, String message,String uploadFilePath){
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
        fileUploadButton.sendKeys(uploadFilePath);
        submitButton.click();

    }

    public void goBackHome(){
        homeButton.click();

    }


}
