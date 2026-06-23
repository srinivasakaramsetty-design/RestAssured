package RestAssured.Basics;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class assertions 
{
	@Test


	public void ass() {

		given()
		.pathParam("id", 1)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/{id}")
		.then()
		.statusCode(200)
		.body("id", equalTo(1))
		.body("userId", equalTo(1))
		.log().all();
	}




}
