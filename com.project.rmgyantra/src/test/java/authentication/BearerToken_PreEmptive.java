package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken_PreEmptive {

	@Test
	public void preEmptive() {
		baseURI = "https://api.github.com";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "rest-Assured-Testing1");
		
		given()
		.auth()
		.preemptive()
		.basic("sachinkumaroffice", "Sanjay@123")
		.body(jsonObject)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().assertThat().statusCode(201).log().all();
	}
}
