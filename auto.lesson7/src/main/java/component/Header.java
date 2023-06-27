package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {

    private WebDriver driver;

    private By developerToolsLocator = By.xpath("//body//nav[@data-test='main-menu']//button[@aria-label='Developer Tools: Open submenu']");
    private By RubyMineItemLocator = By.xpath("//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']//a[@href='/ruby/']");

    public WebElement getDeveloperTools() {
        return driver.findElement(developerToolsLocator);
    }
    public Header clickDeveloperTools() {
        getDeveloperTools().click();
        return this;
    }
    public WebElement getRubyMineItem() {
        return driver.findElement(RubyMineItemLocator);
    }
    public Header clickRubyMineItem() {
        getRubyMineItem().click();
        return this;
    }

    public Header(WebDriver driver) {
        this.driver = driver;
    }
}
