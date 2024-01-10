package RestAssureExamples;

import io.restassured.path.json.JsonPath;
import payloads.JsonParsing;
public class RestAssuredJSONParseTechniques {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(JsonParsing.coursePrice());
		int pur_amt = js.getInt("dashboard.purchaseAmount");
		System.out.println(pur_amt);
		String course1_title = js.getString("courses[0].title");
		System.out.println(course1_title);
		int size = js.getInt("courses.size()");
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			String title = js.getString("courses["+i+"].title");
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			System.out.println("The array"+i+"values are:");
			System.out.println("title = "+title);
			System.out.println("price = "+price);
			System.out.println("copies = "+copies);
		}

	}

}
