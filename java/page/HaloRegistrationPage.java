package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloRegistrationPage extends BaseTest {

    public HaloRegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    // ------------------------ WEB ELEMENTS ------------------------
    @FindBy(xpath = "//input[@name='reg-type'][@value='person']")
    WebElement fizickoLiceRadioButton;
    @FindBy(id = "UserName")
    WebElement korisnickoImeInputBox;
    @FindBy(id = "Email")
    WebElement emailInputBox;
    @FindBy(id = "Password")
    WebElement lozinkaInputBox;
    @FindBy(id = "ConfirmPassword")
    WebElement potvrdaLozinkeInputBox;
    @FindBy(id = "HasAgreedToGetFiscalReceiptByEmail")
    WebElement racunSaglasnostCheckbox;
    @FindBy(css = ".button-reg.save.save-entity.person-face.btn-main")
    WebElement registrujMeButton;
    @FindBy(xpath = "//div[@class='regsitration-success']/child::p[1]/child::span")
    WebElement registracijaUspelaNaslovText;
    @FindBy(xpath = "//div[@class='regsitration-success']/child::p[2]")
    WebElement registracijaUspelaTeloText;
    @FindBy(css = ".cookie-policy-btn")
    WebElement cookieAcceptButton;

    // ------------------------ METHODS ------------------------
    public void fizickoLiceRadioButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(fizickoLiceRadioButton));
        if (!fizickoLiceRadioButton.isSelected()) {
            fizickoLiceRadioButton.click();
        }
    }

    public void korisnickoImeInputBoxSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(korisnickoImeInputBox)).clear();
        korisnickoImeInputBox.sendKeys(userName);
    }

    public void emailInputBoxSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(emailInputBox)).clear();
        emailInputBox.sendKeys(email);
    }

    public void lozinkaInputBoxSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(lozinkaInputBox)).clear();
        lozinkaInputBox.sendKeys(password);
    }

    public void potvrdaLozinkeInputBoxSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(potvrdaLozinkeInputBox)).clear();
        potvrdaLozinkeInputBox.sendKeys(password);
    }

    public void racunSaglasnostCheckboxClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(racunSaglasnostCheckbox));
        if (!racunSaglasnostCheckbox.isSelected()) {
            racunSaglasnostCheckbox.click();
        }
    }

    public boolean registracijaUspelaNaslovTextIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(registracijaUspelaNaslovText));
        return registracijaUspelaNaslovText.isDisplayed();
    }

    public String registracijaUspelaTeloTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(registracijaUspelaTeloText));
        return registracijaUspelaTeloText.getText();
    }

    public boolean registracijaUspelaTeloTextIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(registracijaUspelaTeloText));
        return registracijaUspelaTeloText.isDisplayed();
    }

    public String registracijaUspelaNaslovTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(registracijaUspelaNaslovText));
        return registracijaUspelaNaslovText.getText();
    }

    public void registrujMeButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujMeButton)).click();
    }

    public void cookieAcceptButtonClick() {
        try {
            wdWait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
        }
        catch(org.openqa.selenium.TimeoutException timeoutException) {}
    }
}
