package threeLayerTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mysql.jdbc.Driver;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateInAPI_ValidateInGUI_DeleteInDatabase_Test {

	@Test
	public void project() throws SQLException {
		//Create project in the Business layer
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "sachinkumar");
		jsonObject.put("projectName", "SIS"+new Java_Utility().getRanDomNumber());
		jsonObject.put("status", "completed");
		jsonObject.put("teamSize", 8);
		Response response = given()
		.body(jsonObject)
		.contentType(ContentType.JSON)
		.when().post("/addProject");
		String projectID = response.jsonPath().get("projectId");
		System.out.println(projectID);
		
		
		//Validate it in the GUI
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084");
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Projects"))));
		driver.findElement(By.linkText("Projects")).click();
		String projectIDfromUI = driver.findElement(By.xpath("//td[text()='"+projectID+"']")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(projectID, projectIDfromUI);
		//if (projectID.equalsIgnoreCase(projectIDfromUI)) {
			//proID = projectID;
			System.out.println("verified successfully");
		//} else {
			//System.out.println("Not verified successfully");
		//}
		driver.quit();
		
		
		//Delete the project in the database
		String actual_Project = projectID;
		Connection con = null;
		int set = 0;
		try {
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "delete from project where project_Id = '"+actual_Project+"';";
			 set = state.executeUpdate(query);
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (set==1) {
				System.out.println("deleted successfully");
			} else {
				System.out.println("Not achieved the deletion of the project");
			}
		}
		
		
		
	}
}
