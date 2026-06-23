package RestAssured.Basics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class CrudOperation {

    @Test(priority = 1)
    public void getAllPosts() {

        given()
            .log().all()

        .when()
            .get("https://jsonplaceholder.typicode.com/posts")

        .then()
            .statusCode(200)
            .log().all();
    }

    @Test(priority = 2)
    public void getSingleUser() {

        given()
            .log().all()

        .when()
            .get("https://jsonplaceholder.typicode.com/users/1")

        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("name", equalTo("Leanne Graham"))
            .body("email", equalTo("Sincere@april.biz"))
            .log().all();
    }

    @Test(priority = 3)
    public void postUser() {

        HashMap<String, Object> data = new HashMap<>();

        data.put("title", "REST Assured");
        data.put("body", "API");
        data.put("userId", 14);

        given()
            .log().all()
            .contentType("application/json")
            .body(data)

        .when()
            .post("https://jsonplaceholder.typicode.com/posts")

        .then()
            .statusCode(201)
            .body("title", equalTo("REST Assured"))
            .body("body", equalTo("API"))
            .body("userId", equalTo(14))
            .log().all();
    }

    @Test(priority = 4)
    public void putUser() {

        HashMap<String, Object> data = new HashMap<>();

        data.put("id", 1);
        data.put("title", "Updated Title");
        data.put("body", "Updated Body");
        data.put("userId", 104);

        given()
            .log().all()
            .contentType("application/json")
            .body(data)

        .when()
            .put("https://jsonplaceholder.typicode.com/posts/1")

        .then()
            .statusCode(200)
            .log().all();
    }

    @Test(priority = 5)
    public void patchUser() {

        HashMap<String, Object> data = new HashMap<>();

        data.put("title", "Patched Title");

        given()
            .log().all()
            .contentType("application/json")
            .body(data)

        .when()
            .patch("https://jsonplaceholder.typicode.com/posts/1")

        .then()
            .statusCode(200)
            .log().all();
    }

    @Test(priority = 6)
    public void deleteUser() {

        given()
            .log().all()

        .when()
            .delete("https://jsonplaceholder.typicode.com/posts/1")

        .then()
            .statusCode(200)
            .log().all();
    }
}