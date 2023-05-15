package CRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ReadSingleProject {

	@Test
	public void readProject() {
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("http://rmgtestingserver:8084/projects/TY_PROJ_9554");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.prettyPeek());
	}
}
