import components.PageUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static ChromeOptions options;
    public WebDriver driver;
    public PageUtils pageUtils;

    @BeforeClass
    static void downloadDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    void startBrowser() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        pageUtils = new PageUtils(driver);
    }

    @AfterMethod
    void closeDriver() {
        driver.close();
    }
}
