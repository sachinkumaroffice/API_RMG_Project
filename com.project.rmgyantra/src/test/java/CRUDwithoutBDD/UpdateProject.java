package CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void modify() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "sachinkumar");
		jsonObject.put("projectName", "rmgyantra443"); 
		jsonObject.put("status", "Completed");
		jsonObject.put("teamSize", 20);
		
		RequestSpecification request = RestAssured.given();
		request.body(jsonObject);
		request.contentType(ContentType.JSON);
		
		Response response = request.put("http://rmgtestingserver:8084/projects/TY_PROJ_9559");
		System.out.println(response.prettyPeek());
	}
}
