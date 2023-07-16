package page;

import component.SearchInput;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public static final String WEBSITE_URL = "https://electrolux-market.by/";
    private WebDriver driver;
    @FindBy(xpath = "//div[@class='table-menu']//a[@href='/sale/']")
    private WebElement promotionsTab;
    @FindBy(xpath = "//div[@class='search-wrapper']//input[@id='title-search-input_fixed']")
    private WebElement searchInputLocator;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage open(String url) {
        driver.get(url);
        return new HomePage(driver);
    }

    public ElectroluxPage selectMenuItem(String menuItem) {
        WebElement menuItemElement = driver.findElement(By.linkText(menuItem));
        menuItemElement.click();
        return new ElectroluxPage(driver);
    }

    public PromotionsPage clickPromotionsTab() {
        promotionsTab.click();
        return new PromotionsPage(driver);
    }

    public SearchPage searchForProduct(String searchTerm) {
        SearchInput searchInput = new SearchInput(driver.findElement(By.xpath("//input[@name='q']")));
        searchInput.enterSearchTerm(searchTerm);
        searchInput.performSearch();
        return new SearchPage(driver);
    }
}
