import static io.restassured.RestAssured.given;

import component.Endpoint;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import page.Order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class Practice {

    @BeforeAll
    public static void prepareLogsFilter() {
        RestAssured.filters(new RequestLoggingFilter(), new RequestLoggingFilter());
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @ParameterizedTest
    @EnumSource(value = ContentType.class, names = {"XML","JSON"})
    void example1(ContentType contentType) {
        given()
            .accept(contentType)
            .pathParam("petId", "9")
            .when()
            .get(Endpoint.FIND_PET_BY_ID)
            .then()
            .statusCode(200)
            .contentType(contentType);
    }

    @Test
    void example2() {
        Order order = new Order(0L, 0L, 0L, "2023-06-27T18:57:01.919Z", "placed", true);
        Order orderResponse = given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(order)
            .when()
            .post(Endpoint.STORE_ORDER)
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract()
            .response()
            .as(Order.class);

        Assertions.assertEquals(order, orderResponse);

    }
}
