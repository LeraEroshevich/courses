package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElectroluxPage {
    private WebDriver driver;

    public ElectroluxPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        WebElement titleElement = driver.findElement(By.xpath("//h1[@id='pagetitle']"));
        return titleElement.getText();
    }
}
