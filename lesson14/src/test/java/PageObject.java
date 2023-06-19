import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
    public static WebElement enterPassword(WebDriver driver, String passwordValue) {
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys(passwordValue);
        return passwordField;
    }
}
