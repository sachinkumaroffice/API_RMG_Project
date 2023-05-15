package validation;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponseValidation {

	@Test
	public void dynamicResponse() {
		
		//Precondition
		String expectedData = "TY_PROJ_9629";
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		//Action
		Response response = when().get("/projects");
		
		//validation
		boolean flag = false;
		List<String> pIDs = response.jsonPath().get("projectId");
		for (String projectID : pIDs) {
			if (projectID.equalsIgnoreCase(expectedData)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("Data validated upon the verification");
		
		//response.then().log().all();
	}
}
