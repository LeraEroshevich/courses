package page;

import component.Header;

import org.openqa.selenium.WebDriver;

public class JetbrainsPage {
    private WebDriver driver;

    public JetbrainsPage(WebDriver driver) {
        this.driver = driver;
    }

    public Header getHeader() {
        return new Header(driver);
    }

    public JetbrainsPage open(String url) {
        driver.get(url);
        return new JetbrainsPage(driver);
    }
}
