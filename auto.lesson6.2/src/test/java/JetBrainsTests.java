import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JetBrainsTests extends BaseTest{

    private String URL_JETBRAINS = "https://www.jetbrains.com/";

    By intellijIdeaMenuItemLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']//a[@href='/idea/']");
    By cookieBannerTextLocator = By.xpath("//div[@class='jetbrains-cookies-banner-3']//div[@class='jetbrains-cookies-banner-3__text-content']");

    @Test
    void CookieTextCheckTest() {
        driver.get(URL_JETBRAINS);

        pageUtils.clickDeveloperToolsMenu();

        WebElement intellijIdeaMenuItem = driver.findElement(intellijIdeaMenuItemLocator);
        intellijIdeaMenuItem.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement cookieBannerText = wait.until(ExpectedConditions.visibilityOfElementLocated(cookieBannerTextLocator);
        Assert.assertTrue(cookieBannerText.isDisplayed(), "Cookie banner text not visible");
    }
}
