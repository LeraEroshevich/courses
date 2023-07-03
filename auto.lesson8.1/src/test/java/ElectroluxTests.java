import java.util.List;

import page.ElectroluxPage;
import page.HomePage;
import page.PromotionsPage;
import page.SearchPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;

public class ElectroluxTests extends BaseTest {

    public static Object[][] getMenuItems() {
        return new Object[][]{{"Варочные панели", "Варочные панели Electrolux"}, {"Духовые шкафы", "Духовые шкафы Electrolux"},
            {"Микроволновые печи", "Микроволновые печи Electrolux"}};
    }

    @ParameterizedTest
    @MethodSource("getMenuItems")
    void checkMenuItemTest(String menuItem, String expectedTitle) {
        ElectroluxPage electroluxPage = new HomePage(getDriver())
            .open("https://electrolux-market.by/")
            .selectMenuItem(menuItem);

        String actualTitle = electroluxPage.getTitle();
        Assertions.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void checkPromotionImagesExtensionTest() {
        PromotionsPage homePage = new HomePage(getDriver())
            .open("https://electrolux-market.by/")
            .clickPromotionsTab();

        List<WebElement> promotionImages = PromotionsPage.getPromotionImages();
        for (WebElement image : promotionImages) {
            String imageSource = image.getAttribute("src");
            Assertions.assertTrue(imageSource.endsWith(".jpg"), "Image does not have a .jpg extension");
        }
    }

    @Test
    void checkProductRating() {
        HomePage homePage = new HomePage(getDriver())
            .open("https://electrolux-market.by/");
        SearchPage searchPage = homePage.searchForProduct("Блендеры");

        int productRating = searchPage.getFirstProductRating();
        Assertions.assertEquals(5, productRating, "Product rating is not 5 stars");
    }
}
