
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class PayloadFile {

	public static void main(String[] args) throws IOException {
		/*
		 * RestAssured.baseURI="https://rahulshettyacademy.com"; String response =
		 * given().log().all().queryParam("key",
		 * "qaclick123").header("Content-Type","application/json") .body(new
		 * String(Files.readAllBytes(Path.
		 * of("C:\\Users\\govind.chetty\\eclipse-workspace\\API Project\\Payload\\Response\\AddPlaceResponse.json"
		 * )))) .when().post("maps/api/place/add/json")
		 * .then().log().all().assertThat().statusCode(200).body("scope",
		 * equalTo("APP")) .header("Server", "Apache/2.4.18 (Ubuntu)")
		 * .extract().response().asString();
		 */
		/*
		 * System.out.println(response);
		 * 
		 * JsonPath js = new JsonPath(response); String placeId =
		 * js.getString("place_id"); System.out.println(placeId);
		 */
}
}

