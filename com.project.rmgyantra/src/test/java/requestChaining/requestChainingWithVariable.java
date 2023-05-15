package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.addProject;

public class requestChainingWithVariable {

	@Test
	public void createAndFetchProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		addProject project = new addProject("Sachinkumar", "SIS"+ new Java_Utility().getRanDomNumber(), "in-progress", 11);
		  Response response = given()
		                      .body(project)
		                      .contentType(ContentType.JSON)
		                      .when()
		                      .post("/addProject");
		  
		  
		  String projectID = response.jsonPath().get("projectId");
		  System.out.println(projectID);
		  response.then().log().all();
		  
		  
		  when().get("/projects/"+projectID)
	      .then().assertThat().statusCode(200)
		  .time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).log().all();
		  
		  
		  
	}
}
