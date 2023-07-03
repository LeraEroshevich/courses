package component;

import page.PyCharmPage;
import page.RubyMinePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;
    @FindBy(xpath = "//body//nav[@data-test='main-menu']//button[@aria-label='Developer Tools: Open submenu']")
    private WebElement developerTools;
    @FindBy(
        xpath = "//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']//a[@href='/ruby/']")
    private WebElement RubyMi;
    @FindBy(
        xpath = "//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']//a[@href='/pycharm/']")
    private WebElement PyCharm;
    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Header clickDeveloperTools() {
        developerTools.click();
        return new Header(driver);
    }

    public RubyMinePage clickRubyMineItem() {
        RubyMi.click();
        return new RubyMinePage(driver);
    }

    public PyCharmPage clickPyCharmPage() {
        PyCharm.click();
        return new PyCharmPage(driver);
    }
}
