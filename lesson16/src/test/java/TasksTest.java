import java.time.Duration;
import java.util.List;

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
    private static final String URL_JETBRAINS = "https://www.jetbrains.com/";

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void startBrowser(){
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // Инициализация WebDriver
        System.setProperty("webdriver.chrome.driver", "путь_к_драйверу_chrome");
        driver = new ChromeDriver();
    }

    @AfterEach
    void closeDriver(){
        driver.close();
    }

    By mainMenuItemLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']");
    By mainSubMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test='main-submenu']//a[@href='https://plugins.jetbrains.com/search?tags=Theme']");
    By inputFieldLocator = By.xpath("//div[@class='search-box']//div[@data-testid='autocomplete']//input[@type='text']");
    //By autocompleteElementLocator = By.xpath("//div[contains(@Class, 'autocomplete__item')]//div[@Class='autocomplete__element']");
    By ratingStarsLocator = By.xpath("//span[@class='test_plugin-header-rate']//span[@data-test='rate']");
    By ratingStarLocator = By.xpath("//span[@class='test_plugin-header-rate']//span[@data-test='rate']//span[@data-test='rate-star']");
    By mainSubCodeMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test='main-submenu']//a[@href='/code-with-me/']");
    By youtubePlayerBtnLocator = By.xpath("//div[@data-test='youtube-player']//div[@data-test='youtube-player-link']//button[@data-test='youtube-player-button']");
    By videoTitleLocator = By.xpath("//div[@id='player']//div[@id='movie_player']//a[@href='https://www.youtube.com/watch?v=Lq0fCMCK-Yw']");
    By iFrameLocator = By.xpath("//iframe");
    By mainSubScalaMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test='main-submenu']//span[text()='Scala']");
    By gridComponentsImgLocator = By.xpath("//img[@alt='Plugin Logo']");
     By autocompleteItemLocator = By.xpath("//div[contains(@class, 'autocomplete__item')]");
     By autocompleteElementLocator = By.xpath(".//div[contains(@class, 'autocomplete__element')]");

    public TasksTest(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findAutocompleteElementByText(String findText) {
        List<WebElement> autocompleteItems = new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(autocompleteItemLocator));

        for (WebElement item : autocompleteItems) {
            WebElement element = item.findElement(By.xpath(".//div[contains(@class, 'autocomplete__element')]"));
            String itemText = element.getText();

            itemText = itemText.toLowerCase().replaceAll("\\s+", "");
            findText = findText.toLowerCase().replaceAll("\\s+", "");

            if (itemText.contains(findText)) {
                return element;
            }
        }
        return null;
    }

    @Test
    void checkRatingVisibility() {
        driver.get(URL_JETBRAINS);
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

        List<WebElement> starElements = ratingStars.findElements(ratingStarLocator);
        Assertions.assertEquals(5, starElements.size(), "All star rating elements not visible");
        for (WebElement starElement : starElements) {
            Assertions.assertTrue(starElement.isDisplayed(), "Star rating element not visible");
        }
    }

    @Test
    void checkHeaderVisibility(){
        driver.get(URL_JETBRAINS);
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
        Assertions.assertTrue(videoTitle.isDisplayed(), "Video title is not displayed");
        Assertions.assertEquals("Introducing Code With Me - Collaborative Coding", videoTitle.getText());
    }

    @Test
    void logoInSvgTest(){
        driver.get(URL_JETBRAINS);
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
