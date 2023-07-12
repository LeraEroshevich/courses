package page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class ShowPage {

    private SelenideElement showTypeItem;
    private SelenideElement showTitle = $(".b-search_wrap h1");
    private SelenideElement spectaclesItem = $x("//div[@class='slick-track']//li[@class='b-cityes_item  slick-slide']//a[@href='https://afisha.relax.by/theatre/minsk/']");
    private SelenideElement isTitleVisible = $x("//div[@class='b-page_inner group']//h1");

    public ShowPage clickSpectaclesItem() {
        spectaclesItem.click();
        return this;
    }

    public ShowPage clickShowTypeItem(String showType) {
        showTypeItem = $x("//a[text()='" + showType + "']");
        showTypeItem.click();
        return this;
    }

    public boolean isTitleVisible(String expectedTitle) {
        return showTitle.shouldBe(Condition.visible).has(Condition.exactText(expectedTitle));
    }

}
