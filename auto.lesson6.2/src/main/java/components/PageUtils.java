package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageUtils {
    private WebDriver driver;

    private By developerToolsMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//button[@data-test='main-menu-item-action']");

    public PageUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDeveloperToolsMenu() {
        return driver.findElement(developerToolsMenuLocator);
    }

    public PageUtils clickDeveloperToolsMenu() {
        getDeveloperToolsMenu().click();
        return this;
    }

    public void verifyImageNativeSize(WebElement image, int expectedWidth, int expectedHeight) {
        int nativeWidth = Integer.parseInt(image.getAttribute("naturalWidth"));
        int nativeHeight = Integer.parseInt(image.getAttribute("naturalHeight"));

        Assert.assertEquals(nativeWidth, expectedWidth, "Incorrect image native width");
        Assert.assertEquals(nativeHeight, expectedHeight, "Incorrect image native height");
    }
}
