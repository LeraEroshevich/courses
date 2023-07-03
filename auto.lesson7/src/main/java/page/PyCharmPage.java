package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PyCharmPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@id='overview-info']//div[@id='python-take-a-tour-video']//button[@data-test='button']")
    private WebElement BtnTakeVideo;
    private By textVideoTitleLocator = By.xpath("Какой то путь");
    @FindBy(xpath = "//div[@class='wt-container']//div[@class='overview-header__download button-with-note']//a[@href='/pycharm/download/']")
    private WebElement DownloadButton;
    public PyCharmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PyCharmPage clickBtnTakeVideo() {
        BtnTakeVideo.click();
        return new PyCharmPage(driver);
    }

    public String getTextVideoTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(textVideoTitleLocator, "WebStorm Overview 2021"));
        WebElement textVideoTitle = driver.findElement(textVideoTitleLocator);
        return textVideoTitle.getText();
    }

    public WebElement getDownloadButton() {
        return DownloadButton;
    }
}
