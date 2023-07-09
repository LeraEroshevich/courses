package page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class DropDown {

    private SelenideElement photoIcon =
        $x("//div[@class='CategoriesSubMenu']//div[@style='background-image: url(\"https://static.relax.by/images/common/tree/eeda13402d99ca2b68f0027295071f2c.svg\");']");
    private SelenideElement photoBtn = $x("//div[@class='CategoriesSubMenu']//div[@class='CategoriesSubMenu__column']//a[@href='https://mag.relax.by/foto/']");

    public SelenideElement getPhotoIcon() {
        return photoIcon;
    }

    public SelenideElement getPhotoBtn() {
        return photoBtn;
    }
}
