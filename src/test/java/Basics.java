import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.ReUsableMethods;


public class Basics {
	public static void main(String[] args) {
		//validate add place api
		//given- All inputs
		//when- Submit the api
		//then- validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		//update the the address for this place id
		String newAddress = "70 winter walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{ \r\n"
				+ "\r\n"
				+ "\"place_id\":\""+placeId+"\", \r\n"
				+ "\r\n"
				+ "\"address\":\""+newAddress+"\", \r\n"
				+ "\r\n"
				+ "\"key\":\"qaclick123\" \r\n"
				+ "\r\n"
				+ "} ")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		//Verify address using get place api
		String getResponse = given().log().all()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200)
		.body("address", equalTo(newAddress)).extract().asString();
		
		
		String address = ReUsableMethods.rawToJson(getResponse).get("address");
		System.out.println(address);
		
		Assert.assertEquals(address, "newAddress");
	}

}
