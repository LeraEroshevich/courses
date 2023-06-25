import java.text.SimpleDateFormat;
import java.util.Date;

import constants.Colors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TasksTest extends BaseTest{
    String currentDir = System.getProperty("user.dir");
    String filePath = "file://" + currentDir + "/src/main/resources/index.html";

    @Test
    void inputFieldValidationTest(){
        driver.get(filePath);

        WebElement nameField = driver.findElement(By.name("Name"));
        String value = "123456789qwertyuiopasdfghjklzxcv";
        nameField.sendKeys(value);
        Assertions.assertTrue(nameField.getAttribute("value").length() <= 30,
                              "The length of the value in the exceed field is 30 characters");

        String passwordValue = "Password";
        PageLogin pageObject = new PageLogin(driver);
        WebElement passwordField = pageObject.enterPassword(passwordValue);
        Assertions.assertEquals(passwordValue, passwordField.getAttribute("value"),
                                "The text in the field does not match the entered value");
        Assertions.assertEquals("password", passwordField.getAttribute("type"),
                                "Field type is not equal to 'password'");
    }

    @Test
    void checkTextAndCheckboxesTest(){
        driver.get(filePath);

        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Variant 4", pageTitle);

        Assertions.assertEquals("Name", driver.findElement(By.xpath("//label[text()='Name']")).getText());
        Assertions.assertEquals("Password", driver.findElement(By.xpath("//label[text()='Password']")).getText());

        Assertions.assertEquals(Colors.BLUE.getCode(), driver.findElement(By.xpath("//a[@class='button']"))
            .getCssValue("background-color"));

        WebElement checkboxesDiv = driver.findElement(By.className("checkboxes"));
        WebElement[] checkboxes = checkboxesDiv.findElements(By.xpath(".//input[@type='checkbox']")).toArray(new WebElement[0]);

        Assertions.assertEquals(5, checkboxes.length);
        Assertions.assertTrue(checkboxes[0].isSelected());
        Assertions.assertFalse(checkboxes[1].isSelected());
        Assertions.assertFalse(checkboxes[2].isSelected());
        Assertions.assertTrue(checkboxes[3].isSelected());
        Assertions.assertTrue(checkboxes[4].isSelected());
    }

    @Test
    void checkingInputAndCalendar() {
        driver.get(filePath);

        PageLogin pageObject = new PageLogin(driver);

        String passwordValue = "Password";
        WebElement passwordField = pageObject.enterPassword(passwordValue);
        Assertions.assertEquals(passwordValue, passwordField.getAttribute("value"),
                                "The text in the field does not match the entered value");
        Assertions.assertEquals("password", passwordField.getAttribute("type"),
                                "Field type is not equal to 'password'");

        WebElement nameField = driver.findElement(By.name("Name"));
        String firstFieldValue = nameField.getAttribute("value");
        Assertions.assertEquals("", firstFieldValue);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());
        WebElement dateField = driver.findElement(By.name("Calendar"));
        dateField.clear();
        dateField.sendKeys(currentDate);

        WebElement button = driver.findElement(By.xpath("//a[@class='button']"));
        button.click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://metanit.com/web/html5/5.1.php", currentUrl,
                                "The current URL does not match what you expect");
    }
}
