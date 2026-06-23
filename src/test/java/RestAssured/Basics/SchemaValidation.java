package RestAssured.Basics;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;

public class SchemaValidation {

    public static void main(String[] args) {

        File schemaFile = new File("src/test/java/resources/userSchema.json");

        System.out.println("Path : " + schemaFile.getAbsolutePath());
 

        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .statusCode(200)
            .body(matchesJsonSchema(schemaFile)).log().all();
        System.out.println("Schema Validation Passed");
    }
}