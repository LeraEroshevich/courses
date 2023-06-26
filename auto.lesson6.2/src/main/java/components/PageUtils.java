package components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtils {
    private WebDriver driver;

    private By developerToolsMenuLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//button[@data-test='main-menu-item-action']");


    public PageUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDeveloperToolsMenu(){
        return driver.findElement(developerToolsMenuLocator);
    }

    public PageUtils clickDeveloperToolsMenu() {
        getDeveloperToolsMenu().click();
        return this;
    }
}
