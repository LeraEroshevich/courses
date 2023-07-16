import static page.HomePage.WEBSITE_URL;

import java.util.List;

import page.ElectroluxPage;
import page.HomePage;
import page.PromotionsPage;
import page.SearchPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;

@Execution(ExecutionMode.CONCURRENT)
public class ElectroluxTests extends BaseTest {

    public static Object[][] getMenuItems() {
        return new Object[][]{{"Варочные панели", "Варочные панели Electrolux"}, {"Духовые шкафы", "Духовые шкафы Electrolux"},
            {"Микроволновые печи", "Микроволновые печи Electrolux"}};
    }

    @ParameterizedTest
    @MethodSource("getMenuItems")
    void checkMenuItemTest(String menuItem, String expectedTitle) {
        ElectroluxPage electroluxPage = new HomePage(getDriver())
            .open(WEBSITE_URL)
            .selectMenuItem(menuItem);

        String actualTitle = electroluxPage.getTitle();
        Assertions.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void checkPromotionImagesExtensionTest() {
        PromotionsPage promotionsPage = new HomePage(getDriver())
            .open(WEBSITE_URL)
            .clickPromotionsTab();

        List<WebElement> promotionImages = promotionsPage.getPromotionImages();
        for (WebElement image : promotionImages) {
            String imageSource = image.getAttribute("src");
            Assertions.assertTrue(imageSource.endsWith(".jpg"), "Image does not have a .jpg extension");
        }
    }

    @Test
    void checkProductRating() {
        HomePage homePage = new HomePage(getDriver())
            .open(WEBSITE_URL);
        SearchPage searchPage = homePage.searchForProduct("Блендеры");

        int productRating = searchPage.getFirstProductRating();
        Assertions.assertEquals(5, productRating, "Product rating is not 5 stars");
    }
}
