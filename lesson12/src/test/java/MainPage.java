import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://silverscreen.by/");
    }
}
