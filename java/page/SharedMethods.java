package page;

import base.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SharedMethods extends BaseTest {
    public SharedMethods() {
        PageFactory.initElements(driver, this);
    }

    // Returns a string of randomly generated characters; string's half-lenght is entered as parameter
    public String nameGenerator(int halfWordLenght) {
        // use only alphabet small letters
        String suglasnici = "bcdfghjklmnpqrstvwxz";
        String samoglasnici = "aeiouy";
        String name = "";
        // randomize new word
        for (int i = 0; i < halfWordLenght; i++) {
            name += RandomStringUtils.random(1, suglasnici);
            name += RandomStringUtils.random(1, samoglasnici);
        }
        // capitalize first letter
        name = (name.substring(0, 1).toUpperCase() + name.substring(1));
        return name;
    }

    // Switches to another Chrome tab
    public void switchToTab(int tabIndex, String tabTitle) {
        // wait for number of tabs to be equals 2
        //wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(tabIndex));
        // check if tab with specified title is loaded
        wdWait.until(titleIs(tabTitle));
    }
}
