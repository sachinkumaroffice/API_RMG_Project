package practice;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

@Test
public class update {

	public void update() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "Thomas_Shelby");
		jsonObject.put("projectName", "MF-12");
		jsonObject.put("status", "completed");
		jsonObject.put("teamSize", 99);
		
		given()
		.body(jsonObject)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/1tyss725")
		
		.then().assertThat().statusCode(200).log().all();
	}
}
