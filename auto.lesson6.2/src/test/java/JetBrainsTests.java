import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JetBrainsTests extends BaseTest {

    By intellijIdeaMenuItemLocator =
        By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']//a[@href='/idea/']");
    By cookieBannerTextLocator = By.xpath("//div[@class='jetbrains-cookies-banner-3']//div[@class='jetbrains-cookies-banner-3__text-content']");
    By pycharmMenuItemLocator = By.xpath(
        "//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']//a[@href='/pycharm/']");
    By aquaMenuItemLocator =
        By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']//a[@href='/aqua/']");
    By aquaImgLocator = By.xpath("//div[@class='page__content ']//div [@class='aqua']//img[@class='aqua-logo']");
    private String URL_JETBRAINS = "https://www.jetbrains.com/";

    @Test
    void cookieTextCheckTest() {
        driver.get(URL_JETBRAINS);

        pageUtils.clickDeveloperToolsMenu();

        WebElement intellijIdeaMenuItem = driver.findElement(intellijIdeaMenuItemLocator);
        intellijIdeaMenuItem.click();

        WebElement cookieBannerText = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(cookieBannerTextLocator));
        Assert.assertTrue(cookieBannerText.isDisplayed(), "Cookie banner text not visible");
    }

    @Test
    void videoTitleCheckTest() {
        driver.get(URL_JETBRAINS);

        pageUtils.clickDeveloperToolsMenu();

        WebElement pycharmMenuItem = driver.findElement(pycharmMenuItemLocator);
        pycharmMenuItem.click();

        // Видео недоступно чтобы написать тест
    }

    @Test
    void imageSizeCheckTest() {
        driver.get(URL_JETBRAINS);

        pageUtils.clickDeveloperToolsMenu();

        WebElement aquaMenuItem = driver.findElement(aquaMenuItemLocator);
        aquaMenuItem.click();

        WebElement aquaImg = driver.findElement(aquaImgLocator);
        pageUtils.verifyImageNativeSize(aquaImg, 96, 96);
    }
}
