import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Handson6 {
public static void main(String[] args)  {
		
	// given - all input details
	// when - submit the api  / resource http
	// then - validate the response
	
	RestAssured.baseURI= "https://gorest.co.in";
	String response = given().log().all()
	.header("Authorization", "Bearer 6ea55450f35601888189e1583193455535a96c8affceb4caf449dde415478d60")
	.header("Content-Type","application/json")
	.body(payload.AddBook()).when().post("public/v2/users/")
	.then().statusCode(201)
	//.body("ID",equalTo("bce6927"))
	.header("Server", "cloudflare").extract().response().asString();
	//add book >> update book author >> get book to see if author details is present in response
	
	System.out.println(response);
	
	JsonPath js = new JsonPath(response);  //for parsing Json
	String empid = js.getString("id");
	System.out.println(empid);
	
	String url = String.format("/public/v2/users/%s",empid);
	
	String newEmail = "pooman2@getpoo.com";
	// Update book
	given().log().all()
	.header("Authorization", "Bearer 6ea55450f35601888189e1583193455535a96c8affceb4caf449dde415478d60")
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "    \"email\": \""+newEmail+"\",\r\n"
			+ "    \"name\": \"Go6y Koo\",\r\n"
			+ "    \"gender\": \"male\",\r\n"
			+ "    \"status\": \"active\"\r\n"
			+ "}")
	.when().put(url)
	.then().assertThat().statusCode(200);
	
	
	
	// get book
	
	String response2 = given().log().all()
	.header("Authorization", "Bearer 6ea55450f35601888189e1583193455535a96c8affceb4caf449dde415478d60")
	.header("Content-Type","application/json")
	//.queryParam("id", empid)
	.when().get(url)
	.then().assertThat().log().all().statusCode(200)
	
	.extract().response().asString();
	
	System.out.println(response2);
	
	
	JsonPath js2 = new JsonPath(response2);   //for parsing json
	String emailid = js2.getString("email");
	System.out.println(emailid);
	
	
	//junit TestNG
	Assert.assertEquals(emailid,newEmail);
	
		
	}
}
