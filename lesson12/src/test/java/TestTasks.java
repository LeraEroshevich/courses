import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestTasks {
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
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

   @Test
    void Task1Test(){
        WebDriver driver = new ChromeDriver();
   }

   @Test
    void Task2Test(){
       driver.get("https://silverscreen.by/");
       String currentUrl = driver.getCurrentUrl();
       Assertions.assertEquals("https://silverscreen.by/", currentUrl);
   }

}
