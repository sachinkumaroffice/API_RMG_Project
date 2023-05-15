package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.addProject;

public class requestChainingWithPathParameter {

	@Test
	public void createProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		//Step 01: Create a project using POJO Class
		addProject project = new addProject("Sachinkumar", "SIS"+ new Java_Utility().getRanDomNumber(), "completed", 9);
		               Response response = given()
		                                  .body(project)
		                                  .contentType(ContentType.JSON)
		                                  .when()
		                                  .post("/addProject");
		  
		               
		        //Step 02: The mechanism to capture the projectID
		               String projectID = response.jsonPath().get("projectId");
		               System.out.println(projectID);
		               response.then().log().all();
		               
		        //Step 03: Read the project with the help of path parameter
		               given().pathParam("PID", projectID)
		               .when().get("/projects/{PID}")
		               .then().assertThat().statusCode(200).log().all();
	}
}
