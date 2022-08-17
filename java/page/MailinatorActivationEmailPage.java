package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorActivationEmailPage extends BaseTest {

    public MailinatorActivationEmailPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[text()='Aktiviraj nalog']/parent::a")
    WebElement aktivirajNalogButton;
    // finding iframe
    @FindBy(css = "html_msg_body")
    WebElement emailIframe;

    public void aktivirajNalogButtonClick() {
        // switch to iframe which contains a button
        driver.switchTo().frame("html_msg_body");
        wdWait.until(ExpectedConditions.visibilityOf(aktivirajNalogButton));
        actions.moveToElement(aktivirajNalogButton).perform();
        aktivirajNalogButton.click();
    }

    // wait for iframe to be availalable
    public void switchFocusToIframeBodyWithWdWait() {
        wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(emailIframe));
    }

    // back to previous content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
