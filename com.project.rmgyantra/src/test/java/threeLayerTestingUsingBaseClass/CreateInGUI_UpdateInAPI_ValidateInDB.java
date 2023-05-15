package threeLayerTestingUsingBaseClass;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import objectRepository.RMGYantra_CreateProject_Page;
import objectRepository.RMGYantra_Home_Page;
import objectRepository.RMGYantra_Projects_Page;
import pojoclass.addProject;

public class CreateInGUI_UpdateInAPI_ValidateInDB extends BaseClass {

	@Test
	public void endToEndScenario2() throws Throwable {
		
		// Create Project in GUI
		RMGYantra_Home_Page homePage = new RMGYantra_Home_Page(driver);
		homePage.clickOnProjects(wLib, driver);
		RMGYantra_Projects_Page projectsPage = new RMGYantra_Projects_Page(driver);
		projectsPage.clickOnCreateProject(wLib, driver);
		RMGYantra_CreateProject_Page createProjectPage = new RMGYantra_CreateProject_Page(driver);
		createProjectPage.createdStatusProject(eLib, jLib);
		String projectName = eLib.readDataFromExcelFile("rmgyantra", 1, 0);
		String projectIDfromUI = driver.findElement(By.xpath("//td[.='"+projectName+"']/../td")).getText();
		System.out.println("Project Created successfully in GUI");
		
		
		//Update in  API
		addProject updateProject = new addProject("Barak", "+projectName+", "Completed", 34);
		Response response = given()
		.body(updateProject)
		.contentType(ContentType.JSON)
		.when()
		.put(EndPointLibrary.updateProject+ projectIDfromUI);
		String projectID = response.jsonPath().get("projectId");
		Assert.assertEquals(projectID, projectIDfromUI);
		System.out.println("Project updated in API successfully");
		
		
		//Validate in the Database
		String query = "select * from project";
		dLib.readDataFromDBAndValidate(query, 1, projectIDfromUI);
		
	}
}
