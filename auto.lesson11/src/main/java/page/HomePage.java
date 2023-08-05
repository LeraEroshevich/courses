package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class HomePage {

    public static final String RELAX_BY_URL = "https://www.relax.by/";

    public HomePage openHomePage() {
        Selenide.open(RELAX_BY_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

    public Header getHeader() {
        return Selenide.page(Header.class);
    }

    public ShowPage selectShowType(String showType) {
        getHeader().clickPosterItem().clickSpectaclesItem();
        Selenide.page(ShowPage.class).clickShowTypeItem(showType);
        return Selenide.page(ShowPage.class);
    }

}
