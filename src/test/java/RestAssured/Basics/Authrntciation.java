package RestAssured.Basics;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Authrntciation 
{
	@Test
	public void m1() 
	{
		// Basic Authentication sends username and password in encoded format with every request.

		given()
		.auth()
		.basic("username", "password")
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.statusCode(200).log().all();

		// bearer token : Bearer Token Authentication is used to access secured APIs by sending a token in the request header.

		// After successful login, the server generates a token, and the client uses that token for subsequent API requests.
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3ODIxOTA4MjAsImV4cCI6MTc4MjE5NDQyMH0.mUPAqswDoG358tkigyWbvLghDAGOlRAkpe2N73XxxSk"; 
		given()
		.header("Authorization", "Bearer " + token)

		.when()
		.get("https://dummyjson.com/auth/me")

		.then()
		.statusCode(200)
		.log().all();

		// digetsive authenctication : Sends a hashed value of username, password, nonce, and other data.

		given()
		.auth()
		.digest("admin", "password")

		.when()
		.get("https://httpbin.org/digest-auth/auth/admin/password")

		.then()
		.statusCode(200)
		.log().all();

		System.out.println("Digest Authentication Passed");


	}

}
