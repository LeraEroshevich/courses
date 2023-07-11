package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RubyMinePage {

    private WebDriver driver;
    private By textRubyMineLocator = By.xpath(
        "//div[@class='wt-container']//div[@class='CodeMirror-sizer']//div[@class='CodeMirror-lines']//div[@role='presentation']//div[@class='CodeMirror-code']//span[@role='presentation']");

    public RubyMinePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextRubyMine() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.textToBe(textRubyMineLocator, "The Most Intelligent Ruby and Rails IDE "));
        WebElement textRubyMine = driver.findElement(textRubyMineLocator);
        return textRubyMine.getText();
    }
}
