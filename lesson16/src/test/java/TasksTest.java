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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksTest {
    private WebDriver driver;
    private static ChromeOptions options;

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    void startBrowser(){
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    void closeDriver(){
        driver.close();
    }

    By mainMenuItemLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']");
    By mainSubMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test='main-submenu']//a[@href='https://plugins.jetbrains.com/search?tags=Theme']");
    By inputFieldLocator = By.xpath("//div[@class='search-box']//div[@data-testid='autocomplete']//input[@type='text']");
    By autocompleteElementLocator = By.xpath("//div[@data-testid='autocomplete-popup']//div[@data-index='1']");
    By ratingStarsLocator = By.xpath("//div[@class='wt-text-2 plugin-header__rate']//span[@class='test_plugin-header-rate']//span[@data-test='rate']");
    By mainSubCodeMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test='main-submenu']//a[@href='/code-with-me/']");
    By youtubePlayerBtnLocator = By.xpath("//div[@data-test='youtube-player']//div[@data-test='youtube-player-link']//button[@data-test='youtube-player-button']");
    By videoTitleLocator = By.xpath("//div[@id='player']//div[@id='movie_player']//a[@href='https://www.youtube.com/watch?v=Lq0fCMCK-Yw']");
    By iFrameLocator = By.xpath("//iframe[@src='https://www.youtube.com/embed/Lq0fCMCK-Yw?autoplay=true&rel=0&modestbranding=1&enablejsapi=1&origin=https%3A%2F%2Fwww.jetbrains.com&widgetid=3']");
    By mainSubScalaMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test='main-submenu']//a[@href='https://plugins.jetbrains.com/plugin/1347-scala']");
    By gridComponentsImgLocator = By.xpath("//div[@class='wt-col-inline']//img[@alt='Plugin Logo']");

    @Test
    void checkRatingVisibility(){
        driver.get("https://www.jetbrains.com/");
        WebElement mainMenuItem = driver.findElement(mainMenuItemLocator);
        mainMenuItem.click();

        WebElement mainSubMenu = driver.findElement(mainSubMenuLocator);
        mainSubMenu.click();

        WebElement inputField = driver.findElement(inputFieldLocator);
        inputField.sendKeys("Dracula Theme");

        WebElement autocompleteElement = new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(autocompleteElementLocator));
        autocompleteElement.click();

        WebElement ratingStars = new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(ratingStarsLocator));
        boolean isDisplayed = ratingStars.isDisplayed();
        Assertions.assertTrue(isDisplayed, "Star rating not visible");
    }

    @Test
    void checkHeaderVisibility(){
        driver.get("https://www.jetbrains.com/");
        WebElement mainMenuItem = driver.findElement(mainMenuItemLocator);
        mainMenuItem.click();

        WebElement mainSubCodeMenu = driver.findElement(mainSubCodeMenuLocator);
        mainSubCodeMenu.click();

        WebElement youtubePlayerBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(youtubePlayerBtnLocator));
        youtubePlayerBtn.click();

        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(iFrameLocator));
        driver.switchTo().frame(iFrame);

        WebElement videoTitle = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));
        Assertions.assertEquals("Introducing Code With Me - Collaborative Coding", videoTitle.getText());
    }

    @Test
    void logoInSvgTest(){
        driver.get("https://www.jetbrains.com/");
        WebElement mainMenuItem = driver.findElement(mainMenuItemLocator);
        mainMenuItem.click();

        WebElement mainSubScalaMenu = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(mainSubScalaMenuLocator));
        mainSubScalaMenu.click();

        WebElement gridComponentsImg = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(gridComponentsImgLocator));
        String imgLink = gridComponentsImg.getAttribute("src");
        Assertions.assertTrue(imgLink.endsWith(".svg"));
    }
}
