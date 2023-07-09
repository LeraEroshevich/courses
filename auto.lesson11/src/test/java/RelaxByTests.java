import static org.junit.jupiter.api.Assertions.assertTrue;
import static page.HomePage.RELAX_BY_URL;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import page.DropDown;
import page.HomePage;

import org.junit.jupiter.api.Test;

public class RelaxByTests {

    @Test
    void checkPhotoExtensionTest() {
        new HomePage()
            .open(RELAX_BY_URL)
            .getHeader()
            .clickPhotoReportItem();

        DropDown photoReportPage = new DropDown();
        SelenideElement photoIcon = photoReportPage.getPhotoIcon();
        String iconUrl = photoIcon.getAttribute("style");

        assertTrue(iconUrl.contains(".svg"));
    }

    @Test
    void checkPhotoBtnTest() {
        new HomePage()
            .open(RELAX_BY_URL)
            .getHeader()
            .clickPhotoReportItem()
            .getPhotoBtn()
            .shouldHave(Condition.text("Все фотоотчеты"))
            .shouldBe(Condition.visible);
    }
}
