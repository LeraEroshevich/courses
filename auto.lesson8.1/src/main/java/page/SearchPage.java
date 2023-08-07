package page;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    private By firstProductRatingLocator = By.xpath("//span[contains(text(), 'Кухонный комбайн Electrolux EKM4200')]//ancestor::tbody//div[@class='star-active star-empty']");
    private By starsLocator = By.xpath("//table[@id='bx_3966226736_4192']//div[@Class='description']//div[@Class='rating']//table[@Class='table-no-border']//div[@Class='star-active star-empty']");



    public int getFirstProductRating() {
        List<WebElement> ratingElements = driver.findElements(firstProductRatingLocator);
        ratingElements = waitForCollectionSize(ratingElements, 5, 30, 10000);

        if (ratingElements.size() == 0) {
            throw new NoSuchElementException("Product rating element not found");
        }

        WebElement ratingElement = ratingElements.get(ratingElements.size() - 1);
        String ratingTitle = ratingElement.getAttribute("title");
        return Integer.parseInt(ratingTitle);
    }

    private List<WebElement> waitForCollectionSize(List<WebElement> elements, int expectedSize, int maxAttempts, int intervalMillis) {
        int attempts = 0;
        while (elements.size() != expectedSize && attempts < maxAttempts) {
            try {
                Thread.sleep(intervalMillis);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
            elements = driver.findElements(firstProductRatingLocator);
        }
        return elements;
    }
}
