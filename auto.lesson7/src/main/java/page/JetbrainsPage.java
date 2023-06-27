package page;

import component.Header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JetbrainsPage {
    private WebDriver driver;
    public JetbrainsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void JetBrainsPage(WebDriver driver) {
        this.driver = driver;
    }

    public Header getHeader() {
        return new Header(driver);
    }
    public JetbrainsPage open(String url){
        driver.get(url);
        return this;
    }
}
