import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class RegisterUser {
	public static void main(String[] args)  {
		
		// given - all input details
		// when - submit the api  / resource http
		// then - validate the response
		
		RestAssured.baseURI= "https://automationexercise.com/";
		given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"name\":\"DickMAN\",\r\n"
				+ "\"email\":\"tonydick@getnada.com\",\r\n"
				+ "\"password\":\"Fartboy1983!\",\r\n"
				+ "\"title\":\"Mr\",\r\n"
				+ "\"birth_date\":\"30\",\r\n"
				+ "\"birth_month\":\"01\",\r\n"
				+ "\"birth_year\":\"1983\",\r\n"
				+ "\"firstname\":\"DICK\",\r\n"
				+ "\"lastname\":\"POO\",\r\n"
				+ "\"company\":\"Cognizant\",\r\n"
				+ "\"address1\":\"73 LEONARD AVE\",\r\n"
				+ "\"address2\":\"PISS\", \r\n"
				+ "\"country\":\"AUS\",\r\n"
				+ "\"zipcode\":\"3046\", \r\n"
				+ "\"state\":\"VIC\",\r\n"
				+ "\"city\":\"GLENROY\",\r\n"
				+ "\"mobile_number\":\"0431811111\"\r\n"
				+ "}"				
				).when().post("api/createAccount")
		.then().log().all().statusCode(200);
		
	}
}
