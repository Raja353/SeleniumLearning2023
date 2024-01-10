package RestAssureExamples;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class RestAssureHttpMethods {
public String placeId,address;

	 
	@BeforeTest()
	public void baseURI()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	}
	@Test(priority=1, groups= {"Regression Testing"})
	public void addPlaceInMaps() throws IOException
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";	
    String response=given().log().all().queryParam("Key", "qaclick123").contentType("application/json")
    .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Venba\\eclipse-workspace\\SeleniumLearning2023\\src\\test\\resources\\payloadforPOST.json")))).when().post("/maps/api/place/add/json")
    .then().log().all().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
    System.out.println(response);
    
    JsonPath js = new JsonPath(response);
    placeId = js.getString("place_id");
    //address = "Rajasekar Street";
    System.out.println(placeId);
	}
    
    //update the address using PUt method\
	@Test(dependsOnMethods={"addPlaceInMaps"}, groups= {"Regression Testing"}, dataProvider="PayloadDta")
    public void updateAddress(String newAddress)
    {
		RestAssured.baseURI = "https://rahulshettyacademy.com";	
    String put_response = given().log().all().queryParam("Key", "qaclick123").queryParam("place_id", placeId).contentType("application/json")
    .body("{\r\n"
    		+ "\"place_id\":\""+placeId+"\",\r\n"
    		+ "\"address\":\""+newAddress+"\",\r\n"
    		+ "\"key\":\"qaclick123\"\r\n"
    		+ "}\r\n"
    		+ "").when().put("/maps/api/place/update/json").then().log().all()
        .statusCode(200).body("msg", equalTo("Address successfully updated")).extract().response().asString();
    System.out.println(put_response);
    address = newAddress;
    
    
    }
	
	@Test(dependsOnMethods="addPlaceInMaps")
	public void verifyAddress()
	{
    
    //Verify the address using get http method
    
   String getResponse =  given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).when().get("/maps/api/place/get/json").then().log().all().statusCode(200).extract().response().asString();
   
   JsonPath js2 = new JsonPath(getResponse);
   String actual_string=js2.getString("address");
   System.out.println(getResponse);
   Assert.assertEquals(actual_string,address);
   
   
   
    
	

}
	
	 @DataProvider(name="PayloadDta")
	   public Object getpayload()
	   {
		   return new Object[][] {{"Raja Street"},{"Sekar Street"},{"Archu Street"}};
	   }
			  
}
