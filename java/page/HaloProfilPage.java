package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloProfilPage extends BaseTest {

    public HaloProfilPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".header-category-link.logged-in-wrapper")
    WebElement mojProfilDiv;
    @FindBy(xpath = "//p[@class='user-display-name'][1]")
    WebElement userNameText;
    @FindBy(xpath = "//p[@class='user-email'][1]")
    WebElement userEmailText;
    @FindBy(xpath = "//p[@class='user-username'][1]")
    WebElement userNameSecondText;

    public void mojProfilDivHover() {
        wdWait.until(ExpectedConditions.elementToBeClickable(mojProfilDiv));
        actions.moveToElement(mojProfilDiv).perform();
    }

    public boolean userNameTextIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(userNameText));
        return userNameText.isDisplayed();
    }

    public String userNameTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(userNameText));
        return userNameText.getText();
    }

    public boolean userEmailTextIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(userEmailText));
        return userEmailText.isDisplayed();
    }

    public String userEmailTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(userEmailText));
        return userEmailText.getText();
    }

    public boolean userNameSecondTextIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(userNameSecondText));
        return userNameSecondText.isDisplayed();
    }

    public String userNameSecondTextGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(userNameSecondText));
        return userNameSecondText.getText();
    }
}
