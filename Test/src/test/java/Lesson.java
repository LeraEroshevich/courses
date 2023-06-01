import java.time.Duration;

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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lesson {

    static ChromeOptions options;
    private WebDriver driver;

        @BeforeAll
        static void downloadDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
    }

    @BeforeEach
    void prepareBrowser() {
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.jetbrains.com/objc/");

    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    By videoAreaLocator = By.xpath("//div[@class='appcode-header']//button");
    By iFrameLocator = By.xpath("//iframe[@class='wt-youtube-player__player']");
    By videoTitleLocator = By.xpath("//div[@class='ytp-title-text']//a[@href='https://www.youtube.com/watch?v=CDVAYzOaRT4']");

    @Test
    void getVideoTitleTest() {
        WebElement videoArea = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(videoAreaLocator));

        videoArea.click();

        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(iFrameLocator));
        driver.switchTo().frame(iFrame);

        WebElement videoTitle = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));

        Assertions.assertEquals("AppCode Quick Start Guide", videoTitle.getText());

    }
}
