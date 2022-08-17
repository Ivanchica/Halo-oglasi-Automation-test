package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorInboxPage extends BaseTest {
    public MailinatorInboxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[contains(text(), 'Molimo aktivirajte Vaš Halo oglasi nalog')]")
    WebElement haloOglasiEmailElement;

    public void haloOglasiEmailElementClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(haloOglasiEmailElement)).click();
    }
}
