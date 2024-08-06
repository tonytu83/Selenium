import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Handson {
	public static void main(String[] args)  {
	
		// given - all input details
		// when - submit the api  / resource http
		// then - validate the response
		
		RestAssured.baseURI= "http://216.10.245.166";
		given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Playwright\",\r\n"
				+ "\"isbn\":\"bcf\",\r\n"
				+ "\"aisle\":\"929\",\r\n"
				+ "\"author\":\"John Dick\"\r\n"
				+ "}"				
				).when().post("Library/Addbook.php")
		.then().log().all().statusCode(200);
		
	}
	

}