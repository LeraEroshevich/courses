import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TasksTest {
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

    By gridComponentsImgLocator = By.xpath("//div[@class='container']//a[@href='/participate/']//img[@role='presentation']");
    By subMenuDocsLocator = By.xpath("//div[@id='docs']//a[@href='https://github.com/rest-assured/rest-assured/wiki/GettingStarted']");
    By searchTitleLocator = By.xpath("//div [@id='wiki-wrapper']//h1");
    By subMenuDownloadsLocator = By.xpath("//div[@id='docs']//a[@href='https://github.com/rest-assured/rest-assured/wiki/Downloads']");
    By searchTitleTwoLocator = By.xpath("//div[@id='wiki-body']//div[@class='markdown-body']//h1");

    @Test
    void ImgInPngTest(){
        driver.get("https://www.jenkins.io/");
        driver.manage().window().maximize();
        WebElement gridComponentsImg = driver.findElement(gridComponentsImgLocator);
        String imgLink = gridComponentsImg.getAttribute("src");
        Assertions.assertTrue(imgLink.endsWith(".png"));
    }

    @Test
    void CheckTextOutputAndCorrectLinkTest(){
        driver.get("https://rest-assured.io/");
        driver.manage().window().maximize();
        WebElement menuItemGrid = driver.findElement(By.xpath("//div[@id='main']//li[@class='p-docs']"));
        menuItemGrid.click();

        WebElement subMenuGrid = driver.findElement(subMenuDocsLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();",subMenuGrid);

        String searchTitle = driver.findElement(searchTitleLocator).getText();
        boolean TextDisplayed = driver.findElement(searchTitleLocator).isDisplayed();
        Assertions.assertEquals("GettingStarted", searchTitle);
        Assertions.assertTrue(TextDisplayed);

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://github.com/rest-assured/rest-assured/wiki/GettingStarted", currentUrl);
    }

    @Test
    void CheckColumnsAndRowsInTableTest() {
        driver.get("https://rest-assured.io/");
        driver.manage().window().maximize();
        WebElement menuItemGrid = driver.findElement(By.xpath("//div[@id='main']//li[@class='p-docs']"));
        menuItemGrid.click();

        WebElement subMenuDownloads = driver.findElement(subMenuDownloadsLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", subMenuDownloads);

        String searchTitle = driver.findElement(searchTitleTwoLocator).getText();
        boolean TextDisplayed = driver.findElement(searchTitleTwoLocator).isDisplayed();
        Assertions.assertEquals("Downloads", searchTitle);
        Assertions.assertTrue(TextDisplayed);

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://github.com/rest-assured/rest-assured/wiki/Downloads", currentUrl);

        WebElement attributesTable = driver.findElement(By.xpath("//table[@role='table']"));
        int tableRows = attributesTable.findElements(By.xpath("//table[@role='table']//thead//tr//th")).size();
        Assertions.assertEquals(2, tableRows);
        int tableColumns = attributesTable.findElements(By.xpath("//table[@role='table']//tbody//tr")).size();
        Assertions.assertEquals(8, tableColumns);
    }
}
