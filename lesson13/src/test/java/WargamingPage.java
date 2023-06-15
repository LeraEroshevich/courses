import org.openqa.selenium.WebDriver;

public class WargamingPage implements Action<WargamingPage> {
    private WebDriver driver;
    public WargamingPage(WebDriver driver) {
        this.driver = driver;
    }
    public WargamingPage open(String url) {
        return this;
    }
    public String WargamingPage() {
        return driver.getCurrentUrl();
    }
}
