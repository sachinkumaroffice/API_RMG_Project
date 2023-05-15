package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import pojoclass.addProject;

import static io.restassured.RestAssured.*;

public class DataDrivenTesting_DataProvider {
	
	@DataProvider
	public Object[][] projects() {
		
		Object[][] data = new Object[3][4];
		
		data[0][0] = "sachinkumar";
		data[0][1]  = "Sales_And_Inventory_System"+ new Java_Utility().getRanDomNumber();
		data[0][2]  =  "In-Progress";
		data[0][3]    =  3;
		
		data[1][0] = "sanjaykumar";
		data[1][1]  = "SIS"+ new Java_Utility().getRanDomNumber();
		data[1][2]  =  "To-Do";
		data[1][3]    =  7;
		
		data[2][0] = "santosh";
		data[2][1]  = "constructions_limited"+ new Java_Utility().getRanDomNumber();
		data[2][2]  =  "completed";
		data[2][3]    =  55;
		
		return data;
	}
	
	@Test (dataProvider = "projects")
	public void createProjects(String createdBy, String projectName, String status, int teamSize) {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		addProject project = new addProject(createdBy, projectName, status, teamSize);
		given().body(project).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
