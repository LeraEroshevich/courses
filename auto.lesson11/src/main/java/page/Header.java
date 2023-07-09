package page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class Header {
    private SelenideElement photoReportItem = $x("//div[@class='Gallery__listWrapper']//div[@title='Фотоотчеты']");

    public DropDown clickPhotoReportItem() {
        photoReportItem.click();
        return Selenide.page(DropDown.class);
    }
}
