package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class OAuth2_GET {

	@Test
	public void get() {
		baseURI = "http://coop.apps.symfonycasts.com";
//		Response response = given()
//		.formParam("client_id", "Peaky_Blinders")
//		.formParam("response_type", "token")
//		.formParam("redirect_uri", "http://unholiness.com")
//		.formParam("scope", "eggs-count profile")
//		
//		.when().post("http://coop.apps.symfonycasts.com/token");
//		
//		String token = response.jsonPath().get("access_token");
//		System.out.println(token);
//		
//		given()
//		.auth()
//		.oauth2(token)
//		.pathParam("ClientID", "4358")
		
		when().get("/api/me")
		.then().log().all();
		
							
							
	}
}
