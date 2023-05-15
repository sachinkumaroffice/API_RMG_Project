package CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void createProject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "sachinkumar.Biradar123");
		jsonObject.put("projectName", "SIS"+ new Java_Utility().getRanDomNumber());
		jsonObject.put("status", "TO-DO");
		jsonObject.put("teamSize", 5);
		
		RequestSpecification request = RestAssured.given();
		request.body(jsonObject);
		request.contentType(ContentType.JSON);
		
		Response response = request.post("http://rmgtestingserver:8084/addProject");
		
		System.out.println(response.contentType());
	//	System.out.println(response.prettyPrint());
		//System.out.println(response.prettyPeek());
		System.out.println(response.asString());
		
	}
}
