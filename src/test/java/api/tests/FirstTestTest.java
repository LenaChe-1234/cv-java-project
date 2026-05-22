package api.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class FirstTestTest {
    @Test
    void getProductsTest() {

        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }


}
