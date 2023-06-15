import org.openqa.selenium.WebDriver;

public class ItransitionPage implements Action<ItransitionPage> {
    private WebDriver driver;
    public ItransitionPage(WebDriver driver) {
        this.driver = driver;
    }
    public ItransitionPage open(String url) {
        return this;
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}