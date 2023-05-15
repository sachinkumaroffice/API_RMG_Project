package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

public class BearerToken {

	@Test
	public void bearerToken() {
		baseURI = "https://api.github.com";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "RestAssuredTesting"+ new Java_Utility().getRanDomNumber());
		
		
		given()
		.auth()
		.oauth2("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")
		.body(jsonObject)
		.contentType(ContentType.JSON)
		
		.when().post("/user/repos")
		
		.then().assertThat().statusCode(201).log().all();
	}
}
