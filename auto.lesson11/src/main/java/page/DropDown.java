package page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class DropDown {

    private SelenideElement photoIcon =
        $x("//div[@class='CategoriesSubMenu']//a[@href='https://mag.relax.by/foto/']/ancestor::div[@class='CategoriesSubMenu__column']//div[@class='CategoriesSubMenu__icon']");
    private SelenideElement photoBtn = $x("//div[@class='CategoriesSubMenu']//div[@class='CategoriesSubMenu__column']//a[@href='https://mag.relax.by/foto/']");

    public SelenideElement getPhotoBtn() {
        return photoBtn;
    }

    public String getPhotoIconStyle() {
        return photoIcon.getAttribute("style");
    }
}
