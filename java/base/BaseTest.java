package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.SharedMethods;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdWait;
    public static Actions actions;
    public SharedMethods sharedMethods;
    public static String userName;
    public static String email;
    public static String password;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 35);
        actions = new Actions(driver);
        sharedMethods = new SharedMethods();

        userName = sharedMethods.nameGenerator(6);
        email = userName + "@mailinator.com";
        password = "098765";

        driver.get("https://www.halooglasi.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // TODO: uncomment after the test is finished
//        driver.quit();
    }
}
