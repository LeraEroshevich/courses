package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='article__title']")
    private WebElement title;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTitleVisible() {
        return title.isDisplayed();
    }
}
