package CRUDwithoutBDD;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteProject {

	@Test
	public void deleteProject() {
		 RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("http://rmgtestingserver:8084/projects/TY_PROJ_9924");
		response.then().log().all();
		int statusCode = response.getStatusCode();
	    Assert.assertEquals(statusCode, 204);
		//System.out.println(response.asString());
		//System.out.println(response.prettyPeek());
		
	}
}
