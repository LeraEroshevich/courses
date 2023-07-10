package page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class Header {
    private SelenideElement photoReportItem = $x("//div[@class='Gallery__listWrapper']//div[@title='Фотоотчеты']");
    private SelenideElement posterItem = $x("//div[@class='Gallery__listWrapper']//div[@title='Афиша, кино']");

    public DropDown clickPhotoReportItem() {
        photoReportItem.click();
        return Selenide.page(DropDown.class);
    }

    public ShowPage clickPosterItem() {
        posterItem.click();
        return Selenide.page(ShowPage.class);
    }
}
