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

public class CreateInDB_UpdateInAPI_ValidateInGUI_Test {

	@Test
	public void createInDB() throws SQLException {
		
		//Created Project in the Database
		Connection con = null;
		int result = 0;
		String project_Id = "1tyss"+new Java_Utility().getRanDomNumber();
		String created_by = "sachinkumar.Biradar";
		String created_on = "28-02-2023";
		String project_name = "SIS"+new Java_Utility().getRanDomNumber();
		System.out.println("Project_Name is "+project_name);
		String status = "completed";
		int team_Size = 23;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "insert into project values ('"+project_Id+"', '"+created_by+"', '"+created_on+"', '"+project_name+"', '"+status+"', '"+team_Size+"');";
			 result = state.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result==1) {
				System.out.println("Project created successfully in Database");
			} else {
				System.out.println("Project has not been created");
			} 
			con.close();
		}
		
		
		//Validate in the GUI and fetch the Project ID
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
		String projectID = driver.findElement(By.xpath("//td[text()='"+project_name+"']/../td[1]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(projectID, project_Id);
		System.out.println("Project_ID is = "+projectID);
		System.out.println("Project has been validated in the GUI successfully");
		driver.quit();
		
		//Update in API
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "Thomas_Shelby");
		jsonObject.put("projectName", "MF-12");
		jsonObject.put("status", "completed");
		jsonObject.put("teamSize", 99);
		
		given()
		.body(jsonObject)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/"+project_Id)
		
		.then().assertThat().statusCode(200).log().all();
		System.out.println("Project has been updated successfully in the API");
		
	}
}
