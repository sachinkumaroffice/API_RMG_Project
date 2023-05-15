package threeLayerTestingUsingBaseClass;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import genericUtility.IPathConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import objectRepository.RMGYantra_Home_Page;
import pojoclass.addProject;

public class CreateInAPI_ValidateInGUI_DeleteInDatabase_Test extends BaseClass {

	
	@Test
	public void endToEndScenario1() throws Throwable {
		//Create Project in API using POJO Class
		baseURI = IPathConstants.URL;
		addProject createProject = new addProject("T.A.Edisson", "Electric_Bulb"+jLib.getRanDomNumber(), "Created", 5);
		Response response = given()
		.body(createProject)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointLibrary.createProject);
		
		String projectID = response.jsonPath().get("projectId");
		System.out.println(projectID);
		
		//Validate in GUI
		RMGYantra_Home_Page homePage = new RMGYantra_Home_Page(driver);
		homePage.clickOnProjects(wLib, driver);
		String projectIDfromUI = driver.findElement(By.xpath("//td[text()='"+projectID+"']")).getText();
		if (projectIDfromUI.equalsIgnoreCase(projectID)) {
			System.out.println("Validated in GUI successfully");
		} else {
			System.out.println("Validation in the GUI failed");
		}
		
		
		//Delete in Database
		dLib.deleteDataInDBAndValidate(projectID);
	}
	
}
