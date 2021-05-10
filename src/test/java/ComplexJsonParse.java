import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(Payload.Courses());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		int amount = js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
		String firstCourse = js.getString("courses[0].title");
		System.out.println(firstCourse);
		
		for(int i=0; i<count;i++)
		{
			System.out.print(js.get("courses["+i+"].title").toString());
			System.out.println(js.get("courses["+i+"].price").toString());
		}
	
		for(int i=0;i<count;i++)
		{
			String course = js.get("courses["+i+"].title");
			if(course.equalsIgnoreCase("RPA"))
			//if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
			{
				int copies = js.get("courses["+i+"].copies");
			System.out.println(copies);
			break;
			}
	
		}
		
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
	}

}
