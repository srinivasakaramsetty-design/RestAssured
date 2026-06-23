package RestAssured.Basics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class APITestCases {

    // Test Case 1 - Headers
    @Test
    public void headersTest() {

        given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
        .when()
            .get("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(200)
            .log().all();
    }

    // Test Case 2 - Path Parameter
    @Test
    public void pathParamTest() {

        given()
            .pathParam("id", 1)
        .when()
            .get("https://jsonplaceholder.typicode.com/posts/{id}")
        .then()
            .statusCode(200)
            .log().all();
    }

    // Test Case 3 - Query Parameter
    @Test
    public void queryParamTest() {

        given()
            .queryParam("userId", 1)
        .when()
            .get("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(200)
            .log().all();
    }
}