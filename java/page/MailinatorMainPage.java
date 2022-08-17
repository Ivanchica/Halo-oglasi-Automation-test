package page;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorMainPage extends BaseTest {

    public MailinatorMainPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    WebElement mailinatorInboxInputBox;


    public void mailinatorInboxInputBoxSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(mailinatorInboxInputBox)).clear();
        mailinatorInboxInputBox.sendKeys(email);
        mailinatorInboxInputBox.sendKeys(Keys.ENTER);
    }
}
