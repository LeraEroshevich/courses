package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //@FindBy(xpath = "//table[@id='bx_3966226736_4192']//div[@class='description']//div[@class='rating']//table[@class='table-no-border']//div[@class='star-active star-empty']")
    //private WebElement starsRatingLocator; Прообовала через этот локатор, но тест не проходит, пишет всегда
    // Expected :5
    // Actual   :1
    // Пробовала другие локаторы, все равно не проходит, прошло только с cssSelector
    public int getFirstProductRating() {
        WebElement ratingElement = driver.findElement(By.cssSelector(".rating .star-active[title='5']"));
        String ratingTitle = ratingElement.getAttribute("title");
        return Integer.parseInt(ratingTitle);
    }
}
