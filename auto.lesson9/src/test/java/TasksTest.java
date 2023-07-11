import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @BeforeAll
    public static void prepareLogsFilter(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    void createUserListTest() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("string", "string", "string", "string", "string", "string", "string", 0));

        // Отправка POST-запроса и проверка ответа
        given()
            .contentType(ContentType.JSON)
            .body(userList)
            .when()
            .post("/user/createWithList")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("code", equalTo(200));
    }

    @Test
    void getUnknownDataTest() {
        RestAssured.baseURI = "https://reqres.in/api";
        UnknownResponse response = get("/unknown")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .extract()
            .as(UnknownResponse.class);

        List<String> colorsWithHashtag = response.data.stream()
            .map(data -> data.color)
            .filter(color -> color.contains("#"))
            .collect(Collectors.toList());

        assertThat(colorsWithHashtag, hasSize(response.data.size()));
    }

    @Test
    void getUnknownDataNotFoundTest() {
        RestAssured.baseURI = "https://reqres.in/api";

        get("/unknown/23")
            .then()
            .statusCode(404)
            .contentType("application/json")
            .body(equalTo("{}"));
    }
}
