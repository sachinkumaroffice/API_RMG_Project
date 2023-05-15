package threeLayerTestingUsingBaseClass;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import genericUtility.IPathConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import objectRepository.RMGYantra_CreateProject_Page;
import objectRepository.RMGYantra_Home_Page;
import objectRepository.RMGYantra_Projects_Page;
import pojoclass.addProject;

public class CreateInGUI_UpdateInAPI_DeleteteInDB extends BaseClass {

	@Test
	public void endToEndScenario4() throws Throwable  {
		
		// Create Project in GUI
		RMGYantra_Home_Page homePage = new RMGYantra_Home_Page(driver);
		homePage.clickOnProjects(wLib, driver);
		RMGYantra_Projects_Page projectsPage = new RMGYantra_Projects_Page(driver);
		projectsPage.clickOnCreateProject(wLib, driver);
		RMGYantra_CreateProject_Page createProjectPage = new RMGYantra_CreateProject_Page(driver);
		createProjectPage.createdStatusProject(eLib, jLib);
		String projectName1 = eLib.readDataFromExcelFile("rmgyantra", 3, 0);
		String projectIDfromUI = driver.findElement(By.xpath("//td[.='"+projectName1+"']/../td")).getText();
		System.out.println("Project Created successfully in GUI");
		
		
		//Update project in API
		baseURI = IPathConstants.URL;
		addProject update = new addProject("swaranSingh", "TYSS_Fireflink", "Incomplete", 0);
		Response response = given()
		.body(update)
		.contentType(ContentType.JSON)
		.when()
		.put(EndPointLibrary.updateProject+projectIDfromUI);
		
		response.then().statusCode(200).log().all();
		System.out.println("Project updated successfully in API");
		
		//Delete project in Database
		dLib.deleteDataInDBAndValidate(projectIDfromUI);
	}
}
