import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TasksTest extends BaseTest{
    static ChromeOptions options;
    private WebDriver driver;
    @Test
    void inputFieldValidationTest(){
       // String formPageUrl = "file:///src/main/resources/index.html";
        driver.get("file:///D:/QA/Projects/courses/lesson14/src/main/resources/index.html");
    }
}
