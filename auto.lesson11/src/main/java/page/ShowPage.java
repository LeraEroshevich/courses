package page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import java.util.List;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShowPage {

    private SelenideElement showTitle = $(".b-search_wrap h1");
    private SelenideElement spectaclesItem = $x("//div[@class='slick-track']//li[@class='b-cityes_item  slick-slide']//a[@href='https://afisha.relax.by/theatre/minsk/']");
    private SelenideElement isTitleVisible = $x("//div[@class='b-page_inner group']//h1");

    public ShowPage clickSpectaclesItem() {
        spectaclesItem.click();
        return this;
    }

    public ShowPage clickShowTypeItem(String showType) {
        SelenideElement showTypeItem = $x("//a[text()='" + showType + "']");
        showTypeItem.click();
        return this;
    }

    public boolean isTitleVisible(String expectedTitle) {

        return showTitle.shouldBe(Condition.visible).has(Condition.exactText(expectedTitle));
    }

    public ShowPage closeAdvertisementIfPresent() {
        By closeButtonLocator = By.xpath("//div[@Style='z-index: 999999;']//div[contains(@Style, 'background-image: url(\"data:image/svg+xml;charset=utf-8,')]");
        int maxAttempts = 5;
        int intervalMs = 1000;

        for (int i = 0; i < maxAttempts; i++) {
            List<WebElement> closeButtonElements = WebDriverRunner.getWebDriver().findElements(closeButtonLocator);
            if (!closeButtonElements.isEmpty()) {
                WebElement closeButton = closeButtonElements.get(0);
                closeButton.click();
                break;
            }

            try {
                Thread.sleep(intervalMs);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        return this;
    }
}
