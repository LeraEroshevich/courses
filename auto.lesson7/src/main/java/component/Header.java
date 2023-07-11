package component;

import page.PyCharmPage;
import page.RubyMinePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;
    private static final String DEVELOPER_TOOLS_XPATH = "//nav[@data-test='main-menu']//div[@data-test-marker='Developer Tools']//div[@data-test='main-submenu']//div[@data-test='main-submenu-item']";
    @FindBy(xpath = "//body//nav[@data-test='main-menu']//button[@aria-label='Developer Tools: Open submenu']")
    private WebElement developerTools;
    @FindBy(xpath = DEVELOPER_TOOLS_XPATH + "//a[@href='/ruby/']")
    private WebElement rubyMi;
    @FindBy(xpath = DEVELOPER_TOOLS_XPATH + "//a[@href='/pycharm/']")
    private WebElement pyCharm;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Header clickDeveloperTools() {
        developerTools.click();
        return new Header(driver);
    }

    public RubyMinePage clickRubyMineItem() {
        rubyMi.click();
        return new RubyMinePage(driver);
    }

    public PyCharmPage clickPyCharmPage() {
        pyCharm.click();
        return new PyCharmPage(driver);
    }
}
