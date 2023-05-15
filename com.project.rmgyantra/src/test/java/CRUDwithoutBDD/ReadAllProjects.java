package CRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReadAllProjects {

	@Test
	public void readProjects() {
		 RequestSpecification request = RestAssured.given();
		
		Response response = request.get("http://rmgtestingserver:8084/projects");
		
		response.then().log().all();
		
		
		//System.out.println(response.contentType());
		//System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
		//System.out.println(response.asString());
	}
}
