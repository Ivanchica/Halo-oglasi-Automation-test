package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloLoginPage extends BaseTest {

    public HaloLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Registrujte se →")
    WebElement registrujteSeButton;
    @FindBy(id = "EMailOrUsername")
    WebElement emailInputBox;
    @FindBy(id = "Password")
    WebElement passwordInputBox;
    @FindBy(xpath = "//button[text()='Uloguj me']")
    WebElement ulogujMeButton;


    public void registrujteSeButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujteSeButton)).click();
    }

    public void emailInputBoxSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(emailInputBox)).clear();
        emailInputBox.sendKeys(email);
    }

    public void passwordInputBoxSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputBox)).clear();
        passwordInputBox.sendKeys(password);
    }

    public void ulogujMeButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(ulogujMeButton)).click();
    }
}
