import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Handson5 {
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
		
		// Update book
		given().log().all()
		.header("Authorization", "Bearer 6ea55450f35601888189e1583193455535a96c8affceb4caf449dde415478d60")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"email\": \"Qark888@getpoo.com\",\r\n"
				+ "    \"name\": \"Bony Moo\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "}")
		.when().put(url)
		.then().assertThat().statusCode(200);
		
		
	}
}
