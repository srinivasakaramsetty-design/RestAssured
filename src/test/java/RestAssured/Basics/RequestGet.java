package RestAssured.Basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class RequestGet {

    public static void main(String[] args) {

        Response res = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");

        res.then()
           .statusCode(200)
           .body("id", equalTo(1));
          

        System.out.println(res.asString());
    }
}