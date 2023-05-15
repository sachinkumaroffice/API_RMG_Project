package TwoLayerTestingUsingBaseClass;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.Database_Utility;
import genericUtility.EndPointLibrary;
import genericUtility.IPathConstants;
import genericUtility.Java_Utility;
import genericUtility.RestAssuredLibrary;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.addProject;

public class CreateInAPI_ValidateInDatabase extends BaseClass {

	
	@Test
	public void createProject() throws Throwable {
		//Step1: Create Pre-requisites
		addProject createProject = new addProject("Malinowaski", "SIS"+new Java_Utility().getRanDomNumber(), "Completed", 10);
		
		//Ste2 : Send the request
		baseURI = IPathConstants.URL;
		Response response = given()
		.body(createProject)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointLibrary.createProject);
		System.out.println("Project successfully created Through API");
		
		//Step:3 Capture the Project Id
		String expectedData = rLib.getJSONData(response, "projectId");
		System.out.println("ProjectId is ="+expectedData);
		
		
		//Step4: validate the ID in the Database
		String query = "select * from project;";
		String actualData = dLib.readDataFromDBAndValidate(query, 1, expectedData);
		Assert.assertEquals(actualData, expectedData);
		System.out.println("Project has been validated upon the verification successfully");
 		response.then().log().all();
	}
}
