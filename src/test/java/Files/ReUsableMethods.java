package Files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

	public static JsonPath rawToJson(String response) {
		JsonPath js1 = new JsonPath(response);
		return js1;
	}
}

/*
 * <dependency> <groupId>io.cucumber</groupId>
 * <artifactId>cucumber-junit</artifactId> <version>4.8.0</version>
 * <scope>test</scope> </dependency>
 */