package threeLayerTestingUsingBaseClass;

import static io.restassured.RestAssured.*;

import genericUtility.EndPointLibrary;
import genericUtility.IPathConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.addProject;

public class CreateInAPI_UpdateInDatabase_ValidateInGUI {

	
	public void endToEndScenario5() {
		
		//Create project in API
		baseURI = IPathConstants.URL;
		addProject addProject = new addProject("Joseph_Biden", "USA", "On Going", 3);
		Response response = given()
		.body(addProject)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointLibrary.createProject);
		
		response.then().assertThat().statusCode(201).log().all();
		
		//Update project in Database
		
	}
}
