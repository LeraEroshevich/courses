package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromotionsPage {

    private By promotionImageLocator = By.xpath("//img[@class='img-responsive']");
    private WebDriver driver;

    public PromotionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getPromotionImages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(promotionImageLocator));
        return driver.findElements(promotionImageLocator);
    }
}
