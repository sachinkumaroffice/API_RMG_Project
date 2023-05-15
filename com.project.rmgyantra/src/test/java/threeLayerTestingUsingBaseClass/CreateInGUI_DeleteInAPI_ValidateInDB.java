package threeLayerTestingUsingBaseClass;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import objectRepository.RMGYantra_CreateProject_Page;
import objectRepository.RMGYantra_Home_Page;
import objectRepository.RMGYantra_Projects_Page;

public class CreateInGUI_DeleteInAPI_ValidateInDB extends BaseClass {

	@Test
	public void endToEndScenario3() throws Throwable {
		
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
		
		//Delete project in API
		baseURI = "http://rmgtestingserver:8084";
		Response response = when()
		.delete(EndPointLibrary.deleteProject+projectIDfromUI);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		
		//Validate project in the database
		String query = "select * from project";
		dLib.readDataFromDBAndValidate(query, 1, projectIDfromUI);
		System.out.println("Project successfully deleted in the API");
	}
}
