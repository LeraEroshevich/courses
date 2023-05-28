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
    private static ChromeOptions options;

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void startBrowser(){
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void closeDriver(){
        driver.close();
    }

   @Test
    void Task2Test(){
       driver.get("https://silverscreen.by/");
       String currentUrl = driver.getCurrentUrl();
       Assertions.assertEquals("https://silverscreen.by/", currentUrl);
   }

    @Test
    void Task3Test(){
        driver.get("https://silverscreen.by/");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://slverscreen.by/", currentUrl);
    }


}
