package component;

import page.CompanySearchPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private WebDriver driver;
    @FindBy(xpath = "//header[@class='navbar']//div[@class='navbar__row']//div[@class='navbar__toggler']")
    private WebElement navBar;
    @FindBy(xpath = "//div[@data-navbar-target='menu']//nav[@class='menu__body']//a[@href='https://companies.devby.io']")
    private WebElement companyItem;
    @FindBy(xpath = "//div[@data-navbar-target='menu']//div[@class='menu__footer']//a[@href='https://devby.io/pages/about']")
    private WebElement aboutItem;
    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Header clickNavBar() {
        navBar.click();
        return new Header(driver);
    }

    public CompanySearchPage clickCompanyItem() {
        companyItem.click();
        return new CompanySearchPage(driver);
    }

    public Header clickAboutItem() {
        aboutItem.click();
        return new Header(driver);
    }

}
