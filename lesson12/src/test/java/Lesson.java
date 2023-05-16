import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lesson {
    private WebDriver driver;

    @BeforeAll
    static void downloadDriver() {
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    @BeforeEach
    void prepareBrowser() {
        //Preconditions
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    void example1Test() {
        //Preconditions

        //Steps
        driver.get("https://google.com/");
        String currentUrl = driver.getCurrentUrl();

        //Checks - Verify
        Assertions.assertEquals("https://google.com/", currentUrl);
    }

    @Test
    void example2Test() {

        //Steps
        driver.get("https://google.com/");
        String currentUrl = driver.getCurrentUrl();

        //Checks - Verify
        Assertions.assertEquals("https://www.google.com/", currentUrl);
    }

    @Test
    void example3Test() {
        driver.get("https://www.selenium.dev/");
        WebElement element = driver.findElement(By.xpath("//a[@href='https://selenium.dev/selenium-ide/']"));
        Assertions.assertEquals("READ MORE", element.getText());
    }
}