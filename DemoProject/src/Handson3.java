import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Handson3 {

	public static void main(String[] args)  {
		
		// given - all input details
		// when - submit the api  / resource http
		// then - validate the response
		
		RestAssured.baseURI= "https://gorest.co.in";
		given().log().all()
		.header("Authorization", "Bearer 6ea55450f35601888189e1583193455535a96c8affceb4caf449dde415478d60")
		.header("Content-Type","application/json")
		.body(payload.AddBook()).when().post("public/v2/users/")
		.then().log().all().statusCode(201)
		//.body("ID",equalTo("bce6924"))
	
		.header("Server", "cloudflare");
		
		//add book >> update book author >> get book to see if author details is present in response
		
		
		
	}
	

}
