import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Handson2 {

	public static void main(String[] args)  {
		
		// given - all input details
		// when - submit the api  / resource http
		// then - validate the response
		
		RestAssured.baseURI= "https://gorest.co.in";
		given().log().all().given().queryParam("id","6990467")
		.header("Authorization", "Bearer 6ea55450f35601888189e1583193455535a96c8affceb4caf449dde415478d60")
		.header("Content-Type","application/json")
		//.header("Content-Length", "<calculated when request is sent>")
		//.header("host", "<calculated when request is sent>")
		//.header("User-Agent","PostmanRuntime/7.37.3")
		//.header("Accept-Encoding","gzip, deflate, br")
		//.header("Connection","keep-alive")
		
		.when().get("public/v2/users/")
		.then().log().all().statusCode(200);
		
	
	}

}
