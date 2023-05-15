package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2_FIFTH {

	@Test
	public void fifth() {
		baseURI = "http://coop.apps.symfonycasts.com";
		 Response response =  given()
		.formParam("client_id", "Peaky_Blinders")
		.formParam("client_secret", "89df30d5392c3321e024ab600f646f03")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://unholiness.com")
		.formParam("code", "authorization_code")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		 
		 String token = response.jsonPath().get("access_token");
		 System.out.println(token);
		 
		 given()
		 .auth()
		 .oauth2(token)
		 .pathParam("ClientID", "4358")
		 
		 .when().post("/api/{ClientID}/eggs-count")
		 .then().log().all();
	}
}
