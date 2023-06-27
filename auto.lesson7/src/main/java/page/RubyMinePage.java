package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RubyMinePage {

    private WebDriver driver;

    private By TextRubyMineLocator = By.xpath("//div[@class='wt-container']//div[@class='CodeMirror-sizer']//div[@class='CodeMirror-lines']");
    public String getTextRubyMine() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement TextRubyMine = wait.until(ExpectedConditions.visibilityOfElementLocated(TextRubyMineLocator));
        return TextRubyMine.getText();
    }
}
