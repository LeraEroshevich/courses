package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RubyMinePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='wt-container']//div[@class='CodeMirror-sizer']//div[@class='CodeMirror-lines']//div[@role='presentation']//div[@class='CodeMirror-code']//span[@role='presentation']")
    private WebElement textRubyMine;

    public RubyMinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextRubyMine() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOf(textRubyMine));
        return textRubyMine.getText();
    }
}
