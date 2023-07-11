import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogin {
    private WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement enterPassword(String passwordValue) {
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys(passwordValue);
        return passwordField;
    }
}
