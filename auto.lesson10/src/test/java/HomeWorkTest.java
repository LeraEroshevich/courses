import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HomeWorkTest extends BaseTest {

    @Test
    void seleniumTest() {
        driver.get("https://techshop.by/");
        driver.findElement(By.xpath("//nav[@class='menu']//a[@href='/dostavka-i-oplata']")).click();
        assertEquals("https://techshop.by/dostavka-i-oplata", driver.getCurrentUrl());
    }

    @Test
    void checkStatusCodeTest() {
        RestAssured.baseURI = "https://reqres.in/api";
        get("/users").then().statusCode(200);
    }
}
