package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class POST {

	@Test
	public void post() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "Frank_Underwood");
		jsonObject.put("projectName", "House_of_Cards"+new Java_Utility().getRanDomNumber());
		jsonObject.put("status", "To-Do");
		jsonObject.put("teanSize", 6);
		Response response = given()
		.body(jsonObject)
		.contentType(ContentType.JSON)
		.when().post("/addProject");
		
		ResponseBody responseBody = response.body();
		System.out.println(responseBody);
//		String body = responseBody.toString();
//		System.out.println(body);
		String responseBody1 = response.getBody().asPrettyString();
		System.out.println(responseBody1);
		
	}
}
