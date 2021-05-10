import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidataion {

	@Test
	public void sumOfCources()
	{
		JsonPath js = new JsonPath(Payload.Courses());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		int amount = js.getInt("dashboard.purchaseAmount");
		int price, copy, totalcopies=0;
		for(int i=0; i<count; i++)
		{
		price=	js.getInt("courses["+i+"].price");
		copy= js.getInt("courses["+i+"].copies");
		
		totalcopies = totalcopies + (price*copy);
		}
		
		if(amount == totalcopies)
			System.out.println("correct");
		else
			System.out.println("Incorrect");
		
		Assert.assertEquals(amount, totalcopies);
		
	}
	
}
