import org.openqa.selenium.WebDriver;

public class EpamPage implements Action<EpamPage> {
    private WebDriver driver;
    public EpamPage(WebDriver driver) {
        this.driver = driver;
    }
    public EpamPage open(String url) {
        return this;
    }
    public String EpamPage() {
        return driver.getCurrentUrl();
    }
}