import org.openqa.selenium.WebDriver;

public class FormPage {
    private WebDriver driver;
    public FormPage(WebDriver driver) {
        this.driver = driver;
    }
    public FormPage navigateToForm(String url) {
        driver.get(url);
        return this;
    }
}
