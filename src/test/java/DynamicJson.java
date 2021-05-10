import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReUsableMethods;
import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class DynamicJson {

	@Test(dataProvider = "booksData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response1 = given().log().all()
				.header("Content-Type","application/json")
		.body(Payload.AddBookPayload(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().asString(); 
		
		//System.out.println(response);
			
		JsonPath js = new JsonPath(response1);
		String bookID = js.get("ID");
		//String bookID = ReUsableMethods.rawToJson(response).get("msg");
		System.out.println(bookID);
	}
	
	/*
	 * @Test(dataProvider = "BookId") public void deleteBook(String Id) {
	 * RestAssured.baseURI="http://216.10.245.166"; String response =
	 * given().log().all().header("Content-Type", "application/json")
	 * .body(Payload.deleteBookPayload(Id)) .when().post("Library/DeleteBook.php")
	 * .then().log().all().assertThat().statusCode(200).extract().asString();
	 * 
	 * String deleteMsg = ReUsableMethods.rawToJson(response).get("msg");
	 * System.out.println(deleteMsg); }
	 */
	
	@DataProvider(name="booksData")
	public Object[][] getData()
	{
		return new Object[][] {{"grc121","GRC2123"},{"grc121","GRC3123"},{"grc121","GRC4123"}};
	}
	
	@DataProvider (name="BookId")
	public Object[] deleteData()
	{
		return new Object[] {"grc11GRC2123","grc11GRC3123","grc11GRC4123"};
	}
}
