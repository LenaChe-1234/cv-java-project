<<<<<<< HEAD
//package api;
//
//import base.BaseUiTest;
//import io.qameta.allure.Feature;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.notNullValue;
//
//@Epic("API")
//@Feature("Products")
//class ProductsApiTests extends BaseUiTest {
//    @Test
//    void listProducts_hasExpectedFields() {
//        given().when()
//                .get("/Products")
//                .then()
//                .statusCode(200)
//                .body("data", notNullValue())
//                .body("data[0].id", notNullValue())
//                .body("data[0].name", notNullValue());
//    }
//}
=======
package api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@Epic("API")
@Feature("Products")
class ProductsApiTests extends BaseApiTest {
    @Test
    void listProducts_hasExpectedFields() {
        given().when()
                .get("/Products")
                .then()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data[0].id", notNullValue())
                .body("data[0].name", notNullValue());
    }
}
>>>>>>> origin/main
