import java.util.List;
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
    By searchTitleTwoLocator = By.xpath("//div[@id='wiki-body']//a[@id='user-content-downloads']");
    @Test
    void task1Test(){
        driver.get("https://www.jenkins.io/");
        driver.manage().window().maximize();
        WebElement gridComponentsImg = driver.findElement(gridComponentsImgLocator);
        String imgLink = gridComponentsImg.getAttribute("src");
        Assertions.assertTrue(imgLink.endsWith(".png"));
    }
    @Test
    void task2Test(){
        driver.get("https://rest-assured.io/");
        driver.manage().window().maximize();
        WebElement menuItemGrid = driver.findElement(By.xpath("//div[@id='main']//li[@class='p-docs']"));
        menuItemGrid.click();

        WebElement subMenuGrid = driver.findElement(subMenuDocsLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();",subMenuGrid);

        WebElement searchTitle = driver.findElement(searchTitleLocator);
        if (searchTitle.isDisplayed()){
            System.out.println("The text 'GettingStarted' is visible");
        } else {
            System.out.println("'GettingStarted' text not visible");
        }

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://github.com/rest-assured/rest-assured/wiki/GettingStarted", currentUrl);
    }

    @Test
    void task3Test() {
        driver.get("https://rest-assured.io/");
        driver.manage().window().maximize();
        WebElement menuItemGrid = driver.findElement(By.xpath("//div[@id='main']//li[@class='p-docs']"));
        menuItemGrid.click();

        WebElement subMenuDownloads = driver.findElement(subMenuDownloadsLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", subMenuDownloads);

        WebElement searchTitle = driver.findElement(searchTitleTwoLocator);
        if (searchTitle.isDisplayed()) {
            System.out.println("The text 'Downloads' is visible");
        } else {
            System.out.println("'Downloads' text not visible");
        }

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://github.com/rest-assured/rest-assured/wiki/Downloads", currentUrl);

        WebElement attributesTable = driver.findElement(By.xpath("//table[@role='table']"));
        List<WebElement> rows = attributesTable.findElements(By.tagName("tr"));

        int rowCount = rows.size() - 1;

        List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));
        int columnCount = columns.size();

        if (rowCount == 8 && columnCount == 2) {
            System.out.println("Attribute table contains 2 columns and 8 rows");
        } else {
            System.out.println("Attribute table does not match expected values");
        }
    }
}
