package validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticResponseValidation() {
		
		//Pre-Condition
	  String expectedData = "TY_PROJ_11287";
	  baseURI = "http://rmgtestingserver";
	  port = 8084;
	  
	  //Action
	  Response response = when().get("/projects");
	  
	  
	  //validation
	  String actualData = response.jsonPath().get("[0].projectId");
	  Assert.assertEquals(actualData, expectedData);
	  System.out.println("Data is validated upon the verification");
	  response.then().log().all();
	}
}
