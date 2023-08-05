import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.Condition;

import page.DropDown;
import page.HomePage;

import org.junit.jupiter.api.Test;

public class RelaxByTests {

    @Test
    void checkPhotoExtensionTest() {
        HomePage homePage = new HomePage()
        .openHomePage();

        DropDown dropDown = homePage
            .getHeader()
            .clickPhotoReportItem();
        String iconUrl = dropDown.getPhotoIconStyle();

        assertTrue(iconUrl.contains(".svg"));
    }

    @Test
    void checkPhotoBtnTest() {
        new HomePage()
            .openHomePage()
            .getHeader()
            .clickPhotoReportItem()
            .getPhotoBtn()
            .shouldHave(Condition.text("Все фотоотчеты"))
            .shouldBe(Condition.visible);
    }
}
