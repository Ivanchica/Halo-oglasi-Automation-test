package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloAccountActivationPage extends BaseTest {

    public HaloAccountActivationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='regsitration-success']/child::p[1]/child::span")
    WebElement registrationSuccessTitleText;

    @FindBy(xpath = "//div[@class='regsitration-success']/child::p[1]")
    WebElement registrationSuccessBodyText;

    @FindBy(linkText = "Prijava")
    WebElement prijavaButton;

    public boolean registrationSuccessTitleTextIsDisplayed() throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(registrationSuccessTitleText));
        return registrationSuccessTitleText.isDisplayed();
    }

    public String registrationSuccessTitleTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(registrationSuccessTitleText));
        return registrationSuccessTitleText.getText();
    }

    public boolean registrationSuccessBodyTextIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(registrationSuccessBodyText));
        return registrationSuccessBodyText.isDisplayed();
    }

    public String registrationSuccessBodyTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(registrationSuccessBodyText));
        return registrationSuccessBodyText.getText();
    }

    public void prijavaButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(prijavaButton)).click();
    }
}
