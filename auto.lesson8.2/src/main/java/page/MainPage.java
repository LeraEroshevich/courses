package page;

import component.Header;

import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String DEV_URL = "https://devby.io/";
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public Header getHeader() {
        return new Header(driver);
    }

    public MainPage open(String url) {
        driver.get(url);
        return new MainPage(driver);
    }
}
